package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.xml;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.SpreadsheetConvertOptions;
import com.groupdocs.conversion.options.load.XmlLoadOptions;

/**
 * This example demonstrates how to convert a xml document to spreadsheet with advanced options
 */
public class ConvertXmlAsDataSourceToSpreadsheet {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("converted.xlsx");
        XmlLoadOptions loadOptions = new XmlLoadOptions();
        loadOptions.setUseAsDataSource(true);
        Converter converter = new Converter(Constants.SAMPLE_XML_DATASOURCE, loadOptions);
        SpreadsheetConvertOptions options = new SpreadsheetConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nXml document converted successfully. \nCheck output in " + convertedFile);
    }
}
