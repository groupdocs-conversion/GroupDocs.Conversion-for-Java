package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.csv;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.CsvLoadOptions;

/**
 * This example demonstrates how to convert a csv document to pdf with advanced options
 */
public class ConvertCsvBySpecifyingEncoding {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertCsvBySpecifyingEncoding.pdf");
        CsvLoadOptions loadOptions = new CsvLoadOptions();
        loadOptions.setEncoding(java.nio.charset.Charset.forName("shift_jis"));
        Converter converter = new Converter(Constants.SAMPLE_CSV, () -> loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nCsv document converted successfully. \nCheck output in " + convertedFile);
    }
}