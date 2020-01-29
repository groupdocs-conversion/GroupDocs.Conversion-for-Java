package com.groupdocs.conversion.examples.quick_start;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;
/**
* This example demonstrates how to convert document to PDF.
*/
public class HelloWorld {
    public static void run()
    {
        String outputDirectory = Constants.getOutputDirectoryPath(null);
        String convertedFile =  new File(outputDirectory, "converted.pdf").getPath();

        Converter converter = new Converter(Constants.SAMPLE_DOCX);

        PdfConvertOptions options = new PdfConvertOptions();
        converter.Convert(convertedFile, options);


        System.out.print("\nSource document converted successfully.\nCheck output in {outputDirectory}.");
    }
}