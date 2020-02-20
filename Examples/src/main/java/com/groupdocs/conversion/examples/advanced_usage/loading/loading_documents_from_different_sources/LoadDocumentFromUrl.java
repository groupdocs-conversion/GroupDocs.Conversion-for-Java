package com.groupdocs.conversion.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.exceptions.GroupDocsConversionException;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

import java.io.File;
import java.io.InputStream;
import java.net.URL;


/**
* This example demonstrates how to download and convert document.
*/
public class LoadDocumentFromUrl {
    public static void run()
    {
        //String url = "https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-.NET/tree/master/Examples/GroupDocs.Conversion.Examples.CSharp/Resources/SampleFiles/sample.docx?raw=true";
        String url = "https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-.NET/blob/master/Examples/GroupDocs.Conversion.Examples.CSharp/Resources/SampleFiles/sample.docx?raw=true";
            
        String outputDirectory = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputDirectory, "converted.pdf").getPath();

        try {
            InputStream stream = new URL(url).openStream();
            Converter converter = new Converter(stream);
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert(outputFile, options);

        }catch(Exception e){
            throw new GroupDocsConversionException(e.getMessage());
        }
        System.out.println("\nSource document converted successfully.\nCheck output in "+outputDirectory);
    }
}