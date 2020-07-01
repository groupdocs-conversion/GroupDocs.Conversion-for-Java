package com.groupdocs.conversion.examples.advanced_usage.converting;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.convert.Rotation;
import com.groupdocs.conversion.options.load.WordProcessingLoadOptions;

/**
 * This example demonstrates how to convert password-protected document to PDF and specifying pages to be converted
 */
public class ConvertToPdfWithAdvancedOptions {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertToPdfWithAdvancedOptions.pdf");
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        loadOptions.setPassword("12345");
        Converter converter = new Converter(Constants.SAMPLE_DOCX_WITH_PASSWORD, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        options.setPageNumber(2);
        options.setPagesCount(1);
        options.setRotate(Rotation.On180);
        options.setDpi(300);
        options.setWidth(1024);
        options.setHeight(768);
        converter.convert(convertedFile, options);

        System.out.print("\nPassword protected document converted successfully. \nCheck output in " + convertedFile);
    }
}