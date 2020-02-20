package com.groupdocs.conversion.examples.basic_usage.convert_to_presentation;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PresentationConvertOptions;

import java.io.File;


/**
* This example demonstrates how to convert document to Presentation.
*/
public class ConvertToPresentation {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pptx").getPath();

        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        PresentationConvertOptions options = new PresentationConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nConversion to presentation completed successfully. \nCheck output in " + outputFolder);
    }
}