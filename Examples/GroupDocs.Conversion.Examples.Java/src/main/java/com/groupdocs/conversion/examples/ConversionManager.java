package com.groupdocs.conversion.examples;

import java.io.IOException;

import com.groupdocs.conversion.converter.option.HtmlSaveOptions;
import com.groupdocs.conversion.converter.option.OutputType;
import com.groupdocs.conversion.converter.option.PdfSaveOptions;
import com.groupdocs.conversion.converter.option.SaveOptions;
import com.groupdocs.conversion.handler.ConversionEventArgs;
import com.groupdocs.conversion.handler.ConversionHandler;
import com.groupdocs.conversion.handler.ConversionProgressEventArgs;
import com.groupdocs.conversion.handler.IConversionProgressListener;
import com.groupdocs.conversion.handler.IConversionStatusListener;

public class ConversionManager implements IConversionProgressListener, IConversionStatusListener {
	private ConversionHandler _conversionHandler = null;

	@Override
	public void conversionProgressChanged(ConversionProgressEventArgs args) {
		System.out.println("Conversion progress: " + args.getProgress() + " %");
	}

	public ConversionManager(String path) {
		_conversionHandler = new ConversionHandler(Utilities.getConfiguration());
		_conversionHandler.setConversionProgressListener(this);
		_conversionHandler.setConversionStatusListener(this);
	}

	@Override
	public void conversionStatusChanged(ConversionEventArgs args) {
		System.out.println("Conversion status changed to: " + args.getStatus());
	}

	public String convert(String file) throws IOException {
		PdfSaveOptions option = new PdfSaveOptions();
		option.setOutputType(OutputType.String);

		return _conversionHandler.<String> convert(file, option);
	}
}