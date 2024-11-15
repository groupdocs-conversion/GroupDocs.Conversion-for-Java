package com.groupdocs.examples.conversion.advanced_usage.specifying_options;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;
import com.groupdocs.conversion.options.convert.ImageFlipModes;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This example demonstrates how to convert a pdf document to image with advanced options
 */
public class ConvertToImageWithAdvancedOptions {
    public static Path run(Path inputFile) {
        final int pageNumber = 1;
        final Path outputPath = FilesUtils.makeOutputPath(String.format("ConvertToImageWithAdvancedOptions-%d.png", pageNumber));

        try (OutputStream outputStream = Files.newOutputStream(outputPath);
             Converter converter = new Converter(inputFile.toString())) {

            ImageConvertOptions options = new ImageConvertOptions();
            options.setFormat(ImageFileType.Png);
            options.setFlipMode(ImageFlipModes.FlipY);
            options.setBrightness(50);
            options.setContrast(50);
            options.setGamma(0.5F);
            options.setGrayscale(true);
            options.setHorizontalResolution(300);
            options.setVerticalResolution(100);
            options.setPageNumber(pageNumber);
            options.setPagesCount(1);

            converter.convert(() -> outputStream, options);

            System.out.println("\nPassword protected document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}