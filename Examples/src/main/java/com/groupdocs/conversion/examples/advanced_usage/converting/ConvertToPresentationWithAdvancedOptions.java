package com.groupdocs.conversion.examples.advanced_usage.converting;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.PresentationFileType;
import com.groupdocs.conversion.options.convert.PresentationConvertOptions;
import com.groupdocs.conversion.options.load.WordProcessingLoadOptions;

/**
 * This example demonstrates how to convert password-protected document to presentation and specifying pages to be converted
 */
public class ConvertToPresentationWithAdvancedOptions {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertToPresentationWithAdvancedOptions.ppt");
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        loadOptions.setPassword("12345");
        Converter converter = new Converter(Constants.SAMPLE_DOCX_WITH_PASSWORD, loadOptions);
        PresentationConvertOptions options = new PresentationConvertOptions();
        options.setPageNumber(2);
        options.setPagesCount(1);
        options.setFormat(PresentationFileType.Ppt);
        converter.convert(convertedFile, options);

        System.out.print("\nPassword protected document converted successfully. \nCheck output in " + convertedFile);
    }
}