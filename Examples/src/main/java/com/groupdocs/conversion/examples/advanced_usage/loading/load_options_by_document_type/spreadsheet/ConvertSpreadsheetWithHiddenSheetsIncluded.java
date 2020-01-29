package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.spreadsheet;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;

/**
* This example demonstrates how to convert a spreadsheet document to pdf with advanced options
*/
public class ConvertSpreadsheetWithHiddenSheetsIncluded {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();


        Contracts.Func<LoadOptions> getLoadOptions = () => new SpreadsheetLoadOptions
        {
            ShowHiddenSheets = true,
                    OnePagePerSheet = true,
        };
        Converter converter = new Converter(Constants.SAMPLE_XLSX_WITH_HIDDEN_SHEET, getLoadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nSpreadsheet document converted successfully. \nCheck output in "+ outputFolder);
    }
}