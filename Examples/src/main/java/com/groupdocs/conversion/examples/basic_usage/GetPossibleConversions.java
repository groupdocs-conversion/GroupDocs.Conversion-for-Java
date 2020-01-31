package com.groupdocs.conversion.examples.basic_usage;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.PossibleConversions;
import com.groupdocs.conversion.examples.Constants;


/**
* This example demonstrates how to get to what formats the source document could be converted
*/
public class GetPossibleConversions {
    public static void run()
    {
        Converter converter = new Converter(Constants.SAMPLE_DOCX);

        PossibleConversions conversions = converter.getPossibleConversions();

        System.out.print(Constants.SAMPLE_DOCX +" is of type "+conversions.getSource().getExtension()+" and could be converted to:" );

        for(Iterable conversion : conversions.getAll())
        {
            System.out.print("\t {0} as {1} conversion.", conversion.getKey(), conversion.getValue() ? "primary" : "secondary");
        }
        System.out.print("\nPossible conversions retrieved successfully.");
    }
}