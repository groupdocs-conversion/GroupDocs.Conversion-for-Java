package com.groupdocs.conversion.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils; 
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.ImageSaveOptions;
import com.groupdocs.conversion.converter.option.SaveOptions;
import com.groupdocs.conversion.domain.FileDescription;
import com.groupdocs.conversion.handler.output.IOutputDataHandler;
import com.groupdocs.conversion.internal.c.a.ms.System.IO.Stream;

public class AmazonOutputDataHandler implements IOutputDataHandler {
    private static String bucketName = ""; //TODO: Put you bucketname here
    private final ConversionConfig _conversionConfig;
    private final AmazonS3Client _client;
     
    public AmazonOutputDataHandler(ConversionConfig conversionConfig, String accessKey, String secretKey) {
        _conversionConfig = conversionConfig;
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        _client = new AmazonS3Client(credentials);
    }
     
    public String saveFile(FileDescription fileDescription, FileInputStream stream, SaveOptions saveOptions) {
        String fileName = "";
        try {
            //fileName = getOutputPath(fileDescription, saveOptions);
            File file = File.createTempFile("temp", "tmp");
            OutputStream outputStream = new FileOutputStream(file);
            IOUtils.copy(stream, outputStream);
            _client.putObject(new PutObjectRequest(bucketName, fileName, file));
            IOUtils.closeQuietly(outputStream, null);
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return fileName;
    }

	@Override
	public String saveFile(String arg0, InputStream arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public String saveFileInternal(String arg0, FileInputStream arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveFileInternal(String arg0, Stream arg1) {
		// TODO Auto-generated method stub
		return null;
	} 
}