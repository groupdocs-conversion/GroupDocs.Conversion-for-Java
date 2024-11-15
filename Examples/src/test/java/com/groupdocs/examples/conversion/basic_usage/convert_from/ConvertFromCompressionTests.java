package com.groupdocs.examples.conversion.basic_usage.convert_from;

import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class ConvertFromCompressionTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = ConvertFromCompression.run(SampleFiles.SAMPLE_ZIP);
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}