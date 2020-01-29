package com.groupdocs.conversion.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.conversion.examples.Constants;
import org.apache.commons.net.ftp.FTPClient;
import java.io.File;
import java.io.InputStream;


/**
* This example demonstrates how to convert document downloaded from FTP.
*/
public class LoadDocumentFromFtp {
    public static void run()
    {

        String server = "ftp.example.com";

        String outputDirectory = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputDirectory, "converted.pdf").getPath();
        String filePath = "ftp://localhost/sample.doc";
        try {
            Converter converter = new Converter(getFileFromFtp(server, filePath));
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputFile, options);
        } catch (Exception e){
            throw new GroupDocsException(e.getMessage());
        }

        System.out.println("\nSource document converted successfully.\nCheck output in " +outputDirectory);

    }

    private static InputStream getFileFromFtp(String server, String filePath) throws Exception
    {
        FTPClient client = new FTPClient();
        client.connect(server);
        return client.retrieveFileStream(filePath);
    }
}