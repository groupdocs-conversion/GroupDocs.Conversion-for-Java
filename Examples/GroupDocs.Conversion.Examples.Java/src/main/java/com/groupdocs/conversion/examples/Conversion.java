package com.groupdocs.conversion.examples;

import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
 
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.handler.ConversionCompleteEventArgs;
import com.groupdocs.conversion.handler.ConversionCompleteHandler;
import com.groupdocs.conversion.handler.ConversionHandler;
import com.groupdocs.conversion.handler.ConversionProgressEventArgs;
import com.groupdocs.conversion.handler.ConversionProgressHandler;
import com.groupdocs.conversion.handler.ConversionStartEventArgs;
import com.groupdocs.conversion.handler.ConversionStartHandler;
import com.groupdocs.conversion.handler.ConvertedDocument;
import com.groupdocs.conversion.handler.DocumentInfo;
import com.groupdocs.conversion.handler.PdfConversionCompleteEventArgs;
import com.groupdocs.conversion.handler.output.IOutputDataHandler;
import com.groupdocs.conversion.options.load.EmailLoadOptions;
import com.groupdocs.conversion.options.load.LoadOptions;
import com.groupdocs.conversion.options.load.XmlLoadOptions;
import com.groupdocs.conversion.options.save.CellsSaveOptions;
import com.groupdocs.conversion.options.save.HtmlSaveOptions;
import com.groupdocs.conversion.options.save.ImageSaveOptions;
import com.groupdocs.conversion.options.save.PdfFormattingOptions;
import com.groupdocs.conversion.options.save.PdfSaveOptions;
import com.groupdocs.conversion.options.save.PsdOptions;
import com.groupdocs.conversion.options.save.SaveOptions;
import com.groupdocs.conversion.options.save.SlidesSaveOptions;
import com.groupdocs.conversion.options.save.WatermarkOptions;
import com.groupdocs.conversion.options.save.WordsSaveOptions;
//import com.groupdocs.conversion.internal.c.a.d.Metered;
import com.groupdocs.foundation.domain.FileType;
import com.groupdocs.foundation.license.aspose.metered.Metered;
import com.groupdocs.foundation.utils.wrapper.stream.GroupDocsInputStream;

public class Conversion {

	// region Convert to spreadsheet

	/*
	 * Convert document to spreadsheet and get result as file path
	 */
	public static void convertToCellsAsFilePath(String fileName) {
		//ExStart:convertToCellsAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		CellsSaveOptions saveOption = new CellsSaveOptions(); 
		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert(fileName, saveOption);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		System.out.print("Converted file path is: " + convertedDocumentPath);
		//ExEnd:convertToCellsAsFilePath
	}

	/*
	 * Convert document to spreadsheet and get result as stream
	 */
	public static void convertToCellsAsStream(String fileName) {
		//ExStart:convertToCellsAsStream
		// instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ConvertedDocument convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new CellsSaveOptions());
		//ExEnd:convertToCellsAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToCellsAsPath(String fileName) {
		//ExStart:convertProtectedFilesToCellsAsPath
		// instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// convert file to Xls, starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new CellsSaveOptions();
		saveOptions.setConvertFileType(CellsSaveOptions.CellsFileType.Xls);
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2); 

		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		System.out.println(convertedDocumentPath);
		//ExEnd:convertProtectedFilesToCellsAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream to the converted file
	 */
	public static void convertProtectedFilesToCellsAsStream(String fileName) {
		//ExStart:convertProtectedFilesToCellsAsStream
		// instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// convert file to Xls, starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new CellsSaveOptions();
		saveOptions.setConvertFileType(CellsSaveOptions.CellsFileType.Xls);
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);

