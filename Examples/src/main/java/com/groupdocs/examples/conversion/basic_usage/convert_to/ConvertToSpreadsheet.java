package com.groupdocs.examples.conversion.basic_usage.convert_to;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.SpreadsheetConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert document to Spreadsheet.
 */
public class ConvertToSpreadsheet {
    public static Path run(Path sourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertToSpreadsheet.xlsx");

        try (Converter converter = new Converter(sourceFile.toString())) {
            SpreadsheetConvertOptions options = new SpreadsheetConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nConversion to spreadsheet completed successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}