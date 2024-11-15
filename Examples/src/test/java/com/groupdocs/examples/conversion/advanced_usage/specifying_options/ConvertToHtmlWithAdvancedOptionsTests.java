package com.groupdocs.examples.conversion.advanced_usage.specifying_options;

import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class ConvertToHtmlWithAdvancedOptionsTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = ConvertToHtmlWithAdvancedOptions.run(SampleFiles.SAMPLE_DOCX_WITH_PASSWORD);
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}