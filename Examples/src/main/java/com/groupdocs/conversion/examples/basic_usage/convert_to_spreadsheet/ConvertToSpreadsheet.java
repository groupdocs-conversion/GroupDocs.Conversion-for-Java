package com.groupdocs.conversion.examples.basic_usage.convert_to_spreadsheet;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;


/**
* This example demonstrates how to convert document to Spreadsheet.
*/
public class ConvertToSpreadsheet {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.xlsx").getPath();

        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        SpreadsheetConvertOptions options = new SpreadsheetConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nConversion to spreadsheet completed successfully. \nCheck output in "+ outputFolder);
    }
}