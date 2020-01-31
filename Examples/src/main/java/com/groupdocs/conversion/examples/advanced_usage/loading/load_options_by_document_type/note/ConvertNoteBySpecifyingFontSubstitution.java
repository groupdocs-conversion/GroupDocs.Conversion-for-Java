package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.note;


import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.FontSubstitute;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.NoteLoadOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
* This example demonstrates how to convert a note document to pdf with advanced options
*/
public class ConvertNoteBySpecifyingFontSubstitution {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();


        NoteLoadOptions loadOptions = new NoteLoadOptions();

        List<FontSubstitute> fontSubstitutes = new ArrayList<FontSubstitute>();
        fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
        fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
        loadOptions.setFontSubstitutes(fontSubstitutes);
        loadOptions.setDefaultFont("Helvetica");

        Converter converter = new Converter(Constants.SAMPLE_ONE, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);

        System.out.print("\nNote document converted successfully. \nCheck output in " + outputFolder);
    }
}