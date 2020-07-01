package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.cad;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.CadLoadOptions;

/**
 * This example demonstrates how to convert a cad document to pdf with advanced options
 */
public class ConvertCadAndSpecifyLayouts {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertCadAndSpecifyLayouts.pdf");
        CadLoadOptions loadOptions = new CadLoadOptions();
        loadOptions.setLayoutNames(new String[]{"Layout1", "Layout3"});
        Converter converter = new Converter(Constants.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nCad document converted successfully. \nCheck output in " + convertedFile);
    }
}