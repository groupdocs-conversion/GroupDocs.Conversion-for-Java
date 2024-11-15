package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.txt;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.TxtLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.charset.Charset;
import java.nio.file.Path;

/**
 * This example demonstrates how to convert a txt document to pdf with advanced options
 */
public class ConvertTxtBySpecifyingEncoding {
    public static Path run(Path inputFile) {
        final String encoding = "shift_jis";
        final Path outputPath = FilesUtils.makeOutputPath("ConvertTxtBySpecifyingEncoding.pdf");

        TxtLoadOptions loadOptions = new TxtLoadOptions();
        loadOptions.setEncoding(Charset.forName(encoding));

        try (Converter converter = new Converter(inputFile.toString(), () -> loadOptions)) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nTxt document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}