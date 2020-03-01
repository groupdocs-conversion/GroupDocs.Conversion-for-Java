package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.pdf;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.WordProcessingConvertOptions;
import com.groupdocs.conversion.options.load.PdfLoadOptions;

import java.io.File;

/** <summary>
* This example demonstrates how to convert a pdf document to wordprocessing with advanced options
*/
public class ConvertPdfAndRemoveEmbeddedFiles {
    public static void run()
    {
        String convertedFile = Constants.getConvertedPath("ConvertPdfAndRemoveEmbeddedFiles.docx");           
        PdfLoadOptions loadOptions = new PdfLoadOptions();
        loadOptions.setRemoveEmbeddedFiles(true);
        Converter converter = new Converter(Constants.SAMPLE_PDF, loadOptions);
        WordProcessingConvertOptions options = new WordProcessingConvertOptions();
        converter.convert(convertedFile, options);

        System.out.println("\nPdf document converted successfully. \nCheck output in " + convertedFile);
    }
}