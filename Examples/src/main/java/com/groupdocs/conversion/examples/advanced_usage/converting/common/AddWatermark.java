package com.groupdocs.conversion.examples.advanced_usage.converting.common;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.convert.WatermarkOptions;

import java.awt.*;

/**
 * This example demonstrates how to add watermark during conversion
 */
public class AddWatermark {
    public static void run() {
        String convertedFile = Constants.getConvertedPath("AddWatermark.pdf");
        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        PdfConvertOptions options = new PdfConvertOptions();
        WatermarkOptions watermark = new WatermarkOptions();
        watermark.setText("Sample watermark");
        watermark.setColor(Color.red);
        watermark.setWidth(100);
        watermark.setHeight(100);
        watermark.setBackground(true);
        options.setWatermark(watermark);
        converter.convert(convertedFile, options);

        System.out.print("\nDocument converted successfully. \nCheck output in " + convertedFile);
    }
}