package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.cad;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.CadLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert a cad document to pdf with advanced options
 */
public class ConvertCadAndSpecifyLayouts {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertCadAndSpecifyLayouts.pdf");

        final String[] layoutNames = {"Layout1", "Layout3"};

        try (Converter converter = new Converter(inputFile.toString(), () -> {
            CadLoadOptions loadOptions = new CadLoadOptions();
            loadOptions.setLayoutNames(layoutNames);
            return loadOptions;
        })) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nCad document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}