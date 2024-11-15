package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.pdf;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.WordProcessingConvertOptions;
import com.groupdocs.conversion.options.load.PdfLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert a pdf document to wordprocessing with advanced options
 */
public class ConvertPdfAndHideAnnotations {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertPdfAndHideAnnotations.docx");

        PdfLoadOptions loadOptions = new PdfLoadOptions();
        loadOptions.setHidePdfAnnotations(true);

        try (Converter converter = new Converter(inputFile.toString(), () -> loadOptions)) {
            WordProcessingConvertOptions options = new WordProcessingConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nPDF document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}