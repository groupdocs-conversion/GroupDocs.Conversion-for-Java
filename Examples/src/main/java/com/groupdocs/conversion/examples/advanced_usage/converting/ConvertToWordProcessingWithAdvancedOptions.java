package com.groupdocs.conversion.examples.advanced_usage.converting;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.WordProcessingFileType;
import com.groupdocs.conversion.options.convert.WordProcessingConvertOptions;

/**
 * This example demonstrates how to convert a pdf document to wordprocessing document and specifying pages to be converted
 */
public class ConvertToWordProcessingWithAdvancedOptions {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertToWordProcessingWithAdvancedOptions.odt");
        Converter converter = new Converter(Constants.SAMPLE_PDF);
        WordProcessingConvertOptions options = new WordProcessingConvertOptions();
        options.setPageNumber(2);
        options.setPagesCount(1);
        options.setFormat(WordProcessingFileType.Odt);
        converter.convert(convertedFile, options);

        System.out.print("\nDocument converted successfully. \nCheck output in " + convertedFile);
    }
}