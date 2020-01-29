package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.pdf;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;

/** <summary>
* This example demonstrates how to convert a pdf document to wordprocessing with advanced options
*/
public class ConvertPdfAndRemoveEmbeddedFiles {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.docx").getPath();

        Contracts.Func<LoadOptions> getLoadOptions = () => new PdfLoadOptions
        {
            RemoveEmbeddedFiles = true
        };
        Converter converter = new Converter(Constants.SAMPLE_PDF, getLoadOptions);
        WordProcessingConvertOptions options = new WordProcessingConvertOptions();
        converter.convert(outputFile, options);

        System.out.println("\nPdf document converted successfully. \nCheck output in " + outputFolder);
    }
}