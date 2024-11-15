package com.groupdocs.examples.conversion.advanced_usage.common;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * This example demonstrates how to convert specific pages
 */
public class ConvertSpecificPages {
    public static Path run(Path inputFile) {
        final List<Integer> pageNumbers = Arrays.asList(2, 3);
        final Path outputPath = FilesUtils.makeOutputPath("ConvertSpecificPages.pdf");

        try (Converter converter = new Converter(inputFile.toString())) {
            PdfConvertOptions options = new PdfConvertOptions();
            options.setPages(pageNumbers);

            converter.convert(outputPath.toString(), options);

            System.out.println("\nDocument converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}