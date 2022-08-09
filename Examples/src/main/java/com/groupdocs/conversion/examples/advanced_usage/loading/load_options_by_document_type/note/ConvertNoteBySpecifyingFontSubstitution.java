package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.note;


import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.FontSubstitute;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.NoteLoadOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * This example demonstrates how to convert a note document to pdf with advanced options
 */
public class ConvertNoteBySpecifyingFontSubstitution {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertNoteBySpecifyingFontSubstitution.pdf");
        NoteLoadOptions loadOptions = new NoteLoadOptions();
        List<FontSubstitute> fontSubstitutes = new ArrayList<FontSubstitute>();
        fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
        fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
        loadOptions.setFontSubstitutes(fontSubstitutes);
        loadOptions.setDefaultFont(Constants.FontsPath + "terminal-grotesque_open.otf");

        Converter converter = new Converter(Constants.SAMPLE_ONE, () -> loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nNote document converted successfully. \nCheck output in " + convertedFile);
    }
}