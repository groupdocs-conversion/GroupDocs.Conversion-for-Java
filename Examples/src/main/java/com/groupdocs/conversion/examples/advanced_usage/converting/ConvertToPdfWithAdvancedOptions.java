package com.groupdocs.conversion.examples.advanced_usage.converting;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;


/**
* This example demonstrates how to convert password-protected document to PDF and specifying pages to be converted
*/
public class ConvertToPdfWithAdvancedOptions {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();


        Contracts.Func<LoadOptions> getLoadOptions = () => new WordProcessingLoadOptions
        {
            Password = "12345"
        };

        Converter converter = new Converter(Constants.SAMPLE_DOCX_WITH_PASSWORD, getLoadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        options.setPageNumber(2);
        options.setPagesCount(1);
        options.setRotate(Rotation.On180);
        options.setDpi(300);
        options.setWidth(1024);
        options.setHeight(768);

        converter.convert(outputFile, options);

        System.out.print("\nPassword protected document converted successfully. \nCheck output in " + outputFolder);
    }
}