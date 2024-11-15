package com.groupdocs.examples.conversion.advanced_usage.specifying_options;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.filetypes.PresentationFileType;
import com.groupdocs.conversion.options.convert.PresentationConvertOptions;
import com.groupdocs.conversion.options.load.WordProcessingLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert password-protected document to presentation and specifying pages to be converted
 */
public class ConvertToPresentationWithAdvancedOptions {
    public static Path run(Path sourceFile) {
        final int pageNumber = 2;
        final Path outputPath = FilesUtils.makeOutputPath(String.format("ConvertToPresentationWithAdvancedOptions-%d.ppt", pageNumber));

        try (Converter converter = new Converter(sourceFile.toString(), () -> {
            WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
            loadOptions.setPassword("12345");
            return loadOptions;
        })) {
            PresentationConvertOptions options = new PresentationConvertOptions();
            options.setPageNumber(pageNumber);
            options.setPagesCount(1);
            options.setFormat(PresentationFileType.Ppt);

            converter.convert(outputPath.toString(), options);

            System.out.println("\nPassword protected document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}