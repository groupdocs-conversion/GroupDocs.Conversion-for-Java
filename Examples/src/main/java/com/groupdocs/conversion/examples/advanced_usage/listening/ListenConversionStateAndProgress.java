package com.groupdocs.conversion.examples.advanced_usage.listening;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;

/**
* This example demonstrates how to listen for conversion state and progress.
*/
public class ListenConversionStateAndProgress {
    private class ConverterListener implements IConverterListener
        {
            public void Started()
            {
                System.out.print("Conversion started...");
            }

        public void Progress(byte current)
        {
            System.out.print("... {current} % ...");
        }

        public void Completed()
        {
            System.out.print("... conversion completed");
        }
    }

    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();

        Contracts.Func<ConverterSettings> settingsFactory = () => new ConverterSettings
        {
            Listener = new ConverterListener()
        };

        Contracts.Func<LoadOptions> getLoadOptions = () => new WordProcessingLoadOptions
        {
            Password = "12345"
        };

        Converter converter = new Converter(Constants.SAMPLE_DOCX_WITH_PASSWORD, getLoadOptions, settingsFactory);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nPassword protected document converted successfully. \nCheck output in " + outputFolder);
    }

}