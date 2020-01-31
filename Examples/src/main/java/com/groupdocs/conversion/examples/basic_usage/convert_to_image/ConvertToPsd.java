package com.groupdocs.conversion.examples.basic_usage.convert_to_image;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.SavePageStream;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;

import java.io.File;


/**
* This example demonstrates how to convert document to PSD.
*/
public class ConvertToPsd {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFileTemplate = new File(outputFolder, "converted-page-{0}.psd").getPath();

        SavePageStream getPageStream = page => new FileStream(string.Format(outputFileTemplate, page), FileMode.Create);

        Converter converter = new Converter(Constants.SAMPLE_PDF);
        ImageConvertOptions options = new ImageConvertOptions();
        options.setFormat(ImageFileType.Psd);
        converter.convert(getPageStream, options);


        System.out.print("\nConversion to psd completed successfully. \nCheck output in " + outputFolder);
    }
}