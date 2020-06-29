package com.groupdocs.conversion.examples.basic_usage.convert_to_image;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.SavePageStream;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
* This example demonstrates how to convert document to PNG.
*/
public class ConvertToPng {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFileTemplate = new File(outputFolder, "converted-page-%d.png").getPath();

        try(FileOutputStream getPageStream = new FileOutputStream(String.format(outputFileTemplate, 1))) {

            Converter converter = new Converter(Constants.SAMPLE_PDF);
            ImageConvertOptions options = new ImageConvertOptions();
            options.setFormat(ImageFileType.Png);
            options.setPagesCount(1);
            converter.convert(getPageStream, options);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        System.out.print("\nConversion to png completed successfully. \nCheck output in " + outputFolder);
    }
}