package com.groupdocs.conversion.examples.basic_usage.convert_to_html;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.MarkupConvertOptions;

import java.io.File;

/**
* This example demonstrates how to convert document to HTML.
*/
public class ConvertToHtml {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath("");
        String outputFile = new File(outputFolder, "converted.html").getPath();

        Converter converter = new Converter(Constants.SAMPLE_DOCX);

        MarkupConvertOptions options = new MarkupConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nConversion to html completed successfully. \nCheck output in " + outputFolder);
    }
}