package com.groupdocs.conversion.examples.basic_usage.сonvert_to_pdf;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

import java.io.File;


/**
* This example demonstrates how to convert document to PDF.
*/
public class ConvertToPdf {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();

        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);

        System.out.print("\nConversion to pdf completed successfully. \nCheck output in " + outputFolder);
    }
}