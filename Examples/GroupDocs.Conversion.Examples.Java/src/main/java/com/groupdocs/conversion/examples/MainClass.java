package com.groupdocs.conversion.examples;

public class MainClass {

	public static void main(String[] args) throws Throwable {

		// uncomment to apply license
		Utilities.applyLicenseFromFile();

		// convert document to cells, result as file path
		// Conversion.convertToCellsAsFilePath("intelligent systems.docx");

		// convert document to cells, result as stream
		// Conversion.convertToCellsAsStream("intelligent systems.docx");

		// convert protected document to cells and get result as file path
		// Conversion.convertProtectedFilesToCellsAsPath("intelligent
		// systems.docx");

		// convert protected document to cells and get result as stream
		// Conversion.convertProtectedFilesToCellsAsStream("intelligent
		// systems.docx");

		// convert to word and get result as path
		// Conversion.convertToWordAsFilePath("intelligent systems.pdf");

		// convert to word and get result as stream
		// Conversion.convertToWordAsStream("intelligent systems.pdf");

		// convert protected document to word and get result as file path
		// Conversion.convertProtectedFilesToWordAsPath("intelligent
		// systems.pdf");

		// convert protected document to word and get result as stream
		// Conversion.convertProtectedFilesToWordAsStream("intelligent
		// systems.pdf");

		// convert to html and get result as path
		// Conversion.convertToHtmlAsFilePath("intelligent systems.pdf");

		// convert to html and get result as stream
		// Conversion.convertToHtmlAsStream("intelligent systems.pdf");

		// convert protected document to html and get result as file path
		// Conversion.convertProtectedFilesToHtmlAsPath("intelligent
		// systems.pdf");

		// convert protected document to html and get result as stream
		// Conversion.convertProtectedFilesToHtmlAsStream("intelligent
		// systems.pdf");

		// convert to image and get result as path
		// Conversion.convertToImageAsFilePath("intelligent systems.pdf");

		// convert to image and get result as stream
		// Conversion.convertToImageAsStream("intelligent systems.pdf");

		// convert protected document to image and get result as image path
		// Conversion.convertProtectedFilesToImageAsPath("intelligent
		// systems.pdf");

		// convert protected document to image and get result as stream
		// Conversion.convertProtectedFilesToImageAsStream("intelligent
		// systems.pdf");

		// convert to pdf and get result as path
		// Conversion.convertToPdfAsFilePath("intelligent systems.docx");

		// convert to pdf and get result as stream
		// Conversion.convertToPdfAsStream("intelligent systems.docx");

		// convert protected document to pdf and get result as file path
		// Conversion.convertProtectedFilesToPdfAsPath("intelligent
		// systems.docx");

		// convert protected document to pdf and get result as stream
		// Conversion.convertProtectedFilesToPdfAsStream("intelligent
		// systems.docx");

		// convert to slide and get result as path
		// Conversion.convertToSlideAsFilePath("intelligent systems.docx");

		// convert to slide and get result as stream
		// Conversion.convertToSlideAsStream("intelligent systems.docx");

		// convert protected document to slide and get result as file path
		// Conversion.convertProtectedFilesToSlideAsPath("intelligent
		// systems.docx");

		// convert protected document to slide and get result as stream
		// Conversion.convertProtectedFilesToSlideAsStream("intelligent
		// systems.docx");

		// get source document from absolute path
		// CommonOperations.getSourceDocFromAbsolutePath();

		// get source document from relative path
		// CommonOperations.getSourceDocFromRelativePath();

		// get source document from URI
		// CommonOperations.getSourceDocFromURI();

		// get document from stream and file
		// CommonOperations.getDocFromStreamAndFileName();

		// get document from stream
		// CommonOperations.getSourceDocFromStream();

		// custom input data handler
		// Conversion.inputDataHandler("intelligent systems.docx");

		// custom output data handler
		// Conversion.outputDataHanlder();

		// conversion progress
		// Conversion.conversionProgress("intelligent systems.docx");

		// get available save options by file extension
		// Conversion.getAvailableSaveOptionsByExtension("demo.docx");

		// get available save options by file stream
		// Conversion.getAvailableSaveOptionsByStream("D:/GitRepos/GroupDocs.Conversion-for-Java/Examples/GroupDocs.Conversion.Examples.Java/Data/SourceFiles/demo.docx");

		// usage of PageMode when converting to PDF
		// Conversion.usePageModeConvertingToPdf("The butterfly effect.pptx");
		// usage of PageMode when converting to HTML
		// Conversion.usePageModeConvertingToHtml("The butterfly effect.pptx");
		// adding watermarks on converted documents
		// Conversion.addWatermarkOnConvertedDocs("The butterfly effect.pptx");
		// convert to psd
		// Conversion.convertToPsd("demo.docx");
		// convert from psd
		// Conversion.convertFromPsd("demo.psd");
		// use different conversion events
		// Conversion.useConversionEvents("demo.docx");

		// Region ConversionManager
		// Conversion manager
		// String sourceFileName = "demo.docx"; //TODO: Put the source filename
		// here
		// String storagePath = ".";
		// ConversionManager manager = new ConversionManager(storagePath);
		// String result = manager.convert(sourceFileName);
		// System.out.println(result);
		// EndRegion

		// show grid line when converting from excel
		// Conversion.showGridLinesConvertingFromExcel("sample.xlsx");
		// show hidden sheets
		// Conversion.showHiddenSheetesWhenConvertingFromExcel("sample.xlsx");
		// remove slide comments
		// Conversion.removeSlideComments("The butterfly effect.pptx");
		// hide tracked changes
		// Conversion.hideTrackedChanges("demo.docx");
	}
}
