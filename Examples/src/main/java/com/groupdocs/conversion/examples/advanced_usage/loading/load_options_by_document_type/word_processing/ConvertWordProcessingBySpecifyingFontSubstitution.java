package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.word_processing;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.FontSubstitute;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.WordProcessingLoadOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * This example demonstrates how to convert a word-processing document to pdf with advanced options
 */
public class ConvertWordProcessingBySpecifyingFontSubstitution {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertWordProcessingBySpecifyingFontSubstitution.pdf");
        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        loadOptions.setAutoFontSubstitution(false);
        loadOptions.setDefaultFont("resources/fonts/Helvetica.ttf");
        List<FontSubstitute> fontSubstitutes = new ArrayList<FontSubstitute>();
        fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
        fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
        loadOptions.setAutoFontSubstitution(false);
        loadOptions.setFontSubstitutes(fontSubstitutes);
        Converter converter = new Converter(Constants.SAMPLE_DOCX_WITH_TRACKED_CHANGES, () -> loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nWordProcessing document converted successfully. \nCheck output in " + convertedFile);
    }
}