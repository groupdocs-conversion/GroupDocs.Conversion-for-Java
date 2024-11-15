package com.groupdocs.examples.conversion.advanced_usage.common;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.convert.WatermarkTextOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.awt.*;
import java.nio.file.Path;

/**
 * This example demonstrates how to add watermark during conversion
 */
public class AddWatermark {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AddWatermark.pdf");

        try (Converter converter = new Converter(inputFile.toString())) {
            PdfConvertOptions options = new PdfConvertOptions();
            WatermarkTextOptions watermark = new WatermarkTextOptions("Sample watermark");
            watermark.setColor(Color.red);
            watermark.setWidth(100);
            watermark.setHeight(100);
            watermark.setBackground(true);
            options.setWatermark(watermark);

            converter.convert(outputPath.toString(), options);

            System.out.println("\nDocument converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}