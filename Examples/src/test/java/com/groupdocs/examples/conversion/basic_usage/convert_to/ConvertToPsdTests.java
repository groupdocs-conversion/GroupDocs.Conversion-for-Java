package com.groupdocs.examples.conversion.basic_usage.convert_to;

import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class ConvertToPsdTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = ConvertToPsd.run(SampleFiles.SAMPLE_VSDX);
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}