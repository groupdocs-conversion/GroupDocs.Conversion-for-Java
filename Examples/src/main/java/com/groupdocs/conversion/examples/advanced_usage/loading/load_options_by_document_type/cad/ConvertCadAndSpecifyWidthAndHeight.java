package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.cad;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;
import com.groupdocs.conversion.options.load.CadLoadOptions;


/**
 * This example demonstrates how to convert a cad document to pdf with advanced options
 */
public class ConvertCadAndSpecifyWidthAndHeight {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertCadAndSpecifyWidthAndHeight.tiff");
        CadLoadOptions loadOptions = new CadLoadOptions();
        loadOptions.setWidth(1920);
        loadOptions.setHeight(1080);
        Converter converter = new Converter(Constants.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS, () -> loadOptions);
        ImageConvertOptions options = new ImageConvertOptions();
        options.setFormat_ConvertOptions_New(ImageFileType.Tiff);
        converter.convert(convertedFile, options);

        System.out.print("\nCad document converted successfully. \nCheck output in " + convertedFile);
    }
}