package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.note;


import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.FontSubstitute;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.NoteLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This example demonstrates how to convert a note document to pdf with advanced options
 */
public class ConvertNoteBySpecifyingFontSubstitution {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertNoteBySpecifyingFontSubstitution.pdf");
        final Path fontPath = FilesUtils.makeFontPath("terminal-grotesque_open.otf");

        NoteLoadOptions loadOptions = new NoteLoadOptions();
        List<FontSubstitute> fontSubstitutes = new ArrayList<>();
        fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
        fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
        loadOptions.setFontSubstitutes(fontSubstitutes);
        loadOptions.setDefaultFont(fontPath.toString());

        try (Converter converter = new Converter(inputFile.toString(), () -> loadOptions)) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nNote document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}