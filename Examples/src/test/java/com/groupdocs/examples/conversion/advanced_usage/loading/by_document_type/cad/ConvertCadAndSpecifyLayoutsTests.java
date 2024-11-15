package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.cad;

import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class ConvertCadAndSpecifyLayoutsTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = ConvertCadAndSpecifyLayouts.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}