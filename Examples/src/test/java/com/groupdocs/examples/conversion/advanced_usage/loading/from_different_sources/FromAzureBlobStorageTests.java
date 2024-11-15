package com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources;

import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class FromAzureBlobStorageTests extends TestsSetUp {

    @Test
    @Ignore("Specify credentials first")
    public void testRun() {
        final Path outputPath = FromAzureBlobStorage.run("sample.docx", "Azure accountName", "Azure accountKey", "Azure containerName");
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}