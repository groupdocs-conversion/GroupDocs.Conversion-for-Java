package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.word_processing;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.WordProcessingLoadOptions;

import java.io.File;

/**
* This example demonstrates how to convert a word-processing document to pdf with advanced options
*/
public class ConvertWordProcessingByHiddingComments {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();

        WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
        loadOptions.setHideComments(true);

        Converter converter = new Converter(Constants.SAMPLE_DOCX_WITH_TRACKED_CHANGES, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);

        System.out.print("\nWordProcessing document converted successfully. \nCheck output in " + outputFolder);
    }
}