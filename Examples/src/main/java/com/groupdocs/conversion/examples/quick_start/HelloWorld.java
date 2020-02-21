package com.groupdocs.conversion.examples.quick_start;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.FileType;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
* This example demonstrates how to convert document to PDF.
*/
public class HelloWorld {
    public static void run()
    {
        String convertedFile =  Constants.getConvertedPath("HelloWorld.pdf");

        Converter converter = new Converter(Constants.SAMPLE_DOCX);

        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);


        System.out.print("\nSource document converted successfully.\nCheck output in "+ convertedFile);
    }
}