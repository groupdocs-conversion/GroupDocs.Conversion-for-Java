package com.groupdocs.conversion.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;


/**
* This example demonstrates how to convert document from local disk.
*/
public class LoadDocumentFromLocalDisk {
    public static void run()
    {
        String outputDirectory = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputDirectory, "converted.pdf").getPath();
        String filePath = Constants.SAMPLE_DOCX;

        Converter converter = new Converter(filePath);
        PdfConvertOptions options = new PdfConvertOptions();

        converter.convert(outputFile, options);


        System.out.println("\nSource document converted successfully.\nCheck output in "+outputDirectory);
    }
}