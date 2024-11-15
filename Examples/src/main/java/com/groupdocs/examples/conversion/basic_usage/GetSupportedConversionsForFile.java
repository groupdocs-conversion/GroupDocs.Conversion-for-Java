package com.groupdocs.examples.conversion.basic_usage;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.contracts.PossibleConversions;
import com.groupdocs.conversion.contracts.TargetConversion;
import com.groupdocs.examples.conversion.utils.FailureRegister;

import java.nio.file.Path;

public class GetSupportedConversionsForFile {
    public static PossibleConversions run(Path inputFile) {
        try (Converter converter = new Converter(inputFile.toString())) {
            PossibleConversions conversions = converter.getPossibleConversions();

            System.out.printf("'%s' is of type '%s' and could be converted to:\n", inputFile.getFileName(), conversions.getSource().getExtension());

            for (TargetConversion conversion : conversions.getAll()) {
                System.out.printf("\t%s as %s conversion.\n", conversion.getFormat().getExtension(), conversion.isPrimary() ? "primary" : "secondary");
            }

            System.out.print("\nPossible conversions retrieved successfully.");
            return conversions;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }
}
