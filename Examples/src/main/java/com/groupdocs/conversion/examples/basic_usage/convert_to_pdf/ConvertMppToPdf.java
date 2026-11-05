package com.groupdocs.conversion.examples.basic_usage.convert_to_pdf;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

/**
 * This example demonstrates how to convert MPP to PDF.
 */
public class ConvertMppToPdf {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertMppToPdf.pdf");

        try (Converter converter = new Converter(Constants.SAMPLE_MPP)) {
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert(convertedFile, options);
        }

        System.out.print("\nConversion to pdf completed successfully. \nCheck output in " + convertedFile);
    }
}
