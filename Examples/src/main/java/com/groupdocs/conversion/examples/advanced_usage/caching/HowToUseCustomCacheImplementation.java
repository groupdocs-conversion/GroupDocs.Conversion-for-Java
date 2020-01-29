package com.groupdocs.conversion.examples.advanced_usage.caching;

import com.groupdocs.conversion.examples.Constants;

public class HowToUseCustomCacheImplementation {
    /**
    * This example demonstrates how to implement custom cache when rendering document.
    */
    public static void run()
    {
        String outputDirectory = Constants.getOutputDirectoryPath(null);

        RedisCache cache = new RedisCache("sample_");
        Contracts.Func<ConverterSettings> settingsFactory = () => new ConverterSettings
        {
            Cache = cache
        };

        Converter converter = new Converter(Constants.SAMPLE_DOCX, settingsFactory);
        PdfConvertOptions options = new PdfConvertOptions();

        Stopwatch stopWatch = Stopwatch.startNew();
        converter.convert("converted.pdf", options);
        stopWatch.stop();

        System.out.print("Time taken on first call to Convert method {0} (ms).", stopWatch.getElapsedMilliseconds());

        stopWatch.restart();
        converter.convert("converted-1.pdf", options);
        stopWatch.stop();

        System.out.print("Time taken on second call to Convert method {0} (ms).", stopWatch.getElapsedMilliseconds());


        System.out.print("\nSource document rendered successfully.\nCheck output in {outputDirectory}.");
    }
}

