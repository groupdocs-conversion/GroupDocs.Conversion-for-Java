package com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.exceptions.GroupDocsConversionException;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;


/**
 * This example demonstrates how to download and convert document.
 */
public class FromUrl {
    public static Path run(String url) throws GroupDocsConversionException {
        final Path outputPath = FilesUtils.makeOutputPath("FromUrl.pdf");

        try (InputStream inputStream = new URL(url).openStream();
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