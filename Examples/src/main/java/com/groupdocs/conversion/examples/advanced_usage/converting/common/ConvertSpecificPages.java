package com.groupdocs.conversion.examples.advanced_usage.converting.common;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
* This example demonstrates how to convert specific pages
*/
public class ConvertSpecificPages {
    public static void run()
    {
        String convertedFile =  Constants.getConvertedPath("ConvertSpecificPages.pdf");
        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        PdfConvertOptions options = new PdfConvertOptions();
        options.setPages(Arrays.asList(2, 3));
        converter.convert(convertedFile, options);

        System.out.print("\nDocument converted successfully. \nCheck output in " + convertedFile);
    }
}