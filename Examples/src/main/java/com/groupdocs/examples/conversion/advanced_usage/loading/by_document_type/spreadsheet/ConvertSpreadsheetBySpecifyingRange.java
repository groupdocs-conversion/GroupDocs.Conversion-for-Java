package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.spreadsheet;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.SpreadsheetLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert a spreadsheet document to pdf with advanced options
 */
public class ConvertSpreadsheetBySpecifyingRange {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertSpreadsheetBySpecifyingRange.pdf");
        final String range = "10:30";
        final boolean onePagePerSheet = true;

        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        loadOptions.setConvertRange(range);
        loadOptions.setOnePagePerSheet(onePagePerSheet);

        try (Converter converter = new Converter(inputFile.toString(), () -> loadOptions)) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nSpreadsheet document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}