package com.groupdocs.examples.conversion.basic_usage;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.documentinfo.IDocumentInfo;
import com.groupdocs.conversion.contracts.documentinfo.PdfDocumentInfo;
import com.groupdocs.examples.conversion.utils.FailureRegister;

import java.nio.file.Path;

public class GetSourceDocumentInfo {
    public static PdfDocumentInfo run(Path inputFile) {
        try (Converter converter = new Converter(inputFile.toString())) {
            IDocumentInfo info = converter.getDocumentInfo();
            PdfDocumentInfo pdfInfo = (PdfDocumentInfo) info;

            System.out.printf("File '%s' info:\n", inputFile.getFileName());
            System.out.println("\tAuthor: " + pdfInfo.getAuthor());
            System.out.println("\tCreation date: " + pdfInfo.getCreationDate());
            System.out.println("\tTitle: " + pdfInfo.getTitle());
            System.out.println("\tVersion: " + pdfInfo.getVersion());
            System.out.println("\tPages count: " + pdfInfo.getPagesCount());
            System.out.println("\tWidth: " + pdfInfo.getWidth());
            System.out.println("\tHeight: " + pdfInfo.getHeight());
            System.out.println("\tIs landscaped: " + pdfInfo.isLandscape());
            System.out.println("\tIs Encrypted: " + pdfInfo.isPasswordProtected());

            System.out.println("\nDocument info retrieved successfully.");

            return pdfInfo;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
