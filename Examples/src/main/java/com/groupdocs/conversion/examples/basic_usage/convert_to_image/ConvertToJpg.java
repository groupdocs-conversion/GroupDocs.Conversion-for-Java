package com.groupdocs.conversion.examples.basic_usage.convert_to_image;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.ImageFileType;
import com.groupdocs.conversion.options.convert.ImageConvertOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
* This example demonstrates how to convert document to JPG.
*/
public class ConvertToJpg {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFileTemplate = new File(outputFolder, "converted-page-%s.jpg").getPath(); // TODO - Check file name format logic

        try(FileOutputStream getPageStream = new FileOutputStream(String.format(outputFileTemplate, 1))) {

            Converter converter = new Converter(Constants.SAMPLE_PDF);

            ImageConvertOptions options = new ImageConvertOptions();
            options.setFormat(ImageFileType.Jpg);
            options.setPagesCount(1);

            converter.convert(getPageStream, options);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        System.out.print("\nConversion to jpg completed successfully. \nCheck output in " + outputFolder);
    }
}