package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.txt;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.TxtLeadingSpacesOptions;
import com.groupdocs.conversion.options.load.TxtLoadOptions;

import java.io.File;

/**
* This example demonstrates how to convert a txt document to pdf with advanced options
*/
public class ConvertTxtByControllingLeadingSpacesBehavior {
    public static void run()
    {
        String convertedFile = Constants.getConvertedPath("ConvertTxtByControlingLeadingSpacesBehavior.pdf");  
        TxtLoadOptions loadOptions =  new TxtLoadOptions();
        loadOptions.setLeadingSpacesOptions(TxtLeadingSpacesOptions.ConvertToIndent);
        loadOptions.setDetectNumberingWithWhitespaces(true);
        Converter converter = new Converter(Constants.SAMPLE_TXT, () -> loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(convertedFile, options);

        System.out.print("\nTxt document converted successfully. \nCheck output in "+ convertedFile);
    }
}