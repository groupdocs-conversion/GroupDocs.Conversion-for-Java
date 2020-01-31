package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.txt;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.TxtLoadOptions;
import com.groupdocs.conversion.options.load.TxtTrailingSpacesOptions;

import java.io.File;
import java.nio.charset.Charset;

/**
* This example demonstrates how to convert a txt document to pdf with advanced options
*/
public class ConvertTxtBySpecifyingEncoding {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();

        TxtLoadOptions loadOptions =  new TxtLoadOptions();
        loadOptions.setEncoding(Charset.forName("shift_jis"));

        Converter converter = new Converter(Constants.SAMPLE_TXT_SHIFT_JS_ENCODED, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nTxt document converted successfully. \nCheck output in " + outputFolder);
    }
}