package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.spreadsheet;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.FontSubstitute;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.SpreadsheetLoadOptions;

import java.util.ArrayList;
import java.util.List;

public class ConvertSpreadsheetBySpecifyingFontsubstitution {
    /**
     * This example demonstrates how to convert a spreadsheet document to pdf with advanced options
     */
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertSpreadsheetBySpecifyingFontsubstitution.pdf");
        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        List<FontSubstitute> fontSubstitutes = new ArrayList<FontSubstitute>();
        fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
        fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
        loadOptions.setDefaultFont("Helvetica");
        loadOptions.setOnePagePerSheet(true);
        loadOptions.setFontSubstitutes(fontSubstitutes);
        Converter converter = new Converter(Constants.SAMPLE_XLSX, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nSpreadsheet document converted successfully. \nCheck output in " + convertedFile);
    }
}