package com.groupdocs.examples.conversion.basic_usage.convert_to;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert document to PDF.
 */
public class ConvertToPdf {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertToPdf.pdf");

        try (Converter converter = new Converter(inputFile.toString())) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nConversion to pdf completed successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}