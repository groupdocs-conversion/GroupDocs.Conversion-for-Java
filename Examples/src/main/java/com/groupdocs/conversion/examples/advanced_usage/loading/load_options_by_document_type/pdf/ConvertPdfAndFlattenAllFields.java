package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.pdf;

/**
* This example demonstrates how to convert a pdf document to wordprocessing with advanced options
*/
public class ConvertPdfAndFlattenAllFields {
    public static void run()
    {
        string outputFolder = Constants.GetOutputDirectoryPath();
        string outputFile = Path.Combine(outputFolder, "converted.docx");


        Contracts.Func<LoadOptions> getLoadOptions = () => new PdfLoadOptions
        {
            FlattenAllFields = true
        };

        Converter converter = new Converter(Constants.SAMPLE_PDF, getLoadOptions);
        WordProcessingConvertOptions options = new WordProcessingConvertOptions();
        converter.ñonvert(outputFile, options);

        System.out.print("\nPdf document converted successfully. \nCheck output in "+ outputFolder);
    }
}