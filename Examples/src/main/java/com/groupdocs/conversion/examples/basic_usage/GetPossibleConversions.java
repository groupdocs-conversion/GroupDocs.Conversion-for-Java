package com.groupdocs.conversion.examples.basic_usage;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.Pair;
import com.groupdocs.conversion.contracts.PossibleConversions;
import com.groupdocs.conversion.contracts.TargetConversion;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.filetypes.FileType;


/**
 * This example demonstrates how to get to what formats the source document could be converted
 */
public class GetPossibleConversions {
    public static void run()
    {
        Converter converter = new Converter(Constants.SAMPLE_DOCX);
        PossibleConversions conversions = converter.getPossibleConversions();

        System.out.print(String.format("%s is of type %s and could be converted to:\n",
            Constants.SAMPLE_DOCX, conversions.getSource().getExtension()));

        for(TargetConversion conversion : conversions.getAll())
        {
            System.out.print(String.format("\t %s as %s conversion.\n", conversion.getFormat().getExtension(), conversion.isPrimary() ? "primary" : "secondary"));
        }

        System.out.print("\nPossible conversions retrieved successfully.");
    }
}