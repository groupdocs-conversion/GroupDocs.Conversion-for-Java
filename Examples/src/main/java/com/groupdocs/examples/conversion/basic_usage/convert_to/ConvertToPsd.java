package com.groupdocs.examples.conversion.basic_usage.convert_to;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This example demonstrates how to convert document to PSD.
 */
public class ConvertToPsd {
    public static Path run(Path inputFile) {

        final int pageNumber = 1;
        final Path outputPath = FilesUtils.makeOutputPath(String.format("ConvertToPsd-%d.psd", pageNumber));

        try (final OutputStream outputStream = Files.newOutputStream(outputPath);
             Converter converter = new Converter(inputFile.toString())) {

            ImageConvertOptions options = new ImageConvertOptions();
            options.setFormat(ImageFileType.Psd);
            options.setPagesCount(pageNumber);

            converter.convert(() -> outputStream, options);

            System.out.println("\nConversion to PSD completed successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}