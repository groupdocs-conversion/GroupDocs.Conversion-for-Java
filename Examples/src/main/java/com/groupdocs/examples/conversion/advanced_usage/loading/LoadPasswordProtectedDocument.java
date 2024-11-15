package com.groupdocs.examples.conversion.advanced_usage.loading;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.WordProcessingLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to load and convert password-protected document.
 */
public class LoadPasswordProtectedDocument {
    public static Path run(Path inputFile) {
        final String password = "12345";
        final Path outputPath = FilesUtils.makeOutputPath("LoadPasswordProtectedDocument.pdf");

        try (Converter converter = new Converter(inputFile.toString(), () -> {
            WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
            loadOptions.setPassword(password);
            return loadOptions;
        })) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nPassword protected document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}