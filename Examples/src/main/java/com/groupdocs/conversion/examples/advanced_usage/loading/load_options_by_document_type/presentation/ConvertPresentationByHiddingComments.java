package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.presentation;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;

/**
* This example demonstrates how to convert a presentation document to pdf with advanced options
*/
public class ConvertPresentationByHiddingComments {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();

        Contracts.Func<LoadOptions> getLoadOptions = () => new PresentationLoadOptions
        {
            HideComments = true
        };

        Converter converter = new Converter(Constants.PPTX_WITH_NOTES, getLoadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nPresentation document converted successfully. \nCheck output in "+ outputFolder);
    }
}