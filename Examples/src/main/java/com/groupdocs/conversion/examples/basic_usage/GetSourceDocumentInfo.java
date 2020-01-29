package com.groupdocs.conversion.examples.basic_usage;

import com.groupdocs.conversion.examples.Constants;


/**
* This example demonstrates how to get basic information about source document.
*/
public class GetSourceDocumentInfo {
    public static void run()
    {
        Converter converter = new Converter(Constants.SAMPLE_PDF);

            IDocumentInfo info = converter.getDocumentInfo();

            PdfDocumentInfo pdfInfo = (PdfDocumentInfo) info;

            System.out.print("Author: {0}", pdfInfo.getAuthor());
            System.out.print("Creation date: {0}", pdfInfo.getCreationDate());
            System.out.print("Title: {0}", pdfInfo.getTitle());
            System.out.print("Version: {0}", pdfInfo.getVersion());
            System.out.print("Pages count: {0}", pdfInfo.getPagesCount());
            System.out.print("Width: {0}", pdfInfo.getWidth());
            System.out.print("Height: {0}", pdfInfo.getHeight());
            System.out.print("Is landscaped: {0}", pdfInfo.getIsLandscape());
            System.out.print("Is Encrypted: {0}", pdfInfo.getIsEncrypted());


        System.out.print("\nDocument info retrieved successfully.");
    }
}