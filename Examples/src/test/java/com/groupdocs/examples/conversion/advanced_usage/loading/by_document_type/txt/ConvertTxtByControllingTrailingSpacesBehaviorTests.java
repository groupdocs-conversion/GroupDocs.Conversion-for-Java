package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.txt;

import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class ConvertTxtByControllingTrailingSpacesBehaviorTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = ConvertTxtByControllingTrailingSpacesBehavior.run(SampleFiles.SAMPLE_TXT);
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}