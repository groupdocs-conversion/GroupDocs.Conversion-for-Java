package com.groupdocs.conversion.examples.advanced_usage.loading;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.WordProcessingLoadOptions;

/**
 * This example demonstrates how to load and convert password-protected document.
 */
public class LoadPasswordProtectedDocument {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("LoadPasswordProtectedDocument.pdf");
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        loadOptions.setPassword("12345");
        Converter converter = new Converter(Constants.SAMPLE_DOCX_WITH_PASSWORD, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nPassword protected document converted successfully. \nCheck output in " + convertedFile);
    }
}