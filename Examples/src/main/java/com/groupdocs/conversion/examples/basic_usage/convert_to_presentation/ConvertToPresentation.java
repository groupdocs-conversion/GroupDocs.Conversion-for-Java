package com.groupdocs.conversion.examples.basic_usage.convert_to_presentation;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PresentationConvertOptions;


/**
 * This example demonstrates how to convert document to Presentation.
 */
public class ConvertToPresentation {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertToPresentation.pptx");
        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        PresentationConvertOptions options = new PresentationConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nConversion to presentation completed successfully. \nCheck output in " + convertedFile);
    }
}