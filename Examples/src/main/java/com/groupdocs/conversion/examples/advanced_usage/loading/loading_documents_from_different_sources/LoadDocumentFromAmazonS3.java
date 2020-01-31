package com.groupdocs.conversion.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;

import java.io.File;
import java.io.InputStream;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

/**
* This example demonstrates how to download document from Amazon S3 storage and convert document.
*/
public class LoadDocumentFromAmazonS3 {

    public static void run()
    {
        String key = "sample.docx";
        String outputDirectory = Constants.getOutputDirectoryPath(null);
        String outputFile = new File(outputDirectory, "converted.pdf").getPath();

        Converter converter = new Converter(downloadFile(key));

        PdfConvertOptions options = new PdfConvertOptions();
        converter.convert(outputFile, options);


        System.out.print("\nSource document converted successfully.\nCheck output in " +outputDirectory);
    }

    public static InputStream downloadFile(String key)
    {
        AWSCredentials credentials = new BasicAWSCredentials(
                "<AWS accesskey>",
                "<AWS secretkey>"
        );
        AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();
        String bucketName = "my-bucket";

        S3Object s3object = s3client.getObject(bucketName, key);
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        return inputStream;
    }
}