		ConvertedDocument convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToCellsAsStream
	}
	// endregion Convert to spreadsheet

	// region Convert to word

	/*
	 * convert document to word and get result as path
	 */
	public static void convertToWordAsFilePath(String fileName) {
		//ExStart:convertToWordAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		WordsSaveOptions saveOption = new WordsSaveOptions(); 
		// Set absolute path to file
		String guid = fileName;
		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		System.out.print("Converted file path is: " + convertedDocumentPath);
		//ExEnd:convertToWordAsFilePath
	}

	/*
	 * convert document to word and get result as stream
	 */
	public static void convertToWordAsStream(String fileName) {
		//ExStart:convertToWordAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		ConvertedDocument convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert("PDFsample.pdf",
				new WordsSaveOptions());
		//ExEnd:convertToWordAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToWordAsPath(String fileName) {
		//ExStart:convertProtectedFilesToWordAsPath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert file to Doc, starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new WordsSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setConvertFileType(WordsSaveOptions.WordsFileType.Doc); 

		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		//ExEnd:convertProtectedFilesToWordAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToWordAsStream(String fileName) {
		//ExStart:convertProtectedFilesToWordAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert file to Doc, starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new WordsSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setConvertFileType(WordsSaveOptions.WordsFileType.Doc);
		ConvertedDocument convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToWordAsStream
	}

	// endregion Convert to word

	// region Convert to Html

	/*
	 * Convert document to html and get result as file path
	 */
	public static void convertToHtmlAsFilePath(String fileName) {
		//ExStart:convertToHtmlAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		HtmlSaveOptions saveOption = new HtmlSaveOptions(); 
		EmailLoadOptions emailOptions = saveOption.getEmailOptions();
		emailOptions.setDisplayHeader(true);
		emailOptions.setDisplayEmailAddress(true);        
		emailOptions.setDisplayFromEmailAddress(true);
		emailOptions.setDisplayToEmailAddress(true);
		emailOptions.setDisplayCcEmailAddress(true);
		emailOptions.setDisplayBccEmailAddress(true);
		// Set absolute path to file
		String guid = fileName;

		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		System.out.print("Converted file path is: " + convertedDocumentPath);
		//ExEnd:convertToHtmlAsFilePath
	}

	/*
	 * Convert document to html and get result as stream
	 */
	public static void convertToHtmlAsStream(String fileName) {
		//ExStart:convertToHtmlAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		ConvertedDocument convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new HtmlSaveOptions());
		//ExEnd:convertToHtmlAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToHtmlAsPath(String fileName) {
		//ExStart:convertProtectedFilesToHtmlAsPath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert starting from page 2 and convert 2 pages
		HtmlSaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2); 

		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		//ExEnd:convertProtectedFilesToHtmlAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToHtmlAsStream(String fileName) {
		//ExStart:convertProtectedFilesToHtmlAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Сonvert starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);

		ConvertedDocument convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToHtmlAsStream
	}

	// endregion Convert to Html

	// region Convert to Image

	/*
	 * Convert document to image and get result as image path
	 */
	public static void convertToImageAsFilePath(String fileName) {
		//ExStart:convertToImageAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		SaveOptions saveOption = new ImageSaveOptions();
		//ImageFileType enumeration contains the following members:
		//BMP, GIF, ICO, JP2, JPEG, JPG, PNG, PSD, SVG, TIF, TIFF, WEBP
		saveOption.setConvertFileType(ImageSaveOptions.ImageFileType.JPG); 
		 
		ConvertedDocument convertedDocumentPath = conversionHandler.<List<String>>convert(fileName, saveOption);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		//ExEnd:convertToImageAsFilePath
	}

	/*
	 * Convert document to image and get result as stream
	 */
	public static void convertToImageAsStream(String fileName) {
		//ExStart:convertToImageAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ConvertedDocument convertedDocumentStream = conversionHandler
				.<List<GroupDocsInputStream>> convert(fileName, new ImageSaveOptions());
		//ExEnd:convertToImageAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted image
	 */
	public static void convertProtectedFilesToImageAsPath(String fileName) {
		//ExStart:convertProtectedFilesToImageAsPath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Сonvert file to Tiff, starting from page 2 and convert 2 pages,
		// use DPI 300, image width 1024, image height 768
		ImageSaveOptions saveOptions = new ImageSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		//saveOptions.setDpi(300);
		saveOptions.setWidth(1024);
		saveOptions.setHeight(768);
		//FileType enumeration contains many file formats not limited to:
		//Bmp, Cgm, Csv, Dcm, Dgn, Djvu, Dng, Doc, Docm, Docx, Dot
		saveOptions.setConvertFileType(FileType.Tiff); 

		ConvertedDocument convertedDocumentPath = conversionHandler.<List<String>> convert(fileName, loadOptions,
				saveOptions);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		//ExEnd:convertProtectedFilesToImageAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToImageAsStream(String fileName) {
		//ExStart:convertProtectedFilesToImageAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Сonvert file to Tiff, starting from page 2 and convert 2 pages,
		// use DPI 300, image width 1024, image height 768
		ImageSaveOptions saveOptions = new ImageSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2); 
		saveOptions.setWidth(1024);
		saveOptions.setHeight(768); 
		//FileType enumeration contains many file formats not limited to:
		//Bmp, Cgm, Csv, Dcm, Dgn, Djvu, Dng, Doc, Docm, Docx, Dot
		saveOptions.setConvertFileType(FileType.Tiff);

		ConvertedDocument convertedDocumentStream = conversionHandler
				.<List<GroupDocsInputStream>> convert(fileName, loadOptions, saveOptions);
		//ExEnd:convertProtectedFilesToImageAsStream
	}

	// region Convert to Image

	// region Convert to pdf

	/*
	 * Convert document to pdf and get result as pdf path
	 */
	public static void convertToPdfAsFilePath(String fileName) {
		//ExStart:convertToPdfAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		PdfSaveOptions saveOption = new PdfSaveOptions(); 
		//set page mode and layout
		saveOption.getPdfOptions().getFormatingOptions().setPageMode(PdfFormatingOptions.PdfPageMode.FullScreen);
		saveOption.getPdfOptions().getFormatingOptions().setPageLayout(PdfFormatingOptions.PdfPageLayout.SinglePage);
		
		// Set absolute path to file
		String guid = fileName;

		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		System.out.print("Converted file path is: " + convertedDocumentPath);
		//ExEnd:convertToPdfAsFilePath
	}

	/*
	 * Convert document to pdf and get result as stream
	 */
	public static void convertToPdfAsStream(String fileName) {
		//ExStart:convertToPdfAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ConvertedDocument convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new PdfSaveOptions());
		//ExEnd:convertToPdfAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToPdfAsPath(String fileName) {
		//ExStart:convertProtectedFilesToPdfAsPath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert starting from page 2 and convert 2 pages,
		// use DPI 300, page width 1024, page height 768
		PdfSaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setDpi(300);
		saveOptions.setWidth(1024);
		saveOptions.setHeight(768); 

		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		//ExEnd:convertProtectedFilesToPdfAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToPdfAsStream(String fileName) {
		//ExStart:convertProtectedFilesToPdfAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert starting from page 2 and convert 2 pages,
		// use DPI 300, page width 1024, page height 768
		PdfSaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setDpi(300);
		saveOptions.setWidth(1024);
		saveOptions.setHeight(768);

		ConvertedDocument convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions); 
		//ExEnd:convertProtectedFilesToPdfAsStream
	}

	// region Convert to pdf

	// region Convert to slides

	/*
	 * Convert document to slide and get result as file path
	 */
	public static void convertToSlideAsFilePath(String fileName) {
		//ExStart:convertToSlideAsFilePath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		SlidesSaveOptions saveOption = new SlidesSaveOptions();
		//saveOption.setOutputType(OutputType.String);

		// Set absolute path to file
		String guid = fileName;

		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		//ExEnd:convertToSlideAsFilePath
	}

	/*
	 * Convert document to slide and get result as stream
	 */
	public static void convertToSlideAsStream(String fileName) {
		//ExStart:convertToSlideAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ConvertedDocument convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new SlidesSaveOptions()); 
		//ExEnd:convertToSlideAsStream
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToSlideAsPath(String fileName) {
		//ExStart:convertProtectedFilesToSlideAsPath
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert file to Ppt, starting from page 2 and convert 2 pages,
		SaveOptions saveOptions = new SlidesSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setConvertFileType(SlidesSaveOptions.SlidesFileType.Ppt); 

		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		//ExEnd:convertProtectedFilesToSlideAsPath
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToSlideAsStream(String fileName) {
		//ExStart:convertProtectedFilesToSlideAsStream
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert file to Ppt, starting from page 2 and convert 2 pages,
		SaveOptions saveOptions = new SlidesSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setConvertFileType(SlidesSaveOptions.SlidesFileType.Ppt);

		ConvertedDocument convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions); 
		//ExEnd:convertProtectedFilesToSlideAsStream
	}

	// endregion Convert to slides

	// region custom input data handler

	public static void inputDataHandler(String fileName) {
		//ExStart:inputDataHandler
		// Instantiating the conversion handler
		AmazonInputDataHandler inputDataHandler = new AmazonInputDataHandler("AccessKey", "SecretKey");
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		ConvertedDocument convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new PdfSaveOptions());
		convertedDocumentPath.save(fileName + "." + convertedDocumentPath.getFileType());
		//ExEnd:inputDataHandler
	}

	// endregion custom input data handler

	// region custom output data handler
	public static void outputDataHanlder() {
		//ExStart:outputDataHanlder
		// Instantiating the conversion handler
		AmazonOutputDataHandler outputDataHandler = new AmazonOutputDataHandler(Utilities.getConfiguration(),
				"AccessKey", "SecretKey");
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration(),
				(IOutputDataHandler) outputDataHandler, null, null, null);
		PdfSaveOptions saveOptions = new PdfSaveOptions(); 

		ConvertedDocument convertedDocumentPath = conversionHandler.<String> convert("DOCXsample.docx", saveOptions);
		convertedDocumentPath.save("DOCXsample.docx" + "." + convertedDocumentPath.getFileType());
		//ExEnd:outputDataHanlder
	}
	// endregion custom output data handler

	// conversion progress
	public static void conversionProgress(String fileName) {
		//ExStart:conversionProgress
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		conversionHandler.ConversionProgress.add(new ConversionProgressHandler() {
			// Here is the implementation of the conversion progress handler
			// method
			@Override
			public void invoke(ConversionProgressEventArgs args) {
				System.out.println("Conversion progress: {" + args.getProgress() + "}");
			}
		});
		PdfSaveOptions saveOptions = new PdfSaveOptions();
		//saveOptions.setOutputType(OutputType.String);
		ConvertedDocument result = conversionHandler.<String> convert(fileName, saveOptions);
		result.save(fileName + "." + result.getFileType());
		System.out.println("The conversion finished. The result can be located here: " + result
				+ ". Press <<ENTER>> to exit.");
		//ExEnd:conversionProgress
	}

	// get available save options by file extension
	public static void getAvailableSaveOptionsByExtension(String sourceDocument) {
		//ExStart:getAvailableSaveOptionsByExtension
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		String file = sourceDocument.substring(sourceDocument.lastIndexOf("."));
		String documentExtension = file.substring(file.indexOf(".") + 1);
		Dictionary<String, SaveOptions> availableConversions = conversionHandler.getSaveOptions(documentExtension);

		// list all available conversions
		for (Enumeration name = availableConversions.keys(); name.hasMoreElements();) {
			System.out.println(name.nextElement());
		}

		// use prepared save option for ToPdf conversion
		ConvertedDocument result = conversionHandler.<GroupDocsInputStream> convert(sourceDocument,
				availableConversions.get("pdf"));
		result.save(sourceDocument + "." + result.getFileType());
		//ExEnd:getAvailableSaveOptionsByExtension
	}

	// get available save options by file stream
	public static void getAvailableSaveOptionsForDocumentStream(String sourceDocument) throws Throwable {
		//ExStart:getAvailableSaveOptionsByStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		FileInputStream sourceStream = new FileInputStream(sourceDocument);
		Dictionary<String, SaveOptions> availableConversions = conversionHandler
				.getSaveOptions(sourceStream);

		// list all available conversions
		for (Enumeration name = availableConversions.keys(); name.hasMoreElements();) {
			System.out.println(name.nextElement());
		}
		// use prepared save option for ToPdf conversion
		ConvertedDocument result = conversionHandler.<GroupDocsInputStream> convert(sourceStream,
				availableConversions.get("pdf")); 
		//ExEnd:getAvailableSaveOptionsByStream
	}

	// Usage of PageMode when converting to PDF
	public static void usePageModeConvertingToPdf(String sourceFileName) {
		//ExStart:usePageModeConvertingToPdf
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		PdfSaveOptions saveOptions = new PdfSaveOptions();  
		// Note: when using PageMode expected result is either IList<string> or
		// IList<Stream> depending
		// of used OutputType in save options provided
		ConvertedDocument result = conversionHandler.<List<String>> convert(sourceFileName, saveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		System.out.println(
				"The conversion finished. The result can be located here: " + result + ". Press <<ENTER>> to exit.");
		//ExEnd:usePageModeConvertingToPdf
	}

	// Usage of PageMode when converting to HTML
	public static void usePageModeConvertingToHtml(String sourceFileName) {
		//ExStart:usePageModeConvertingToHtml
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		HtmlSaveOptions saveOptions = new HtmlSaveOptions(); 

		// Note: when using PageMode expected result is either IList<string> or
		// IList<Stream> depending
		// of used OutputType in save options provided
		ConvertedDocument result = conversionHandler.<List<String>> convert(sourceFileName, saveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		System.out.println(
				"The conversion finished. The result can be located here: " + result + ". Press <<ENTER>> to exit.");
		//ExEnd:usePageModeConvertingToHtml
	}

	// adding watermark on converted documents
	public static void addWatermarkOnConvertedDocs(String sourceFileName) {
		//ExStart:addWatermarkOnConvertedDocs
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Save options
		PdfSaveOptions saveOptions = new PdfSaveOptions(); 
		WatermarkOptions watermarkOptions = new WatermarkOptions();
		watermarkOptions.setColor(Color.blue);
		watermarkOptions.setText("Watermark text");
		watermarkOptions.setFont(new Font("Arial", 40, 12));
		watermarkOptions.setRotationAngle(45);
		watermarkOptions.setTransparency(0.1);
		watermarkOptions.setLeft(200);
		watermarkOptions.setTop(400);
		saveOptions.setWatermarkOptions(watermarkOptions);

		ConvertedDocument result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		System.out.println(
				"The conversion finished. The result can be located here: " + result + ". Press <<ENTER>> to exit.");
		//ExEnd:addWatermarkOnConvertedDocs
	}

	// Convert document to psd
	public static void convertToPsd(String sourceFileName) {
		//ExStart:convertToPsd
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Save options
		ImageSaveOptions saveOptions = new ImageSaveOptions();
		//saveOptions.setOutputType(OutputType.String);
		saveOptions.setConvertFileType(ImageSaveOptions.ImageFileType.PSD);
		PsdOptions psdOptions = new PsdOptions();
		psdOptions.setColorMode(PsdOptions.ColorModes.GRAYSCALE);
		psdOptions.setCompressionMethod(PsdOptions.CompressionMethods.RAW); 
		ConvertedDocument result = conversionHandler.<List<String>> convert(sourceFileName, saveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		//ExEnd:convertToPsd
	}

	// convert from psd
	public static void convertFromPsd(String sourceFileName) {
		//ExStart:convertFromPsd
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Save options
		SaveOptions saveOptions = new PdfSaveOptions(); 
		ConvertedDocument result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		//ExEnd:convertFromPsd
	}

	// use conversion events
	public static void useConversionEvents(String sourceFileName) {
		//ExStart:useConversionEvents
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		conversionHandler.ConversionStart.add(new ConversionStartHandler() {
			@Override
			public void invoke(ConversionStartEventArgs args) {
				System.out.println("Conversion " + args.getConversionGuid() + " started");
			}
		});
		conversionHandler.ConversionProgress.add(new ConversionProgressHandler() {
			@Override
			public void invoke(ConversionProgressEventArgs args) {
				System.out
						.println("Conversion " + args.getConversionGuid() + " progress: " + args.getProgress() + " %");
			}
		});
		conversionHandler.ConversionComplete.add(new ConversionCompleteHandler() {
			@Override
			public void invoke(ConversionCompleteEventArgs args) {
				System.out.println("Conversion " + args.getConversionGuid() + " completed");
				System.out.println(
						"Result document is " + args.getConversionType() + ". Cache is " + args.getUsedCache());
				System.out.println(
						"Result document has " + ((PdfConversionCompleteEventArgs) args).getPageCount() + " page(s).");
			}
		});
		// Save options
		SaveOptions saveOptions = new PdfSaveOptions(); 
		ConvertedDocument result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		//ExEnd:useConversionEvents
	}

	// show grid lines when converting from excel
	public static void showGridLinesConvertingFromExcel(String sourceFileName) {
		//ExStart:showGridLinesConvertingFromExcel
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Save options
		SaveOptions saveOptions = new HtmlSaveOptions(); 
		saveOptions.getCellsOptions().setShowGridLines(true);

		ConvertedDocument result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		//ExEnd:showGridLinesConvertingFromExcel
	}

	// show hidden sheets when converting from excel
	public static void showHiddenSheetesWhenConvertingFromExcel(String sourceFileName) {
		//ExStart:showHiddenSheetesWhenConvertingFromExcel
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Save options
		SaveOptions saveOptions = new HtmlSaveOptions(); 
		saveOptions.getCellsOptions().setShowHiddenSheets(true);
		ConvertedDocument result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		//ExEnd:showHiddenSheetesWhenConvertingFromExcel
	}

	// remove slide comments
	public static void removeSlideComments(String sourceFileName) {
		//ExStart:removeSlideComments
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Save options
		SlidesSaveOptions saveOptions = new SlidesSaveOptions(); 

		ConvertedDocument result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		//ExEnd:removeSlideComments
	}

	// hide tracked changes
	public static void hideTrackedChanges(String sourceFileName) {
		//ExStart:hideTrackedChanges
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		// Save options
		SaveOptions saveOptions = new PdfSaveOptions(); 
		saveOptions.setHideWordTrackedChanges(false);

		ConvertedDocument result = conversionHandler.<String> convert(sourceFileName, saveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		//ExEnd:hideTrackedChanges
	}
	
	//count document pages
	public static void countDocumentPages(String sourceFileName){
		//ExStart:countDocumentPages
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		SaveOptions saveOptions = new PdfSaveOptions();
		ConvertedDocument d = conversionHandler.convert(sourceFileName, saveOptions);
		int count = d.getPageCount(); 
		System.out.print("Page Count: " + count);
		//ExEnd:countDocumentPages
	}
	
	//get possible conversions from file extension
	public static void getPossibleConversionsFromFileExtension(String fileExtension){
		//ExStart:possibleConversionsFromFileExtension
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
				
		String[] possibleConversions = conversionHandler.getPossibleConversions(fileExtension);
		System.out.print("Possible conversions: " + possibleConversions);
		//ExEnd:possibleConversionsFromFileExtension
	}
	
	//get possible conversions from stream
	public static void getPossibleConversionsFromStream(String sourceFileName) throws FileNotFoundException{
		//ExStart:possibleConversionsFromFileStream
		ConversionConfig conversionConfig = Utilities.getConfiguration();
		ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
		
		FileInputStream fileStream = new FileInputStream(conversionConfig.getStoragePath() + "/" + sourceFileName);
		
		String[] possibleConversions = conversionHandler.getPossibleConversions(fileStream);
		System.out.print("Possible conversions: " + possibleConversions);
		//ExEnd:possibleConversionsFromFileStream
	}
	
	//convert files to WebP and get result as stream
	public static void convertFilesToWebPAsStream(String sourceFileName){
		//ExStart:convertFilesToWebPAsStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions options = new ImageSaveOptions();
		options.setConvertFileType(ImageSaveOptions.ImageFileType.WEBP);
		options.getWebpOptions().setLossless(true);
		
		ConvertedDocument convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);
		//ExEnd:convertFilesToWebPAsStream
	}
	
	//convert files from WebP and get result as stream
	public static void convertFromWebPAsStream(String sourceFileName){
		//ExStart:convertFromWebPAsStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions options = new ImageSaveOptions();
		options.setConvertFileType(ImageSaveOptions.ImageFileType.JPG); 
		
		ConvertedDocument result = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);
		//ExEnd:convertFromWebPAsStream
	}
	
	//convert file to greyscale image and get result as stream
	public static void convertFileToGreyscaleImageAsStream(String sourceFileName){
		//ExStart:convertFileToGreyscaleImageAsStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions options = new ImageSaveOptions();
		//ImageFileType enumeration contains the following members:
		//BMP, GIF, ICO, JP2, JPEG, JPG, PNG, PSD, SVG, TIF, TIFF, WEBP
		options.setConvertFileType(ImageSaveOptions.ImageFileType.JPG);
		options.setGrayscale(true);
		
		ConvertedDocument result = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);
		//ExEnd:convertFileToGreyscaleImageAsStream
	}
	
	//convert file to SVG and get result as stream
	public static void convertFileToSVGAsStream(String sourceFileName){
		//ExStart:convertFileToSVGAsStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions options = new ImageSaveOptions();
		options.setConvertFileType(ImageSaveOptions.ImageFileType.SVG);
		 
		ConvertedDocument result = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);
		//ExEnd:convertFileToSVGAsStream
	}
	
	//convert file to XPS and get result as stream
	public static void convertFileToXPSAsStream(String sourceFileName){
		//ExStart:convertFileToXPSAsStream
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		ImageSaveOptions options = new ImageSaveOptions();
		options.setConvertFileType(PdfSaveOptions.PdfFileType.Xps);
		 
		ConvertedDocument result = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);
		//ExEnd:convertFileToXPSAsStream
	}
	
	//metered licensing
	public static void meteredLicensingOnFile(String sourceFileName) throws Exception{
		//ExStart:meteredLicensingOnFile
		Metered metered = new Metered();		 
		// Set public and private key to metered instance
		metered.setMeteredKey("***","***");
		
		// Get metered value before usage of the conversion
		double amountBefore = Metered.getConsumptionQuantity();
		System.out.print("Amount consumed before: " + amountBefore);
		
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		PdfSaveOptions options = new PdfSaveOptions();
		options.setConvertFileType(PdfSaveOptions.PdfFileType.Pdf);
		 
		ConvertedDocument result = conversionHandler.<GroupDocsInputStream>convert(sourceFileName, options);
		result.save(sourceFileName + "." + result.getFileType());
		// Get metered value after usage of the conversion
		double amountAfter = Metered.getConsumptionQuantity();
		System.out.print("Amount consumed after: " + amountAfter);
		//ExEnd:meteredLicensingOnFile
	}
	
	//hide comments when converting from word
	public static void hideCommentsWhenConvertingFromWord(String sourceFileName){
		//ExStart:hideCommentsWhenConvertingFromWord
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		
		SaveOptions saveOptions = new PdfSaveOptions(); 
		saveOptions.setHideComments(false);
		 
		ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, saveOptions);		 
		result.save(sourceFileName + "." + result.getFileType());
		System.out.print("Converted file path is: " + result);
		//ExEnd:hideCommentsWhenConvertingFromWord
	}
	
	// mark image Dpi as Obsolete
	public static void markImageDpiAsObsolete(String sourceFileName){
		//ExStart:markImageDpiAsObsolete
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		
		ImageSaveOptions options = new ImageSaveOptions();
		//ImageFileType enumeration contains the following members:
		//BMP, GIF, ICO, JP2, JPEG, JPG, PNG, PSD, SVG, TIF, TIFF, WEBP
		options.setConvertFileType(ImageSaveOptions.ImageFileType.TIFF);
		// Dpi is obsolete, now horizontal and vertical resolutions can be set independently
		options.setHorizontalResolution(96);
		options.setVerticalResolution(96);
		 
		ConvertedDocument result = conversionHandler.<List<GroupDocsInputStream>>convert(sourceFileName, options);
		result.save(sourceFileName + "." + result.getFileType());
		System.out.print("Converted file path is: " + result);
		//ExEnd:markImageDpiAsObsolete
	}
	//Get source document metadata
	public static void sourceDocMetadata(String sourceFileName){
		//ExStart:sourceDocMetadata
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		DocumentInfo documentInfo = conversionHandler.getDocumentInfo(sourceFileName); 
		 
		System.out.print("Size: %s}" + documentInfo.getSize());
		System.out.print("File type: %s" + documentInfo.getFileType());
		System.out.print("Pages count: %s" + documentInfo.getPageCount());
		System.out.print("Last modified: %s" + documentInfo.getModifiedDate());
		//ExEnd:sourceDocMetadata
	}
	
	//convert xml-fo/xsl to pdf
	public static void xmlToPdfConversion(String sourceFileName, String foFileName) throws Throwable{
		//ExStart:xmlToPdfConversion
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		FileInputStream foStream = new FileInputStream(Utilities.storagePath + "/" + foFileName); 
		 
		PdfSaveOptions pdfSaveOptions = new PdfSaveOptions(); 
		 
		XmlLoadOptions xmlLoadOptions = new XmlLoadOptions();
		xmlLoadOptions.setXslFo(foStream); 
		 
		ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, xmlLoadOptions, pdfSaveOptions);
		result.save(sourceFileName + "." + result.getFileType());
		System.out.print(result);
		//ExEnd:xmlToPdfConversion
	}
	
	//Zoom when converting slides to HTML
	public static void zoomWhileConvertingToHtml(String sourceFileName){
		//ExStart:zoomWhileConvertingToHtml
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		HtmlSaveOptions saveOptions = new HtmlSaveOptions(); 
		saveOptions.setZoom(150); 
		 
		ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, saveOptions); 
		result.save(sourceFileName + "." + result.getFileType());
		System.out.print(result);
		//ExEnd:zoomWhileConvertingToHtml
	}
	
	//get available layouts in a CAD document 
	public static void availableLayoutsInCad(String sourceFileName){
		//ExStart:availableLayoutsInCad
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		DocumentInfo result = conversionHandler.getDocumentInfo(sourceFileName); 
		 
		for (String layer : result.getLayers()) {
		System.out.println(layer);
		}
		//ExEnd:availableLayoutsInCad
	}
	
	//convert specific layout from a CAD document 
	public static void convertSpecificLayoutFromCad(String sourceFileName){
		//ExStart:convertSpecificLayoutFromCad
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		String[] layoutNames = new String[1];
		layoutNames[0] = "layout-1"; 
		PdfSaveOptions options = new PdfSaveOptions(); 
		options.getCadOptions().setLayoutNames(layoutNames); 
		 
		ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, options); 
		result.save(sourceFileName + "." + result.getFileType());
		System.out.print(result);
		//ExEnd:convertSpecificLayoutFromCad
	}
	
	//set specific width and height for each layout from CAD document 
	public static void setWidthHeightForCad(String sourceFileName){
		//ExStart:setWidthHeightForCad
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		PdfSaveOptions options = new PdfSaveOptions(); 
		options.getCadOptions().setWidth(800);
		options.getCadOptions().setHeight(600); 
		 
		ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, options); 
		result.save(sourceFileName + "." + result.getFileType());
		System.out.print(result);
		//ExEnd:setWidthHeightForCad
	}
	
	//Hide annotations when converting from PDF
	public static void hideAnnotations(String sourceFileName){
		//ExStart:hideAnnotations
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		WordsSaveOptions options = new WordsSaveOptions(); 
		options.setHidePdfAnnotations(true); 
		 
		ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, options); 
		result.save(sourceFileName + "." + result.getFileType());
		System.out.print(result);
		//ExEnd:hideAnnotations
	}
	
	public static void hideCommentsConvertingFromCells(String sourceFileName){ 
		 //ExStart:hideCommentsConvertingFromCells
		// Setup Conversion configuration
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration()); 
		 
		PdfSaveOptions options = new PdfSaveOptions(); 
		options.setHideComments(true); 
		 
		ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, options);
		result.save(sourceFileName + "." + result.getFileType());
		//ExEnd:hideCommentsConvertingFromCells
	}

	public static void convertSpecificPagesFromSourceDoc(String sourceFileName){
		//ExStart:convertSpecificPagesFromSourceDoc
		// Setup Conversion configuration
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration()); 
		PdfSaveOptions options = new PdfSaveOptions(); 
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(5);
		options.getConvertPages().addAll(arrayList); 
		 
		ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, options);
		result.save(sourceFileName + "." + result.getFileType());
		//ExEnd:convertSpecificPagesFromSourceDoc
	}
	
	public static void getMarkupWhenConvertingToHtml(String sourceFileName){
		//ExStart:getMarkupWhenConvertingToHtml
		// Setup Conversion configuration
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration()); 
		HtmlSaveOptions options = new HtmlSaveOptions(); 
		options.setFixedLayout(false); 
		 
		ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, options);
		result.save(sourceFileName + "." + result.getFileType());
		//ExEnd:getMarkupWhenConvertingToHtml
	}
}
