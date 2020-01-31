package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.csv;


import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.CsvLoadOptions;

import java.io.File;

/**
* This example demonstrates how to convert a csv document to pdf with advanced options
*/
public class ConvertCsvBySpecifyingDelimiter {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();

        CsvLoadOptions loadOptions = new CsvLoadOptions();
        loadOptions.setSeparator(',');

        Converter converter = new Converter(Constants.SAMPLE_CSV, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nCsv document converted successfully. \nCheck output in "+ outputFolder);
    }
}