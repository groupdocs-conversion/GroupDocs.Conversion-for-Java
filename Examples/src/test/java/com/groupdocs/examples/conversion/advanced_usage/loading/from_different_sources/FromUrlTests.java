package com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources;

import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class FromUrlTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = FromUrl.run("https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-.NET/blob/master/Examples/GroupDocs.Conversion.Examples.CSharp/Resources/SampleFiles/sample.docx?raw=true");
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}