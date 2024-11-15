package com.groupdocs.examples.conversion.quick_start;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;

import java.nio.file.Path;

import static com.groupdocs.examples.conversion.utils.FilesUtils.makeOutputPath;
import static com.groupdocs.examples.conversion.utils.FilesUtils.obtainExtension;

public class HelloWorld {

    public static Path run(Path inputFile) {

        final Path outputPath = makeOutputPath("HelloWorld.pdf");

        try (Converter converter = new Converter(inputFile.toString())) {
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert(outputPath.toString(), options);

            System.out.println("\nDocuments compared successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}