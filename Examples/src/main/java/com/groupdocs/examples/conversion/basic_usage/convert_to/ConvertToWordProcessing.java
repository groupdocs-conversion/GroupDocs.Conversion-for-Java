package com.groupdocs.examples.conversion.basic_usage.convert_to;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.WordProcessingConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert document to WordProcessing.
 */
public class ConvertToWordProcessing {
    public static Path run(Path sourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertToWordProcessing.docx");

        try (Converter converter = new Converter(sourceFile.toString())) {
            WordProcessingConvertOptions options = new WordProcessingConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nConversion to wordprocessing completed successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}