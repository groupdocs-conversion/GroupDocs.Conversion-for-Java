package com.groupdocs.examples.conversion.advanced_usage.common;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.ConverterSettings;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.reporting.IConverterListener;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

/**
 * This example demonstrates how to listen for conversion state and progress
 */
public class ListenConversionStateAndProgress implements IConverterListener {

    public static Path run(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("ListenConversionStateAndProgress.pdf");
        IConverterListener listener = new ListenConversionStateAndProgress();

        ConverterSettings settingsFactory = new ConverterSettings();
        settingsFactory.setListener(listener);

        try (Converter converter = new Converter(inputFile.toString(), settingsFactory)) {
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert(outputPath.toString(), options);

            System.out.println("\nDocument converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    @Override
    public void started() {
        System.out.println("Conversion started...");
    }

    @Override
    public void progress(byte current) {
        System.out.println("... " + current + "% ...");
    }

    @Override
    public void completed() {
        System.out.println("... conversion completed");
    }
}