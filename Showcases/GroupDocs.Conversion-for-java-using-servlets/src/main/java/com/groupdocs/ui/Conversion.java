package com.groupdocs.ui;

import com.groupdocs.conversion.License;
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.CellsSaveOptions;
import com.groupdocs.conversion.converter.option.HtmlSaveOptions;
import com.groupdocs.conversion.converter.option.ImageSaveOptions;
import com.groupdocs.conversion.converter.option.LoadOptions;
import com.groupdocs.conversion.converter.option.PdfSaveOptions;
import com.groupdocs.conversion.converter.option.SaveOptions;
import com.groupdocs.conversion.converter.option.SlidesSaveOptions;
import com.groupdocs.conversion.converter.option.WordsSaveOptions;
import com.groupdocs.conversion.domain.ConversionType;
import com.groupdocs.conversion.handler.ConversionHandler;
import com.groupdocs.foundation.utils.wrapper.stream.GroupDocsInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@WebServlet("/convert")
public class Conversion extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		// It is assumed that we are redirected here by Upload servlet
    	
		//Initializing Configuration
    	try{
    		
    		//Applying License
    		License license = new License();
            if (Files.isReadable(FileSystems.getDefault().getPath(getProjectProperty("license.path")))) {
                license.setLicense(getProjectProperty("license.path"));
                if (!License.isValidLicense()) {
                    throw new RuntimeException("License is not valid");
                }
            }
    		
    		// We already know paths of source conversion-type
        	Path source = (Path) request.getSession().getAttribute("source");
        	
			// Setup Conversion configuration
	        ConversionConfig conversionConfig = new ConversionConfig();
	        conversionConfig.setStoragePath(source.getParent().toString());
	        
	        //Getting conversion type
	        int conversionType = (int) request.getSession().getAttribute("conversion-type");

	        // Guess the extension of result file and set savOptions according to extention
	    	SaveOptions saveOptions = new ImageSaveOptions();
	        String ext = "";
	        switch (conversionType) {
	            case ConversionType.WORDS:
	                ext = "docx";
	                saveOptions = new WordsSaveOptions();
	                break;
	            case ConversionType.CELLS:
	                ext = "xlsx";
	                saveOptions = new CellsSaveOptions();
	                break;
	            case ConversionType.PDF:
	                ext = "pdf";
	                saveOptions = new PdfSaveOptions();
	                break;
	            case ConversionType.SLIDES:
	                ext = "pptx";
	                saveOptions = new SlidesSaveOptions();
	                break;
	            case ConversionType.HTML:
	                ext = "html";
	                saveOptions = new HtmlSaveOptions();
	                break;
	            case ConversionType.IMAGE:
	                ext = "jpeg";
	                break;
	        }
	        
	        //Inititalizing the Conversion Handler
	        ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
	    	LoadOptions loadOptions = null;
	        
	        //Checking output extension
	        if(ext == "jpeg"){
	        	//Converting Document to Image
	        	List<GroupDocsInputStream> converted = conversionHandler
	    				.<List<GroupDocsInputStream>> convert(source.getFileName().toString(), new ImageSaveOptions());
	        	
	        	List<Path> Pages = new ArrayList<Path>();
	        	int i = 0;
	        	for(GroupDocsInputStream SinglePage: converted){
	        		//Creating temporary file to save Converted File data
	                Path Page = Files.createTempFile(Integer.toString(i) + "groupdocs-conversion-result-", "." + ext);
	                
	                //Copying converted file data into temporary file
	                Files.copy(SinglePage.toInputStream(), Page, StandardCopyOption.REPLACE_EXISTING);
	                
	                Pages.add(Page); 
	                i++;
	        	}
	        	Path Zip = Files.createTempFile("groupdocs-conversion-result-", ".zip");
	        	addImagesToZip(Pages, Zip);
	        	request.getSession().setAttribute("result", Zip);
	        	
	        }
	        else{
	            //Converting Document
	            GroupDocsInputStream converted = conversionHandler.convert(source.getFileName().toString(), saveOptions);
	            
	            //Creating temporary file to save Converted File data
	            Path result = Files.createTempFile("groupdocs-conversion-result-", "." + ext);
	            
	            //Copying converted file data into temporary file
	            Files.copy(converted.toInputStream(), result, StandardCopyOption.REPLACE_EXISTING);
	            
	            
	            request.getSession().setAttribute("result", result);
	        }
	        
		}
		catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
        
        response.sendRedirect("download");

    }
    
    //Enclosing all pages in a zip file (While converting to Images only)
    public void addImagesToZip(List<Path> Pages, Path ZipFile){
    	byte[] buffer = new byte[2048];
    	try{
    		FileOutputStream fileOutputStream = new FileOutputStream(ZipFile.toFile());
        	ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        	for(Path Page : Pages){	
        		ZipEntry zipEntry= new ZipEntry(Page.getFileName().toString());
            	zipOutputStream.putNextEntry(zipEntry);
            	FileInputStream fileInputStream = new FileInputStream(Page.toFile());
            	int length;
            	while ((length = fileInputStream.read(buffer)) > 0) {
            		zipOutputStream.write(buffer, 0, length);
            	}

            	fileInputStream.close();
        	}
        	zipOutputStream.closeEntry();
        	//remember close it
        	zipOutputStream.close();
    	}
    	catch(IOException ex){
    		ex.printStackTrace();
    		}
    }
    
    //Getting project properties
    public static String getProjectProperty(String name) {
        Properties properties = new Properties();
        try (InputStream inputStream = Conversion.class.getResourceAsStream("/project.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            // Ignore
        }
        return properties.getProperty(name);
    }
}

