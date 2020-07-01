package com.groupdocs.conversion.examples.basic_usage.convert_to_spreadsheet;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.SpreadsheetConvertOptions;

/**
 * This example demonstrates how to convert document to Spreadsheet.
 */
public class ConvertToSpreadsheet {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertToSpreadsheet.xlsx");
        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        SpreadsheetConvertOptions options = new SpreadsheetConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nConversion to spreadsheet completed successfully. \nCheck output in " + convertedFile);
    }
}