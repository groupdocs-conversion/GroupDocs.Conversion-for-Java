package com.groupdocs.examples.conversion.advanced_usage.specifying_options;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.MarkupConvertOptions;
import com.groupdocs.conversion.options.load.WordProcessingLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;


/**
 * This example demonstrates how to convert password-protected document to HTML and specifying pages to be converted
 */
public class ConvertToHtmlWithAdvancedOptions {
    public static Path run(Path sourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertToHtmlWithAdvancedOptions.html");

        try (Converter converter = new Converter(sourceFile.toString(), () -> {
            WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
            loadOptions.setPassword("12345");
            return loadOptions;
        })) {
            MarkupConvertOptions options = new MarkupConvertOptions();
            options.setPageNumber(2);
            options.setFixedLayout(true);
            options.setPagesCount(1);

            converter.convert(outputPath.toString(), options);

            System.out.println("\nPassword protected document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}