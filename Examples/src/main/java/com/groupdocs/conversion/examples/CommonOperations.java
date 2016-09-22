package com.groupdocs.conversion.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.groupdocs.conversion.converter.option.HtmlSaveOptions;
import com.groupdocs.conversion.converter.option.OutputType;
import com.groupdocs.conversion.converter.option.PdfSaveOptions;
import com.groupdocs.conversion.handler.ConversionHandler;

public class CommonOperations {

	/*
	 * Get source document from absolute path
	 */
	public static void getSourceDocFromAbsolutePath() {
		// Instantiating the conversion handler, you can define absolute file
		// path in utilities class
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		HtmlSaveOptions saveOption = new HtmlSaveOptions();
		saveOption.setOutputType(OutputType.String);

		// Set absolute path to file
		String guid = "C:/Storage/DOCXsample.docx"; 	

		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		System.out.print("Converted file path is: " + convertedDocumentPath);
	}

	/*
	 * Get source document from relative path
	 */
	public static void getSourceDocFromRelativePath(String fileName) {
		// Instantiating the conversion handler, you can define relative file
		// path in utilities class
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		HtmlSaveOptions saveOption = new HtmlSaveOptions();
		saveOption.setOutputType(OutputType.String);

		// Set relative path. So that full path will be C:/Storage/DOCXsample.docx
		String guid = "DOCXsample.docx";

		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		System.out.print("Converted file path is: " + convertedDocumentPath);
	}

	/*
	 * Get source document from URI
	 */
	public static void getSourceDocFromURI() {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		HtmlSaveOptions saveOption = new HtmlSaveOptions();
		saveOption.setOutputType(OutputType.String);

		// Set Uri path.
		String guid = "http://example.com/DOCXsample.docx";

		String convertedDocumentPath = conversionHandler.<String> convert(guid, saveOption);
		System.out.print("Converted file path is: " + convertedDocumentPath);
	}

	/*
	 * Get document from stream and file name
	 */
	public static void getDocFromStreamAndFileName() throws Throwable {
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		PdfSaveOptions saveOption = new PdfSaveOptions();
		saveOption.setOutputType(OutputType.String);
		 
		String guid = "C:/Storage/DOCXsample.docx";
		FileInputStream fileStream = new FileInputStream(guid);
		 
		// Convert document
		String convertedDocumentPath = conversionHandler.<String>convert(fileStream, guid, saveOption);
	}
	
	/*
	 * Get source document from Stream (with autodetect source document type)
	 */
	public static void getSourceDocFromStream() throws Throwable{ 
		// Instantiating the conversion handler
		ConversionHandler conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		 
		PdfSaveOptions saveOption = new PdfSaveOptions();
		saveOption.setOutputType(OutputType.String);
		FileInputStream fileStream = new FileInputStream("C:/Storage/DOCXsample.docx");
		  
		// Convert document
		String convertedDocumentPath = conversionHandler.<String>convert(fileStream,"C:/Storage/DOCXsample.docx", saveOption);
		
	}
}
