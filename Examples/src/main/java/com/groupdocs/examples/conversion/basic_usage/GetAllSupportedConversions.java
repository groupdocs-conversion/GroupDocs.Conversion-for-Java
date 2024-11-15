package com.groupdocs.examples.conversion.basic_usage;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.PossibleConversions;
import com.groupdocs.conversion.contracts.TargetConversion;
import com.groupdocs.examples.conversion.utils.FailureRegister;

import java.util.List;

public class GetAllSupportedConversions {
    public static PossibleConversions[] run() {
        final StringBuilder stringBuilder = new StringBuilder();

        try {
            final List<PossibleConversions> allPossibleConversions = Converter.getAllPossibleConversions();
            for (PossibleConversions conversions : allPossibleConversions) {
                stringBuilder.append(String.format("Source format (%s) can be converted to:%n\t", conversions.getSource().getDescription()));
                for (TargetConversion conversion : conversions.getAll()) {
                    stringBuilder.append(String.format("%s (%s)",
                            conversion.getFormat(),
                            conversion.isPrimary() ? "primary" : "secondary")).append(", ");
                }
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));

            System.out.print("\nAll possible conversions retrieved successfully.");
            return allPossibleConversions.toArray(new PossibleConversions[0]);
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
