package com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources;

import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class FromLocalDiskTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = FromLocalDisk.run(SampleFiles.SAMPLE_DOCX);
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}