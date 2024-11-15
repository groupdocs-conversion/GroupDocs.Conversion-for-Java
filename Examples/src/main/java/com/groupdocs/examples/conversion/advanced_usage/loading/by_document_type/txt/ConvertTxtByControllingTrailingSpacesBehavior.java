package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.txt;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.TxtLoadOptions;
import com.groupdocs.conversion.options.load.TxtTrailingSpacesOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to convert a txt document to pdf with advanced options
 */
public class ConvertTxtByControllingTrailingSpacesBehavior {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertTxtByControllingTrailingSpacesBehavior.pdf");

        TxtLoadOptions loadOptions = new TxtLoadOptions();
        loadOptions.setTrailingSpacesOptions(TxtTrailingSpacesOptions.Trim);

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