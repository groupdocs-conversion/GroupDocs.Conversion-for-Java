package com.groupdocs.conversion.examples.basic_usage.convert_to_image;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.SavePageStream;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * This example demonstrates how to convert VSDX to PNG, saving each page to a separate file.
 */
public class ConvertVsdxToPng {
    public static void run() {
        String outputFolder = Constants.getOutputDirectoryPath("ConvertVsdxToPng");
        String outputFileTemplate = new File(outputFolder, "converted-page-%d.png").getPath();

        SavePageStream getPageStream = pageNumber -> {
            try {
                return new FileOutputStream(String.format(outputFileTemplate, pageNumber));
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        };

        try (Converter converter = new Converter(Constants.SAMPLE_VSDX)) {
            ImageConvertOptions options = new ImageConvertOptions();
            options.setFormat(ImageFileType.Png);
            converter.convert(getPageStream, options);
        }

        System.out.print("\nConversion to png completed successfully. \nCheck output in " + outputFolder);
    }
}
