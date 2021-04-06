package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.presentation;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.FontSubstitute;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.PresentationLoadOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * This example demonstrates how to convert a presentation document to pdf with advanced options
 */
public class ConvertPresentationBySpecifyingFontSubstitution {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertPresentationBySpecifyingFontSubstitution.pdf");
        PresentationLoadOptions loadOptions = new PresentationLoadOptions();
        List<FontSubstitute> fontSubstitutes = new ArrayList<FontSubstitute>();
        fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
        fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
        loadOptions.setDefaultFont("resources/fonts/Helvetica.ttf");
        loadOptions.setFontSubstitutes(fontSubstitutes);
        Converter converter = new Converter(Constants.PPTX_WITH_NOTES, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nPresentation document converted successfully. \nCheck output in " + convertedFile);
    }
}