package com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.nio.file.Path;


/**
 * This example demonstrates how to convert document downloaded from FTP.
 */
public class FromFtp {
    public static Path run(String fileName, String server, String userName, String password) {
        final Path outputPath = FilesUtils.makeOutputPath("FromFtp.pdf");

        try (Converter converter = new Converter(() -> {
            try {
                FTPClient ftpClient = new FTPClient();
                ftpClient.connect(server);
                ftpClient.enterLocalPassiveMode();
                ftpClient.login(userName, password);
                return ftpClient.retrieveFileStream(fileName);
            } catch (IOException e) {
                throw new RuntimeException("Failed to download file from FTP", e);
            }
        })) {
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert(outputPath.toString(), options);

            System.out.println("\nSource document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}