package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.word_processing;

import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class ConvertWordProcessingByHidingCommentsTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = ConvertWordProcessingByHidingComments.run(SampleFiles.SAMPLE_DOCX_WITH_TRACKED_CHANGES);
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}