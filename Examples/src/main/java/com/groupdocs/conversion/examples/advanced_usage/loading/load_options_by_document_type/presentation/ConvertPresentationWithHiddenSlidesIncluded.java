package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.presentation;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.PresentationLoadOptions;

/**
 * This example demonstrates how to convert a presentation document to pdf with advanced options
 */
public class ConvertPresentationWithHiddenSlidesIncluded {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertPresentationWithHiddenSlidesIncluded.pdf");
        PresentationLoadOptions loadOptions = new PresentationLoadOptions();
        loadOptions.setShowHiddenSlides(true);
        Converter converter = new Converter(Constants.SAMPLE_PPTX_HIDDEN_PAGE, () -> loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nPresentation document converted successfully. \nCheck output in " + convertedFile);
    }
}