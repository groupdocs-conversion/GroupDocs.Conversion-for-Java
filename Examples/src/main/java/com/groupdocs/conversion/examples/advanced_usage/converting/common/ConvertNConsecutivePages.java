package com.groupdocs.conversion.examples.advanced_usage.converting.common;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

import java.io.File;

/**
* This example demonstrates how to convert range of pages
*/
public class ConvertNConsecutivePages {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();

        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        PdfConvertOptions options = new PdfConvertOptions();
        options.setPageNumber(2);
        options.setPagesCount(2);

        converter.convert(outputFile, options);

        System.out.print("\nDocument converted successfully. \nCheck output in "+ outputFolder);
    }
}