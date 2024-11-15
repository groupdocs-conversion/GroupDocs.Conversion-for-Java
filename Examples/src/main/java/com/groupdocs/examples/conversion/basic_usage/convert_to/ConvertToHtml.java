package com.groupdocs.examples.conversion.basic_usage.convert_to;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.MarkupConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;

import java.nio.file.Path;

import static com.groupdocs.examples.conversion.utils.FilesUtils.makeOutputPath;
import static com.groupdocs.examples.conversion.utils.FilesUtils.obtainExtension;

/**
 * This example demonstrates how to convert document to HTML.
 */
public class ConvertToHtml {
    public static Path run(Path inputFile) {

        final Path outputPath = makeOutputPath("ConvertToHtml.html");

        try (Converter converter = new Converter(inputFile.toString())) {
            MarkupConvertOptions options = new MarkupConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nConversion to HTML completed successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}