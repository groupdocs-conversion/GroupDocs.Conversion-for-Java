package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.txt;

/**
* This example demonstrates how to convert a txt document to pdf with advanced options
*/
public class ConvertTxtByControlingTrailingSpacesBehavior {
    public static void run()
    {
        String outputFolder = Constants.GetOutputDirectoryPath();
        String outputFile = Path.Combine(outputFolder, "converted.pdf");


        Contracts.Func<LoadOptions> getLoadOptions = () => new TxtLoadOptions
        {
            TrailingSpacesOptions = TxtTrailingSpacesOptions.Trim
        };

        Converter converter = new Converter(Constants.SAMPLE_TXT, getLoadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nTxt document converted successfully. \nCheck output in "+ outputFolder);
    }
}