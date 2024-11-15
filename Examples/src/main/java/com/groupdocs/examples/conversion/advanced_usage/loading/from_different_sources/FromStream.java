package com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This example demonstrates how to convert document from stream.
 */
public class FromStream {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("FromStream.pdf");

        try (final InputStream inputStream = Files.newInputStream(inputFile);
             Converter converter = new Converter(() -> inputStream)) {
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert(outputPath.toString(), options);

            System.out.println("\nSource document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}