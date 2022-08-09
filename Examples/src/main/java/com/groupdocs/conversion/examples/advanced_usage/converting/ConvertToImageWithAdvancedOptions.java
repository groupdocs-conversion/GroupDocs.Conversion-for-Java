package com.groupdocs.conversion.examples.advanced_usage.converting;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;
import com.groupdocs.conversion.options.convert.ImageFlipModes;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This example demonstrates how to convert a pdf document to image with advanced options
 */
public class ConvertToImageWithAdvancedOptions {
    public static void run() {
        String outputFileTemplate = Constants.getConvertedPath("ConvertToImageWithAdvancedOptions-converted-page-%s.png");

        try {
            FileOutputStream getPageStream = new FileOutputStream(String.format(outputFileTemplate, 1));

            Converter converter = new Converter(Constants.SAMPLE_PDF);
            ImageConvertOptions options = new ImageConvertOptions();
            options.setFormat(ImageFileType.Png);
            options.setFlipMode(ImageFlipModes.FlipY);
            options.setBrightness(50);
            options.setContrast(50);
            options.setGamma(0.5F);
            options.setGrayscale(true);
            options.setHorizontalResolution(300);
            options.setVerticalResolution(100);
            options.setPageNumber(1);
            options.setPagesCount(1);

            converter.convert(() -> getPageStream, options);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        System.out.print("\nDocument converted successfully. \nCheck output in " + Constants.getConvertedPath(""));
    }
}