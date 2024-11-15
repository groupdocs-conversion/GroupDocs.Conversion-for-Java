package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.spreadsheet;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.FontSubstitute;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.SpreadsheetLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConvertSpreadsheetBySpecifyingFontSubstitution {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertSpreadsheetBySpecifyingFontSubstitution.pdf");
        final Path fontPath = FilesUtils.makeFontPath("Helvetica.ttf");

        SpreadsheetLoadOptions loadOptions = new SpreadsheetLoadOptions();
        List<FontSubstitute> fontSubstitutes = new ArrayList<>();
        fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
        fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
        loadOptions.setDefaultFont(fontPath.toString());
        loadOptions.setOnePagePerSheet(true);
        loadOptions.setFontSubstitutes(fontSubstitutes);

        try (Converter converter = new Converter(inputFile.toString(), () -> loadOptions)) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nSpreadsheet document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}