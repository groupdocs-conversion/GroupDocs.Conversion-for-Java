package com.groupdocs.conversion.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.exceptions.GroupDocsConversionException;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import org.apache.commons.net.ftp.FTPClient;

import java.io.InputStream;


/**
 * This example demonstrates how to convert document downloaded from FTP.
 */
public class LoadDocumentFromFtp {
    public static void run() {
        String server = "127.0.0.1"; //ftp.example.com
        String convertedFile = Constants.getConvertedPath("LoadDocumentFromFtp.pdf");
        String dirname = "pub";
        String fileName = "sample.docx";

        try {
            Converter converter = new Converter(getFileFromFtp(server, dirname, fileName));
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert(convertedFile, options);
        } catch (Exception e) {
            throw new GroupDocsConversionException(e.getMessage());
        }

        System.out.println("\nSource document converted successfully.\nCheck output in " + convertedFile);

    }

    private static InputStream getFileFromFtp(String server, String dirname, String fileName) throws Exception {
        FTPClient client = new FTPClient();
        client.connect(server);
        client.login("anonymous", "");
        client.changeWorkingDirectory(dirname);
        return client.retrieveFileStream(fileName);
    }
}