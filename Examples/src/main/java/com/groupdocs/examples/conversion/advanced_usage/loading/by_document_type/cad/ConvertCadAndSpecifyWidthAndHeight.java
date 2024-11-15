package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.cad;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;
import com.groupdocs.conversion.options.load.CadLoadOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;


/**
 * This example demonstrates how to convert a cad document to pdf with advanced options
 */
public class ConvertCadAndSpecifyWidthAndHeight {
    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ConvertCadAndSpecifyWidthAndHeight.tiff");

        final int width = 1920;
        final int height = 1080;

        try (Converter converter = new Converter(inputFile.toString(), () -> {
            CadLoadOptions loadOptions = new CadLoadOptions();
            loadOptions.setWidth(width);
            loadOptions.setHeight(height);
            return loadOptions;
        })) {
            ImageConvertOptions options = new ImageConvertOptions();
            options.setFormat_ConvertOptions_New(ImageFileType.Tiff);

            converter.convert(outputPath.toString(), options);

            System.out.println("\nCad document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}