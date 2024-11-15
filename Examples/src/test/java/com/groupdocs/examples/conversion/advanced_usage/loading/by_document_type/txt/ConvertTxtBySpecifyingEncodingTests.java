package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.txt;

import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class ConvertTxtBySpecifyingEncodingTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = ConvertTxtBySpecifyingEncoding.run(SampleFiles.SAMPLE_TXT_SHIFT_JS_ENCODED);
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}