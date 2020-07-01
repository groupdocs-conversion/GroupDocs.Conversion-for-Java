package com.groupdocs.conversion.examples.basic_usage.convert_to_pdf;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

/**
* This example demonstrates how to convert document to PDF.
*/
public class ConvertToPdf {
    public static void run()
    {        
        String convertedFile =  Constants.getConvertedPath("ConvertToPdf.pdf");
        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nConversion to pdf completed successfully. \nCheck output in " + convertedFile);
    }
}