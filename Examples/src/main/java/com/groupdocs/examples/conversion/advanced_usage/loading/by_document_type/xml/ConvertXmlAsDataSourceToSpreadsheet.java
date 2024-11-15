package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.xml;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.SpreadsheetConvertOptions;
import com.groupdocs.conversion.options.load.XmlLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert a xml document to spreadsheet with advanced options
 */
public class ConvertXmlAsDataSourceToSpreadsheet {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("converted.xlsx");

        XmlLoadOptions loadOptions = new XmlLoadOptions();
        loadOptions.setUseAsDataSource(true);

        try (Converter converter = new Converter(inputFile.toString(), () -> loadOptions)) {
            SpreadsheetConvertOptions options = new SpreadsheetConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nXml document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
