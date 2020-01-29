package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.cad;

import com.groupdocs.conversion.examples.Constants;

import java.io.File;


/**
* This example demonstrates how to convert a cad document to pdf with advanced options
*/
public class ConvertCadAndSpecifyLayouts {
    public static void run()
    {
        String outputFolder = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputFolder, "converted.pdf").getPath();


        Contracts.Func<LoadOptions> getLoadOptions = () => new CadLoadOptions
        {
            LayoutNames = new []{ "Layout1", "Layout3" }

        };

        Converter converter = new Converter(Constants.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS, getLoadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);



        System.out.print("\nCad document converted successfully. \nCheck output in "+ outputFolder);
    }
}