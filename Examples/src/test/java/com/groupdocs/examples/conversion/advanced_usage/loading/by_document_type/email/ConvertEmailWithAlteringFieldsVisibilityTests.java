package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.email;

import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class ConvertEmailWithAlteringFieldsVisibilityTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = ConvertEmailWithAlteringFieldsVisibility.run(SampleFiles.SAMPLE_MSG);
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}