package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.email;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;

import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.EmailLoadOptions;

import java.io.File;

/**
* This example demonstrates how to convert an email document to pdf with advanced options
*/
public class ConvertEmailWithAlteringFieldsVisibility {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();

        EmailLoadOptions loadOptions = new EmailLoadOptions();
        loadOptions.setDisplayHeader(false);
        loadOptions.setDisplayFromEmailAddress(false);
        loadOptions.setDisplayToEmailAddress(false);
        loadOptions.setDisplayEmailAddress(false);
        loadOptions.setDisplayCcEmailAddress(false);
        loadOptions.setDisplayBccEmailAddress(false);

        Converter converter = new Converter(Constants.SAMPLE_MSG, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nEmail document converted successfully. \nCheck output in "+ outputFolder);
    }
}