package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.presentation;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.FontSubstitute;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.PresentationLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This example demonstrates how to convert a presentation document to pdf with advanced options
 */
public class ConvertPresentationBySpecifyingFontSubstitution {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertPresentationBySpecifyingFontSubstitution.pdf");
        final Path fontPath = FilesUtils.makeFontPath("Helvetica.ttf");

        PresentationLoadOptions loadOptions = new PresentationLoadOptions();
        List<FontSubstitute> fontSubstitutes = new ArrayList<>();
        fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
        fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
        loadOptions.setDefaultFont(fontPath.toString());
        loadOptions.setFontSubstitutes(fontSubstitutes);

        try (Converter converter = new Converter(inputFile.toString(), () -> loadOptions)) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nPresentation document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}