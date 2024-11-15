package com.groupdocs.examples.conversion.basic_usage.convert_from;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;

import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.conversion.utils.FilesUtils.makeOutputPath;

/**
 * This example demonstrates how to extract and convert from a Zip.
 */
public class ConvertFromCompression {
    public static Path run(Path inputFile) {

        Path[] pagePreviewPath = new Path[1];
        try (Converter converter = new Converter(inputFile.toString())) {
            PdfConvertOptions options = new PdfConvertOptions();
            final int[] i = {0};
            converter.convert(() -> {
                pagePreviewPath[0] = makeOutputPath(String.format("converted-%d.pdf", ++i[0]));
                try {
                    return Files.newOutputStream(pagePreviewPath[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to create output stream for conversion result.", e);
                }
            }, options);

            System.out.println("\nDocuments compared successfully.\nCheck output: " + pagePreviewPath[0].getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return pagePreviewPath[0];
    }
}
