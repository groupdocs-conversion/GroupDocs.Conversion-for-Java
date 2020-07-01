package com.groupdocs.conversion.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.exceptions.GroupDocsConversionException;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

import java.io.FileInputStream;

/**
 * This example demonstrates how to convert document from stream.
 */
public class LoadDocumentFromStream {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("LoadDocumentFromStream.pdf");

        try {
            Converter converter = new Converter(new FileInputStream(Constants.SAMPLE_DOCX));
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert(convertedFile, options);
        } catch (Exception e) {
            throw new GroupDocsConversionException(e.getMessage());
        }
        System.out.println("\nSource document converted successfully.\nCheck output in " + convertedFile);
    }
}