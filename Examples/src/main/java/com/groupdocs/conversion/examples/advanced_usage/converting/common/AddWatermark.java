package com.groupdocs.conversion.examples.advanced_usage.converting.common;

import com.groupdocs.conversion.examples.Constants;

import java.awt.*;
import java.io.File;
/**
* This example demonstrates how to add watermark during conversion
*/
public class AddWatermark {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();

        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        PdfConvertOptions options = new PdfConvertOptions();
        WatermarkOptions watermark = new WatermarkOptions();
        watermark.setText("Sample watermark");
        watermark.setColor(Color.red);
        watermark.setWidth(100);
        watermark.setHeight(100);
        watermark.setBackground = true;

        options.setWatermark(watermark);

        converter.convert(outputFile, options);


        System.out.print("\nDocument converted successfully. \nCheck output in " + outputFolder);
    }
}