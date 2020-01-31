package com.groupdocs.conversion.examples.advanced_usage.caching;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;
/**
* This example demonstrates how to enable cache when convert document.
*/
public class UseCacheWhenProcessingDocuments {
    public static void run()
    {
        String outputDirectory = Constants.getOutputDirectoryPath(null);
        String cachePath = new File(outputDirectory, "cache").getPath();

        FileCache cache = new FileCache(cachePath);

        ConverterSettings settingsFactory =  new ConverterSettings();
        settingsFactory.setCache(cache);

        Converter converter = new Converter(Constants.SAMPLE_DOCX, settingsFactory);
        PdfConvertOptions options = new PdfConvertOptions();

        Stopwatch stopWatch = Stopwatch.startNew();
        converter.convert("converted.pdf", options);
        stopWatch.stop();

        System.out.print("Time taken on first call to Convert method {0} (ms).", stopWatch.ElapsedMilliseconds);

        stopWatch.restart();
        converter.convert("converted-1.pdf", options);
        stopWatch.stop();

        System.out.print("Time taken on second call to Convert method {0} (ms).", stopWatch.ElapsedMilliseconds);


        System.out.print("\nSource document converted successfully.\nCheck output in {outputDirectory}.");
    }
}