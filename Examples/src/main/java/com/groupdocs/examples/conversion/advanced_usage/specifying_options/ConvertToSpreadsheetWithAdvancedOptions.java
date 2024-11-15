package com.groupdocs.examples.conversion.advanced_usage.specifying_options;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.filetypes.SpreadsheetFileType;
import com.groupdocs.conversion.options.convert.SpreadsheetConvertOptions;
import com.groupdocs.conversion.options.load.WordProcessingLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert password-protected document to Spreadsheet and specifying pages to be converted
 */
public class ConvertToSpreadsheetWithAdvancedOptions {
    public static Path run(Path sourceFile) {
        final int pageNumber = 2;
        final Path outputPath = FilesUtils.makeOutputPath(String.format("ConvertToSpreadsheetWithAdvancedOptions-%d.xls", pageNumber));

        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        loadOptions.setPassword("12345");

        try (Converter converter = new Converter(sourceFile.toString(), () -> loadOptions)) {
            SpreadsheetConvertOptions options = new SpreadsheetConvertOptions();
            options.setPageNumber(pageNumber);
            options.setPagesCount(1);
            options.setFormat(SpreadsheetFileType.Xls);
            options.setZoom(150);

            converter.convert(outputPath.toString(), options);

            System.out.println("\nPassword protected document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}