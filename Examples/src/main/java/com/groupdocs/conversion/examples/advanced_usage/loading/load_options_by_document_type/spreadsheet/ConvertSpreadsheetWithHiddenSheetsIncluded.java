package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.spreadsheet;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.SpreadsheetLoadOptions;

/**
 * This example demonstrates how to convert a spreadsheet document to pdf with advanced options
 */
public class ConvertSpreadsheetWithHiddenSheetsIncluded {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertSpreadsheetWithHiddenSheetsIncluded.pdf");
        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        loadOptions.setShowHiddenSheets(true);
        loadOptions.setOnePagePerSheet(true);
        Converter converter = new Converter(Constants.SAMPLE_XLSX_WITH_HIDDEN_SHEET, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nSpreadsheet document converted successfully. \nCheck output in " + convertedFile);
    }
}