package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.cad;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.CadLoadOptions;

import java.io.File;


/**
* This example demonstrates how to convert a cad document to pdf with advanced options
*/
public class ConvertCadAndSpecifyWidthAndHeight {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();

        CadLoadOptions loadOptions =  new CadLoadOptions();
        loadOptions.setWidth(1920);
        loadOptions.setHeight(1080);

        Converter converter = new Converter(Constants.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS, loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);

        System.out.print("\nCad document converted successfully. \nCheck output in " + outputFolder);
    }
}