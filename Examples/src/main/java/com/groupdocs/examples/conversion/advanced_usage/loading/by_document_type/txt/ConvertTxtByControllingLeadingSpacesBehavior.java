package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.txt;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.TxtLeadingSpacesOptions;
import com.groupdocs.conversion.options.load.TxtLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;

import java.nio.file.Path;

import static com.groupdocs.examples.conversion.utils.FilesUtils.makeOutputPath;

/**
 * This example demonstrates how to convert a txt document to pdf with advanced options
 */
public class ConvertTxtByControllingLeadingSpacesBehavior {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("ConvertTxtByControllingLeadingSpacesBehavior.pdf");

        TxtLoadOptions loadOptions = new TxtLoadOptions();
        loadOptions.setLeadingSpacesOptions(TxtLeadingSpacesOptions.ConvertToIndent);
        loadOptions.setDetectNumberingWithWhitespaces(true);

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