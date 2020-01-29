package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.note;


import com.groupdocs.conversion.examples.Constants;

import java.io.File;

/**
* This example demonstrates how to convert a note document to pdf with advanced options
*/
public class ConvertNoteBySpecifyingFontSubstitution {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();


        Contracts.Func<LoadOptions> getLoadOptions = () => new NoteLoadOptions
        {
            FontSubstitutes = new List<FontSubstitute>
            {
                FontSubstitute.Create("Tahoma", "Arial"),
                        FontSubstitute.Create("Times New Roman", "Arial"),
            },
            DefaultFont = "Helvetica"
        };

        Converter converter = new Converter(Constants.SAMPLE_ONE, getLoadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);

        System.out.print("\nNote document converted successfully. \nCheck output in " + outputFolder);
    }
}