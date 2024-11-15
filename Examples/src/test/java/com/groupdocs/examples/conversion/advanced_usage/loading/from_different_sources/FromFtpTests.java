package com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources;

import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class FromFtpTests extends TestsSetUp {

    @Test
    @Ignore("Specify credentials first")
    public void testRun() {
        final Path outputPath = FromFtp.run("sample.docx", "FTP server", "FTP username", "FTP password");
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}