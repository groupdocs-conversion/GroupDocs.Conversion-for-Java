package com.groupdocs.conversion.examples.basic_usage.convert_to_image;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PageDescriptionLanguageConvertOptions;
import com.groupdocs.conversion.filetypes.PageDescriptionLanguageFileType;

/**
 * This example demonstrates how to convert MPP to SVG.
 */
public class ConvertMppToSvg {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("ConvertMppToSvg.svg");

        try (Converter converter = new Converter(Constants.SAMPLE_MPP)) {
            PageDescriptionLanguageConvertOptions options = new PageDescriptionLanguageConvertOptions();
            options.setFormat(PageDescriptionLanguageFileType.Svg);
            converter.convert(convertedFile, options);
        }

        System.out.print("\nConversion to svg completed successfully. \nCheck output in " + convertedFile);
    }
}
