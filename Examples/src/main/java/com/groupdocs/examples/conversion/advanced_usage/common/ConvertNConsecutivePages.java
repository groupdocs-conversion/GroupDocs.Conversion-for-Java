package com.groupdocs.examples.conversion.advanced_usage.common;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert range of pages
 */
public class ConvertNConsecutivePages {
    public static Path run(Path inputFile) {
        final int startPage = 2;
        final int pageCount = 2;
        final Path outputPath = FilesUtils.makeOutputPath(String.format("ConvertNConsecutivePages-%d-%d.pdf", startPage, pageCount));

        try (Converter converter = new Converter(inputFile.toString())) {
            PdfConvertOptions options = new PdfConvertOptions();
            options.setPageNumber(startPage);
            options.setPagesCount(pageCount);

            converter.convert(outputPath.toString(), options);

            System.out.println("\nDocument converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}