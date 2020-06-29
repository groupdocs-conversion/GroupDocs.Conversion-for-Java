package com.groupdocs.conversion.examples.advanced_usage.caching;

//import com.aspose.ms.System.Diagnostics.Stopwatch;
import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.ConverterSettings;
import com.groupdocs.conversion.examples.Constants;
//import com.groupdocs.conversion.internal.c.a.ms.System.Diagnostics.Stopwatch;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

public class HowToUseCustomCacheImplementation {
    /**
    * This example demonstrates how to implement custom cache when rendering document.
    */
    public static void run()
    {
        String outputDirectory = Constants.getOutputDirectoryPath(null);

        RedisCache cache = new RedisCache(/*"sample_"*/);
        ConverterSettings settingsFactory = new ConverterSettings();
        settingsFactory.setCache(cache);

        Converter converter = new Converter(Constants.SAMPLE_DOCX, settingsFactory);
        PdfConvertOptions options = new PdfConvertOptions();

        //Stopwatch stopWatch = Stopwatch.startNew();
        converter.convert("converted.pdf", options);
        //stopWatch.stop();

        //System.out.print(String.format("Time taken on first call to Convert method %d (ms).", stopWatch.getElapsedMilliseconds()));

        //stopWatch.restart();
        converter.convert("converted-1.pdf", options);
        //stopWatch.stop();

        //System.out.print(String.format("Time taken on second call to Convert method %d (ms).", stopWatch.getElapsedMilliseconds()));


        System.out.print("\nSource document rendered successfully.\nCheck output in {outputDirectory}.");
    }
}

