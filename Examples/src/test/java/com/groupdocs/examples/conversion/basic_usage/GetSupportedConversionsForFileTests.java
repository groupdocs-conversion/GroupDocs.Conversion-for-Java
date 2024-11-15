package com.groupdocs.examples.conversion.basic_usage;

import com.groupdocs.conversion.contracts.PossibleConversions;
import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class GetSupportedConversionsForFileTests extends TestsSetUp {

    @Test
    public void testRun() {
        final PossibleConversions possibleConversions = GetSupportedConversionsForFile.run(SampleFiles.SAMPLE_DOCX);
        Assertions.assertThat(possibleConversions).isNotNull();
    }
}