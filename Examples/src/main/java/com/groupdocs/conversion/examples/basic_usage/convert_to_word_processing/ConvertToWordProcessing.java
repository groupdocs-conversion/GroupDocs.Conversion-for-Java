package com.groupdocs.conversion.examples.basic_usage.convert_to_word_processing;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.WordProcessingConvertOptions;

import java.io.File;


/**
* This example demonstrates how to convert document to WordProcessing.
*/
public class ConvertToWordProcessing {
    public static void run()
    {
        String convertedFile =  Constants.getConvertedPath("ConvertToWordProcessing.docx");
        Converter converter = new Converter(Constants.SAMPLE_PDF);
        WordProcessingConvertOptions options = new WordProcessingConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nConversion to wordprocessing completed successfully. \nCheck output in " + convertedFile);
    }
}