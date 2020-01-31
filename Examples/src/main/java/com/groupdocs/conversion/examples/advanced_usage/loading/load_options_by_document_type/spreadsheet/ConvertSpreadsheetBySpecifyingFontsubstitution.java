package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.spreadsheet;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.FontSubstitute;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.SpreadsheetLoadOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConvertSpreadsheetBySpecifyingFontsubstitution {
    /**
    * This example demonstrates how to convert a spreadsheet document to pdf with advanced options
    */
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();


        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        List<FontSubstitute> fontSubstitutes = new ArrayList<FontSubstitute>();
        fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
        fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
        loadOptions.setDefaultFont("Helvetica");
        loadOptions.setOnePagePerSheet(true);
        loadOptions.setFontSubstitutes(fontSubstitutes);

        Converter converter = new Converter(Constants.SAMPLE_XLSX, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nSpreadsheet document converted successfully. \nCheck output in "+ outputFolder);
    }
}