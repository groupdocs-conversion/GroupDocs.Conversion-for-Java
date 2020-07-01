package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.email;


import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.EmailLoadOptions;

/**
 * This example demonstrates how to convert an email document to pdf with advanced options
 */
public class ConvertEmailWithTimezoneOffset {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertEmailWithTimezoneOffset.pdf");
        EmailLoadOptions loadOptions = new EmailLoadOptions();
        loadOptions.setTimeZoneOffset(7200000);
        Converter converter = new Converter(Constants.SAMPLE_EML, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nEmail document converted successfully. \nCheck output in " + convertedFile);
    }
}