package com.groupdocs.conversion.examples.basic_usage.convert_to_html;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.WebConvertOptions;

/**
 * This example demonstrates how to convert MPP to HTML.
 */
public class ConvertMppToHtml {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertMppToHtml.html");

        try (Converter converter = new Converter(Constants.SAMPLE_MPP)) {
            WebConvertOptions options = new WebConvertOptions();
            converter.convert(convertedFile, options);
        }

        System.out.print("\nConversion to html completed successfully. \nCheck output in " + convertedFile);
    }
}
