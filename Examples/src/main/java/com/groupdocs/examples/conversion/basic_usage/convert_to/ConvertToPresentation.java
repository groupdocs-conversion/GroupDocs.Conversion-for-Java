package com.groupdocs.examples.conversion.basic_usage.convert_to;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PresentationConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;


/**
 * This example demonstrates how to convert document to Presentation.
 */
public class ConvertToPresentation {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertToPresentation.pptx");

        try (Converter converter = new Converter(inputFile.toString())) {
            PresentationConvertOptions options = new PresentationConvertOptions();
            converter.convert(outputPath.toString(), options);

            System.out.print("\nConversion to presentation completed successfully. \nCheck output: " + outputPath);
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}