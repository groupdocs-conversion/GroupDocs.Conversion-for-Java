package com.groupdocs.conversion.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.aspose.ms.System.IO.Stream;
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.ImageSaveOptions;
import com.groupdocs.conversion.converter.option.SaveOptions;
import com.groupdocs.conversion.domain.FileDescription;
import com.groupdocs.conversion.handler.output.IOutputDataHandler;

public class AmazonOutputDataHandler implements IOutputDataHandler {
    private static String bucketName = ""; //TODO: Put you bucketname here
    private final ConversionConfig _conversionConfig;
    private final AmazonS3Client _client;
     
    public AmazonOutputDataHandler(ConversionConfig conversionConfig, String accessKey, String secretKey) {
        _conversionConfig = conversionConfig;
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        _client = new AmazonS3Client(credentials);
    }
     
    @Override
    public String saveFile(FileDescription fileDescription, Stream stream, SaveOptions saveOptions) {
        String fileName = "";
        try {
            fileName = getOutputPath(fileDescription, saveOptions);
            File file = File.createTempFile("temp", "tmp");
            OutputStream outputStream = new FileOutputStream(file);
            IOUtils.copy(stream.toInputStream(), outputStream);
            _client.putObject(new PutObjectRequest(bucketName, fileName, file));
            IOUtils.closeQuietly(outputStream, null);
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return fileName;
    }
     
    private String getOutputPath(FileDescription fileDescription, SaveOptions saveOptions) {
        String filePath = "";
        String fileName = "";
        ImageSaveOptions options = null;
        try {
            options = (ImageSaveOptions) saveOptions;
        } catch(Exception ex) {
            System.out.println(ex);
        }
        if (options != null) {
            fileName = extensionNullOrEmpty(options.getCustomName())
                    ? (options.getUseWidthForCustomName()
                            ? String.format("%s_%s_%s.%s", options.getCustomName(),
                                    options.getPageNumber(),
                                    options.getWidth(),
                                    options.getConvertFileType().toString().toLowerCase())
                            : String.format("%s_%s.%s", options.getCustomName(),
                                    options.getPageNumber(),
                                    options.getConvertFileType().toString().toLowerCase()))
                    : String.format("%s_%s.%s", fileDescription.getBaseName(),
                            options.getPageNumber(),
                            options.getConvertFileType().toString().toLowerCase());
            filePath = String.format("%s\\%s", _conversionConfig.getOutputPath(), fileName);
        } else {            
            fileName = extensionNullOrEmpty(saveOptions.getCustomName())
                    ? String.format("%s.%s", saveOptions.getCustomName(),
                            saveOptions.getConvertFileType().toExtension())
                    : String.format("%s.%s", fileDescription.getBaseName(),
                            saveOptions.getConvertFileType().toExtension());
            filePath = String.format("%s\\%s", _conversionConfig.getOutputPath(), fileName);
        }
        return filePath;
    }
 
    @Override
    public String saveFileInternal(FileDescription fileDescription, Stream stream, SaveOptions saveOptions) {
        return saveFile(fileDescription, stream, saveOptions);
    }
	private boolean extensionNullOrEmpty(String customName) {
		String extension = "";
		int i = customName.lastIndexOf('.');
		if (i > 0) {
			extension = customName.substring(i + 1);
			return true;
		}
		return false;
	}
}