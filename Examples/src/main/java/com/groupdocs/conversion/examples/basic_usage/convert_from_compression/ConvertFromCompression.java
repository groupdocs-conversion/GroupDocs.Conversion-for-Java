package com.groupdocs.conversion.examples.basic_usage.convert_from_compression;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Paths;

/**
 * This example demonstrates how to extract and convert from a Zip.
 */
public class ConvertFromCompression {
    public static void run() {
        String outputFolder = Constants.getOutputDirectoryPath(null);

        try (Converter converter = new Converter(Constants.SAMPLE_ZIP)) {
            PdfConvertOptions options = new PdfConvertOptions();
            final int[] i = {0};
            converter.convert(() -> {
                try {
                    return new FileOutputStream(Paths.get(outputFolder, String.format("converted-%d.pdf", ++i[0])).toFile());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }, options);
        }

        System.out.printf("\nConversion from compression completed successfully. \nCheck output in %s", outputFolder);
    }
}
