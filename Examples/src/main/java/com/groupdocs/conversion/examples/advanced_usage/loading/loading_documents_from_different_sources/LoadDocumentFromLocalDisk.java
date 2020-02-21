package com.groupdocs.conversion.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

import java.io.File;


/**
* This example demonstrates how to convert document from local disk.
*/
public class LoadDocumentFromLocalDisk {
    public static void run()
    {
        String convertedFile =  Constants.getConvertedPath("LoadDocumentFromLocalDisk.pdf");
        String filePath = Constants.SAMPLE_DOCX;
        Converter converter = new Converter(filePath);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.println("\nSource document converted successfully.\nCheck output in "+ convertedFile);
    }
}