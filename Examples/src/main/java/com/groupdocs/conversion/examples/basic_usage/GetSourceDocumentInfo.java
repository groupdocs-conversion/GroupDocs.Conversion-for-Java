package com.groupdocs.conversion.examples.basic_usage;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.documentinfo.IDocumentInfo;
import com.groupdocs.conversion.contracts.documentinfo.PdfDocumentInfo;
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

        System.out.println("Author: " + pdfInfo.getAuthor());
        System.out.println("Creation date: " + pdfInfo.getCreationDate());
        System.out.println("Title: " + pdfInfo.getTitle());
        System.out.println("Version: " + pdfInfo.getVersion());
        System.out.println("Pages count: " + pdfInfo.getPagesCount());
        System.out.println("Width: " + pdfInfo.getWidth());
        System.out.println("Height: " + pdfInfo.getHeight());
        System.out.println("Is landscaped: "+ pdfInfo.isLandscape());
        System.out.println("Is Encrypted: "+ pdfInfo.isPasswordProtected());

        System.out.println("\nDocument info retrieved successfully.");
    }
}