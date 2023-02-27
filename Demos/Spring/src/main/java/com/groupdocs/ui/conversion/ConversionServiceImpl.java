package com.groupdocs.ui.conversion;

import com.google.common.collect.Ordering;
import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.SavePageStream;
import com.groupdocs.conversion.contracts.documentinfo.IDocumentInfo;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.licensing.License;
import com.groupdocs.conversion.options.convert.ConvertOptions;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;
import com.groupdocs.ui.config.DefaultDirectories;
import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.model.request.ConversionPostedData;
import com.groupdocs.ui.model.request.FileTreeRequest;
import com.groupdocs.ui.model.response.ConversionTypesEntity;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static com.groupdocs.ui.util.Utils.*;

@Service
public class ConversionServiceImpl implements ConversionService {
    private static final Logger logger = LoggerFactory.getLogger(ConversionServiceImpl.class);
    @Autowired
    private ConversionConfiguration conversionConfiguration;
    @Autowired
    private GlobalConfiguration globalConfiguration;

    private List<String> supportedImageFormats =  Arrays.asList( "jp2", "ico", "psd", "svg", "bmp", "jpeg", "jpg", "tiff", "tif", "png", "gif", "emf", "wmf", "dwg", "dicom", "dxf", "jpe", "jfif" );

    /**
     * Initializing fields after creating configuration objects
     */
    @PostConstruct
    public void init() {
        // check files directories
        String filesDirectory = conversionConfiguration.getFilesDirectory();
        String resultDirectory = conversionConfiguration.getResultDirectory();
        DefaultDirectories.makeDirs(new File(resultDirectory));
        // set GroupDocs license
        try {
            License license = new License();
            license.setLicense(globalConfiguration.getApplication().getLicensePath());
        } catch (Throwable exc) {
            logger.error("Can not verify Conversion license!");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ConversionTypesEntity> loadFiles(FileTreeRequest fileTreeRequest) {
        String currentPath = fileTreeRequest.getPath();
        if (StringUtils.isEmpty(currentPath)) {
            currentPath = conversionConfiguration.getFilesDirectory();
        } else {
            currentPath = String.format("%s%s%s", conversionConfiguration.getFilesDirectory(), File.separator, currentPath);
        }
        File directory = new File(currentPath);
        List<ConversionTypesEntity> fileList = new ArrayList<>();
        List<File> filesList = Arrays.asList(directory.listFiles());
        try {
            // sort list of files and folders
            filesList = Ordering.from(FILE_TYPE_COMPARATOR).compound(FILE_NAME_COMPARATOR).sortedCopy(filesList);
            for (File file : filesList) {
                // check if current file/folder is hidden
                if (file.isHidden()) {
                    // ignore current file and skip to next one
                    continue;
                } else {
                    ConversionTypesEntity fileDescription = getFileDescriptionEntity(file);
                    // add object to array list
                    fileList.add(fileDescription);
                }
            }
            return fileList;
        } catch (Exception ex) {
            logger.error("Exception occurred while load file tree");
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConversionConfiguration getConversionConfiguration() {
        return conversionConfiguration;
    }

    public ResponseEntity download(String path) throws IOException {
        if(path != null && !path.isEmpty()){

            String destinationPath = FilenameUtils.concat(conversionConfiguration.getResultDirectory(),path);
            String ext = FilenameUtils.getExtension(destinationPath);
            String fileNameWithoutExt = FilenameUtils.removeExtension(path);
            if(supportedImageFormats.contains(ext)){
                String zipName = fileNameWithoutExt + ".zip";
                File zipPath = new File(FilenameUtils.concat(conversionConfiguration.getResultDirectory(),zipName));
                File[] files = new File(conversionConfiguration.getResultDirectory()).listFiles((d, name) ->
                    name.endsWith("." + ext) && name.startsWith(fileNameWithoutExt)
                );
                if(zipPath.exists()){
                    zipPath.delete();
                }
                ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath));
                for (File filePath : files) {
                    File fileToZip = filePath;
                    zipOut.putNextEntry(new ZipEntry(fileToZip.getName()));
                    Files.copy(fileToZip.toPath(), zipOut);
                }
                zipOut.close();
                destinationPath = zipPath.getAbsolutePath();
            }
            if(new File(destinationPath).exists()){
                InputStreamResource content = new InputStreamResource(new FileInputStream(new File(destinationPath)));
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header("Content-Disposition", "attachment; filename=" + FilenameUtils.getName(destinationPath))
                        .body(content);
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void convert(ConversionPostedData postedData) {
        String sourceType = FilenameUtils.getExtension(postedData.getGuid());
        String destinationType = postedData.getDestinationType();
        String destinationFile = FilenameUtils.removeExtension(FilenameUtils.getName(postedData.getGuid())) + "." + destinationType;
        String resultFileName = FilenameUtils.concat(conversionConfiguration.getResultDirectory(),destinationFile);

        Converter converter = new Converter(FilenameUtils.concat(conversionConfiguration.getFilesDirectory(), postedData.getGuid()));
        ConvertOptions convertOptions = converter.getPossibleConversions().getTargetConversion(destinationType).getConvertOptions();
        if (convertOptions instanceof ImageConvertOptions) {
            converter.convert((SavePageStream) i -> {
                try {
                    return new FileOutputStream(FilenameUtils.removeExtension(resultFileName) + "-page" + i + "." + destinationType);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }, convertOptions);
        } else {
            converter.convert(resultFileName, convertOptions);
        }
    }


    /**
     * Create file description
     *
     * @param file file
     * @return file description
     */
    private ConversionTypesEntity getFileDescriptionEntity(File file) {
        ConversionTypesEntity fileDescription = new ConversionTypesEntity();
        // set path to file
        fileDescription.setGuid(file.getAbsolutePath());
        // set file name
        fileDescription.setName(file.getName());
        // set is directory true/false
        fileDescription.setDirectory(file.isDirectory());
        // set file size
        fileDescription.setSize(file.length());

        String ext = parseFileExtension(fileDescription.getGuid());
        if(ext != null && !ext.isEmpty()){
            fileDescription.conversionTypes = new ArrayList<>();
            String[] availableTypes = new DestinationTypesFilter().getPosibleConversions(ext);
            for(String type : availableTypes){
                fileDescription.conversionTypes.add(type);
            }
        }
        return fileDescription;
    }

}
