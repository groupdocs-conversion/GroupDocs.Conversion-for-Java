package com.groupdocs.examples.conversion.advanced_usage.caching;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.ConverterSettings;
import com.groupdocs.conversion.caching.ICache;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.advanced_usage.caching.impl.HashMapCache;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.nio.file.Path;

public class CustomCacheImplementation {
    /**
     * This example demonstrates how to implement custom cache when rendering document.
     */
    public static long run(Path inputFile) {
        final Path outputPath1 = FilesUtils.makeOutputPath("CustomCacheImplementation-1.pdf");
        final Path outputPath2 = FilesUtils.makeOutputPath("CustomCacheImplementation-2.pdf");

        ICache cache = new HashMapCache(); // FileCache

        ConverterSettings settingsFactory = new ConverterSettings();
        settingsFactory.setCache(cache);

        long diffTime = 0;
        try (Converter converter = new Converter(inputFile.toString(), () -> settingsFactory)) {
            PdfConvertOptions options = new PdfConvertOptions();

            final long before1 = System.currentTimeMillis();
            converter.convert(outputPath1.toString(), options);
            final long after1 = System.currentTimeMillis();

            System.out.printf("\tTime taken on first conversion: %d (ms).\n", after1 - before1);

            final long before2 = System.currentTimeMillis();
            converter.convert(outputPath2.toString(), options);
            final long after2 = System.currentTimeMillis();

            System.out.printf("\tTime taken on second conversion: %d (ms).\n", after2 - before2);

            diffTime = (after2 - before2) - (after1 - before1);

            System.out.println("\nSource document rendered successfully.\nCheck output in " + outputPath1.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return diffTime;
    }
}

