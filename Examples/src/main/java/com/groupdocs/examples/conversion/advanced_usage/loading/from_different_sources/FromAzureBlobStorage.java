package com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.FilesUtils;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.security.InvalidKeyException;


/**
 * This example demonstrates how to download document from Azure Blob storage and convert document.
 */
public class FromAzureBlobStorage {
    public static final String STORAGE_CONNECTION_STRING
            = "DefaultEndpointsProtocol=https;"
            + "AccountName=%s;"
            + "AccountKey=%s";

    public static Path run(String blobName, String accountName, String accountKey, String containerName) {
        final Path outputPath = FilesUtils.makeOutputPath("FromAzureBlobStorage.pdf");

        try (Converter converter = new Converter(() -> {
            try {
                // Initialize Azure Blob Storage and download the file
                final byte[] byteArray = downloadFile(blobName, accountName, accountKey, containerName);
                return new ByteArrayInputStream(byteArray);
            } catch (Exception e) {
                throw new RuntimeException("Failed to download file from Azure Blob storage", e);
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

    private static byte[] downloadFile(String blobName, String accountName, String accountKey, String containerName) throws URISyntaxException, InvalidKeyException, StorageException {
        CloudBlobContainer container = getContainer(accountName, accountKey, containerName);

        CloudBlob blob = container.getBlockBlobReference(blobName);
        ByteArrayOutputStream memoryStream = new ByteArrayOutputStream();
        blob.download(memoryStream);
        return memoryStream.toByteArray();
    }

    private static CloudBlobContainer getContainer(String accountName, String accountKey, String containerName) throws URISyntaxException, InvalidKeyException, StorageException {
        CloudStorageAccount cloudStorageAccount = CloudStorageAccount.parse(String.format(STORAGE_CONNECTION_STRING, accountName, accountKey));
        CloudBlobClient cloudBlobClient = cloudStorageAccount.createCloudBlobClient();
        CloudBlobContainer container = cloudBlobClient.getContainerReference(containerName);
        container.createIfNotExists();

        return container;
    }
}