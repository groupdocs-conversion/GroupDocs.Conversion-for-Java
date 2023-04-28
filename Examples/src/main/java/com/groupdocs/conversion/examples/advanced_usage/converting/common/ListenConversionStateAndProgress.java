package com.groupdocs.conversion.examples.advanced_usage.converting.common;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.ConverterSettings;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import com.groupdocs.conversion.reporting.IConverterListener;

/**
* This example demonstrates how to listen for conversion state and progress
*/
public class ListenConversionStateAndProgress implements IConverterListener
	{
	    public void started()
	    {
	        System.out.println("Conversion started...");
	    }
	    public void progress(byte current)
	    {
	        System.out.println("... " + current + "% ...");
	    }
	    public void completed()
	    {
	        System.out.println("... conversion completed");
	    }
	
    public static void run()
    {              
        IConverterListener listener = new ListenConversionStateAndProgress();        
        ConverterSettings settingsFactory = new ConverterSettings();
        settingsFactory.setListener(listener); 
                
        try(@SuppressWarnings("deprecation")
		Converter converter = new Converter(Constants.SAMPLE_DOCX, settingsFactory))
        {
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert("converted.pdf", options);
        } 
        

        System.out.print("\nDocument converted successfully.");
    }
}