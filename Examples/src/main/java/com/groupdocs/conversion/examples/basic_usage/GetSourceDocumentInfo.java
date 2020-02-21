package com.groupdocs.conversion.examples.basic_usage;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.IDocumentInfo;
import com.groupdocs.conversion.contracts.PdfDocumentInfo;
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

        System.out.print("Author: " + pdfInfo.getAuthor());
        System.out.print("Creation date: " + pdfInfo.getCreationDate());
        System.out.print("Title: " + pdfInfo.getTitle());
        System.out.print("Version: " + pdfInfo.getVersion());
        System.out.print("Pages count: " + pdfInfo.getPagesCount());
        System.out.print("Width: " + pdfInfo.getWidth());
        System.out.print("Height: " + pdfInfo.getHeight());
        System.out.print("Is landscaped: "+ pdfInfo.isLandscape());
        System.out.print("Is Encrypted: "+ pdfInfo.isEncrypted());

        System.out.print("\nDocument info retrieved successfully.");
    }
}