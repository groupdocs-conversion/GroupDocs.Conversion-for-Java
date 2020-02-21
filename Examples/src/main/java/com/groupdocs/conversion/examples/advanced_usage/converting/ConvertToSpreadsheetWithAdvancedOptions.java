package com.groupdocs.conversion.examples.advanced_usage.converting;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.SpreadsheetFileType;
import com.groupdocs.conversion.options.convert.SpreadsheetConvertOptions;
import com.groupdocs.conversion.options.load.WordProcessingLoadOptions;

import java.io.File;


/**
* This example demonstrates how to convert password-protected document to Spreadsheet and specifying pages to be converted
*/
public class ConvertToSpreadsheetWithAdvancedOptions {
    public static void run()
    {
        String convertedFile = Constants.getConvertedPath("ConvertToSpreadsheetWithAdvancedOptions.xls");  
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        loadOptions.setPassword("12345");
        Converter converter = new Converter(Constants.SAMPLE_DOCX_WITH_PASSWORD, loadOptions);
        SpreadsheetConvertOptions options = new SpreadsheetConvertOptions();
        options.setPageNumber(2);
        options.setPagesCount(1);
        options.setFormat(SpreadsheetFileType.Xls);
        options.setZoom(150);
        converter.convert(convertedFile, options);

        System.out.print("\nPassword protected document converted successfully. \nCheck output in " + convertedFile);
    }
}