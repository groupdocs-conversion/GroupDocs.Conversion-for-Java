package com.groupdocs.conversion.examples;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.ImageSaveOptions;
import com.groupdocs.conversion.domain.CacheFileDescription;
import com.groupdocs.conversion.handler.cache.ICacheDataHandler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.stream.Stream;

public class AmazonCacheDataHandler implements ICacheDataHandler {

	private static String bucketName = ""; // TODO: Put you bucketname here
	private final ConversionConfig _conversionConfig;
	private final AmazonS3Client _client;

	public AmazonCacheDataHandler(ConversionConfig conversionConfig, String accessKey, String secretKey) {
		_conversionConfig = conversionConfig;
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		_client = new AmazonS3Client(credentials);
	}

	@Override
	public boolean exists(CacheFileDescription cacheFileDescription) {
		if (!_conversionConfig.getUseCache()) {
			return false;
		}
		if (cacheFileDescription == null) {
			try {
				throw new Exception("CacheFileDescription is not set");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (cacheFileDescription.getLastModified() == 0) {
			return false;
		}
		if (extensionNullOrEmpty(cacheFileDescription.getGuid())) {
			try {
				throw new Exception("CacheFileDescription is not set");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (extensionNullOrEmpty(_conversionConfig.getStoragePath())) {
			try {
				throw new Exception("Storage path is not set");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String key = null;
		try {
			key = getCachePath(_conversionConfig.getCachePath(), cacheFileDescription);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		S3Object response = _client.getObject(bucketName, key);
		return response.getObjectMetadata().getLastModified().after(Calendar.getInstance().getTime());
	}

	@Override
	public InputStream getInputStream(CacheFileDescription cacheFileDescription) {
		if (cacheFileDescription == null || extensionNullOrEmpty(cacheFileDescription.getGuid())
				|| cacheFileDescription.getLastModified() == 0) {
			try {
				throw new Exception("CacheFileDescription is not set");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String key = null;
		try {
			key = getCachePath(_conversionConfig.getCachePath(), cacheFileDescription);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		S3Object response = _client.getObject(bucketName, key);
		return response.getObjectContent();
	}

	@Override
	public OutputStream getOutputSaveStream(CacheFileDescription cacheFileDescription) {
//		try {
//			if (!_conversionConfig.getUseCache()) {
//				return new InputStream() {
//
//					@Override
//					public int read() throws IOException {
//						// TODO Auto-generated method stub
//						return 0;
//					}
//				};
//			}
//			if (cacheFileDescription == null || extensionNullOrEmpty(cacheFileDescription.getGuid())) {
//				try {
//					throw new Exception("CacheFileDescription is not set");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			String key = null;
//			try {
//				key = getCachePath(_conversionConfig.getCachePath(), cacheFileDescription);
//			} catch (Throwable e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			File file = File.createTempFile("temp", "tmp");
//
//			return new PutObjectRequest(bucketName, key, file).getInputStream();
//		} catch (IOException ex) {
//			System.out.println(ex);
//		}
		return null;
}

	@Override
	public String getCacheUri(CacheFileDescription cacheFileDescription) {
		try {
			return getCachePath(_conversionConfig.getCachePath(), cacheFileDescription);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String getCachePath(String path, CacheFileDescription cacheFileDescription) throws Throwable {
		if (cacheFileDescription.getSaveOptions() == null) {
			throw new Exception("CacheFileDescription.Options is not set");
		}
		String filePath = "";
		String fileName = "";
		ImageSaveOptions options = null;
		try {
			options = (ImageSaveOptions) cacheFileDescription.getSaveOptions();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		if (options != null) {
			if (extensionNullOrEmpty(options.getCustomName())) {
				if (options.getUseWidthForCustomName()) {
					fileName = String.format("%s_%s.%s", options.getCustomName(), options.getWidth(),
							options.getConvertFileType().toString().toLowerCase());
				} else {
					fileName = String.format("%s.%s", options.getCustomName(),
							options.getConvertFileType().toString().toLowerCase());
				}
			} else {
				fileName = String.format("%s.%s", cacheFileDescription.getBaseName(),
						options.getConvertFileType().toString().toLowerCase());
			}
			filePath = String.format("%s\\%s\\%s\\%s", path, cacheFileDescription.getGuid(), options.getPageNumber(),
					fileName);
		} else {
			fileName = extensionNullOrEmpty(cacheFileDescription.getSaveOptions().getCustomName())
					? String.format("%s.%s", cacheFileDescription.getSaveOptions().getCustomName(),
							cacheFileDescription.getSaveOptions().getConvertFileType().toExtension())
					: String.format("%s.%s", cacheFileDescription.getBaseName(),
							cacheFileDescription.getSaveOptions().getConvertFileType().toExtension());
			filePath = String.format("%s%s/%s", path, cacheFileDescription.getGuid(), fileName);
		}
		return filePath;
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

	// define your own logic here
	@Override
	public com.aspose.ms.System.IO.Stream getInputStreamInternal(CacheFileDescription arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	// define your own logic here
	@Override
	public com.aspose.ms.System.IO.Stream getOutputSaveStreamInternal(CacheFileDescription arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}