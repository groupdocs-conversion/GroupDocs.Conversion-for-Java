package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.email;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.EmailLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert an email document to pdf with advanced options
 */
public class ConvertEmailWithAlteringFieldsVisibility {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertEmailWithAlteringFieldsVisibility.pdf");

        EmailLoadOptions loadOptions = new EmailLoadOptions();
        loadOptions.setDisplayHeader(false);
        loadOptions.setDisplayFromEmailAddress(false);
        loadOptions.setDisplayToEmailAddress(false);
        loadOptions.setDisplayEmailAddress(false);
        loadOptions.setDisplayCcEmailAddress(false);
        loadOptions.setDisplayBccEmailAddress(false);
        loadOptions.setConvertOwned(false);

        try (Converter converter = new Converter(inputFile.toString(), () -> loadOptions)) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nEmail document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}