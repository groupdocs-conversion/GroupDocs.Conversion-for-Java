package com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.email;


import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.SaveDocumentStreamForFileType;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.options.load.EmailLoadOptions;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This example demonstrates how to convert an email document to pdf with advanced options
 */
public class ConvertEmailWithTimezoneOffset {
    public static void run() throws IOException {
        List<OutputStream> streamPool = new ArrayList<>();
        String convertedFile = Constants.getConvertedPath("ConvertEmailWithTimezoneOffset-%d.pdf");
        EmailLoadOptions loadOptions = new EmailLoadOptions();
        loadOptions.setTimeZoneOffset(7200000.0);
        Converter converter = new Converter(Constants.SAMPLE_EML, () -> loadOptions);
        PdfConvertOptions options = new PdfConvertOptions();
        try {
            converter.convert((SaveDocumentStreamForFileType) t -> {
                OutputStream outputStream;
                try {
                    outputStream = Files.newOutputStream(Paths.get(String.format(convertedFile, streamPool.size())));
                    streamPool.add(outputStream);
                    return outputStream;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }, options);
        } finally {
            for (OutputStream outputStream: streamPool) {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }

        System.out.print("\nEmail document converted successfully. \nCheck output in " + convertedFile);
    }
}