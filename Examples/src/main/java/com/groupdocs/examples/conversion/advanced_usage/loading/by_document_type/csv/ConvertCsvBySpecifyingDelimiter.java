package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.csv;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.CsvLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert a csv document to pdf with advanced options
 */
public class ConvertCsvBySpecifyingDelimiter {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertCsvBySpecifyingDelimiter.pdf");

        final char delimiter = ',';

        try (Converter converter = new Converter(inputFile.toString(), () -> {
            CsvLoadOptions loadOptions = new CsvLoadOptions();
            loadOptions.setSeparator(delimiter);
            return loadOptions;
        })) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nCsv document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}