package com.groupdocs.conversion.examples;

import java.util.List;

import com.groupdocs.conversion.converter.option.CellsSaveOptions;
import com.groupdocs.conversion.converter.option.HtmlSaveOptions;
import com.groupdocs.conversion.converter.option.ImageSaveOptions;
import com.groupdocs.conversion.converter.option.LoadOptions;
import com.groupdocs.conversion.converter.option.OutputType;
import com.groupdocs.conversion.converter.option.PdfSaveOptions;
import com.groupdocs.conversion.converter.option.SaveOptions;
import com.groupdocs.conversion.converter.option.SlidesSaveOptions;
import com.groupdocs.conversion.converter.option.WordsSaveOptions;
import com.groupdocs.conversion.handler.ConversionHandler;
import com.groupdocs.conversion.handler.output.IOutputDataHandler;
import com.groupdocs.foundation.domain.FileType;
import com.groupdocs.foundation.utils.wrapper.stream.GroupDocsInputStream;

public class Conversion {

	// region Convert to spreadsheet

	/*
	 * Convert document to spreadsheet and get result as file path
	 */
	public static void convertToCellsAsFilePath(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		CellsSaveOptions saveOption = new CellsSaveOptions();
		saveOption.setOutputType(OutputType.String);
		String convertedDocumentPath = conversionHandler.<String> convert(fileName, saveOption);
	}

	/*
	 * Convert document to spreadsheet and get result as stream
	 */
	public static void convertToCellsAsStream(String fileName) {
		// instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new CellsSaveOptions());
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToCellsAsPath(String fileName) {
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
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
		System.out.println(convertedDocumentPath);
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream to the converted file
	 */
	public static void convertProtectedFilesToCellsAsStream(String fileName) {
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

		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
	}
	// endregion Convert to spreadsheet

	// region Convert to word

	/*
	 * convert document to word and get result as path
	 */
	public static void convertToWordAsFilePath(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		WordsSaveOptions saveOption = new WordsSaveOptions();
		saveOption.setOutputType(OutputType.String);
		// Set absolute path to file
		String guid = fileName;
		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
	}

	/*
	 * convert document to word and get result as stream
	 */
	public static void convertToWordAsStream(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert("PDFsample.pdf",
				new WordsSaveOptions());
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToWordAsPath(String fileName) {
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
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToWordAsStream(String fileName) {
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
		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
	}

	// endregion Convert to word

	// region Convert to Html

	/*
	 * Convert document to html and get result as file path
	 */
	public static void convertToHtmlAsFilePath(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		HtmlSaveOptions saveOption = new HtmlSaveOptions();
		saveOption.setOutputType(OutputType.String);

		// Set absolute path to file
		String guid = fileName;

		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
	}

	/*
	 * Convert document to html and get result as stream
	 */
	public static void convertToHtmlAsStream(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new HtmlSaveOptions());
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToHtmlAsPath(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Convert starting from page 2 and convert 2 pages
		HtmlSaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToHtmlAsStream(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());

		// Set password to unprotect protected document during loading
		LoadOptions loadOptions = new LoadOptions();
		loadOptions.setPassword("secret");

		// Сonvert starting from page 2 and convert 2 pages
		SaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setPageNumber(2);
		saveOptions.setNumPagesToConvert(2);

		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
	}

	// endregion Convert to Html

	// region Convert to Image

	/*
	 * Convert document to image and get result as image path
	 */
	public static void convertToImageAsFilePath(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		SaveOptions saveOption = new ImageSaveOptions();
		saveOption.setConvertFileType(ImageSaveOptions.ImageFileType.Jpg);
		saveOption.setOutputType(OutputType.String);

		List<String> convertedDocumentPath = conversionHandler.<List<String>> convert(fileName, saveOption);
	}

	/*
	 * Convert document to image and get result as stream
	 */
	public static void convertToImageAsStream(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		List<GroupDocsInputStream> convertedDocumentStream = conversionHandler
				.<List<GroupDocsInputStream>> convert(fileName, new ImageSaveOptions());
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted image
	 */
	public static void convertProtectedFilesToImageAsPath(String fileName) {
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
		saveOptions.setDpi(300);
		saveOptions.setWidth(1024);
		saveOptions.setHeight(768);
		saveOptions.setConvertFileType(FileType.Tiff);
		saveOptions.setOutputType(OutputType.String);

		List<String> convertedDocumentPath = conversionHandler.<List<String>> convert(fileName, loadOptions,
				saveOptions);
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToImageAsStream(String fileName) {
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
		saveOptions.setDpi(300);
		saveOptions.setWidth(1024);
		saveOptions.setHeight(768);
		saveOptions.setConvertFileType(FileType.Tiff);

		List<GroupDocsInputStream> convertedDocumentStream = conversionHandler
				.<List<GroupDocsInputStream>> convert(fileName, loadOptions, saveOptions);
	}

	// region Convert to Image

	// region Convert to pdf

	/*
	 * Convert document to pdf and get result as pdf path
	 */
	public static void convertToPdfAsFilePath(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		PdfSaveOptions saveOption = new PdfSaveOptions();
		saveOption.setOutputType(OutputType.String);

		// Set absolute path to file
		String guid = fileName;

		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
	}

	/*
	 * Convert document to pdf and get result as stream
	 */
	public static void convertToPdfAsStream(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new PdfSaveOptions());
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToPdfAsPath(String fileName) {
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
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToPdfAsStream(String fileName) {
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

		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
	}

	// region Convert to pdf

	// region Convert to slides

	/*
	 * Convert document to slide and get result as file path
	 */
	public static void convertToSlideAsFilePath(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		SlidesSaveOptions saveOption = new SlidesSaveOptions();
		saveOption.setOutputType(OutputType.String);

		// Set absolute path to file
		String guid = fileName;

		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
	}

	/*
	 * Convert document to slide and get result as stream
	 */
	public static void convertToSlideAsStream(String fileName) {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new SlidesSaveOptions());
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return path to the converted file
	 */
	public static void convertProtectedFilesToSlideAsPath(String fileName) {
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
		saveOptions.setOutputType(OutputType.String);

		String convertedDocumentPath = conversionHandler.<String> convert(fileName, loadOptions, saveOptions);
	}

	/*
	 * Generate cache, set password to un-protect password protected files and
	 * return stream
	 */
	public static void convertProtectedFilesToSlideAsStream(String fileName) {
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

		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				loadOptions, saveOptions);
	}

	// endregion Convert to slides

	// region custom input data handler

	public static void inputDataHandler(String fileName) {
		// Instantiating the conversion handler
		AmazonInputDataHandler inputDataHandler = new AmazonInputDataHandler("AccessKey", "SecretKey");
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration(), inputDataHandler);

		GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream> convert(fileName,
				new PdfSaveOptions());
	}

	// endregion custom input data handler
	
	//region custom output data handler
	
	public static void outputDataHanlder(){
		// Instantiating the conversion handler
		AmazonOutputDataHandler outputDataHandler = new AmazonOutputDataHandler(Utilities.getConfiguration(), "AccessKey", "SecretKey");
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration(), (IOutputDataHandler) outputDataHandler);
		PdfSaveOptions saveOptions = new PdfSaveOptions();
		saveOptions.setOutputType(OutputType.String);
		 
		String convertedDocumentPath = conversionHandler.<String>convert("DOCXsample.docx", saveOptions);
	}
	
	//endregion custom output data handler

}
