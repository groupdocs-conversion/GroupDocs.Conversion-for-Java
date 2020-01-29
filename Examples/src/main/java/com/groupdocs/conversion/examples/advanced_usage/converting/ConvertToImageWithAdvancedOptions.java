package com.groupdocs.conversion.examples.advanced_usage.converting;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;


/**
* This example demonstrates how to convert a pdf document to image with advanced options
*/
public class ConvertToImageWithAdvancedOptions {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFileTemplate = new File(outputFolder, "converted-page-{0}.png").getPath();

        SavePageStream getPageStream = page => new FileStream(string.Format(outputFileTemplate, page), FileMode.Create);

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

        converter.convert(getPageStream, options);


        System.out.print("\nDocument converted successfully. \nCheck output in " + outputFolder);
    }
}