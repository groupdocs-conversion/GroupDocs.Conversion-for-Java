package com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.spreadsheet;

import com.groupdocs.examples.conversion.SampleFiles;
import com.groupdocs.examples.conversion.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class ConvertSpreadsheetWithHiddenSheetsIncludedTests extends TestsSetUp {

    @Test
    public void testRun() {
        final Path outputPath = ConvertSpreadsheetWithHiddenSheetsIncluded.run(SampleFiles.SAMPLE_XLSX_WITH_HIDDEN_SHEET);
        Assertions.assertThat(outputPath).isNotNull().exists();
    }
}