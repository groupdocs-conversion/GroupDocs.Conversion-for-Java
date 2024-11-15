package com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;

import java.io.InputStream;
import java.nio.file.Path;

/**
 * This example demonstrates how to download document from Amazon S3 storage and convert document.
 */
public class FromAmazonS3 {

    public static Path run(String s3Key, String accessKey, String secretKey, String bucketName) {
        final Path outputPath = FilesUtils.makeOutputPath("FromAmazonS3.pdf");

        try (Converter converter = new Converter(() -> downloadFile(s3Key, accessKey, secretKey, bucketName))) {
            PdfConvertOptions options = new PdfConvertOptions();

            converter.convert(outputPath.toString(), options);

            System.out.println("\nSource document converted successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    private static InputStream downloadFile(String s3Key, String accessKey, String secretKey, String bucketName) {
        AWSCredentials credentials = new BasicAWSCredentials(
                accessKey,
                secretKey
        );
        AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();

        S3Object s3object = s3client.getObject(bucketName, s3Key);
        return s3object.getObjectContent();
    }
}