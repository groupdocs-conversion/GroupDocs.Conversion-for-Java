package com.groupdocs.conversion.examples.basic_usage;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.PossibleConversions;
import com.groupdocs.conversion.contracts.TargetConversion;

public class GetAllPossibleConversions {
	public static void run()
    {
		Converter converter = new Converter();

        for(PossibleConversions conversions : converter.getAllPossibleConversions())
        {
        	System.out.print(String.format("Source format: %s \n", conversions.getSource().getDescription() ));
        	for(TargetConversion conversion : conversions.getAll())
        	{
        		System.out.print(String.format("\t...can be converted to %s format as %s conversion.\n", 
        				conversion.getFormat(), 
        				conversion.isPrimary()?"primary": "secondary" ));
        	}
        }

        System.out.print("\nAll possible conversions retrieved successfully.");
    }
}
