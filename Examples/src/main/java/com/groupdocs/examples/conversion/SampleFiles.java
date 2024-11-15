package com.groupdocs.examples.conversion;

import java.nio.file.Path;

import static com.groupdocs.examples.conversion.utils.FilesUtils.makeFilesPath;

public interface SampleFiles {
    Path SAMPLE_DOCX = makeFilesPath("sample.docx");
    Path SAMPLE_PDF = makeFilesPath("sample.pdf");
    Path SAMPLE_ZIP = makeFilesPath("sample.zip");
    Path SAMPLE_VSDX = makeFilesPath("sample.vsdx");
    Path SAMPLE_DOCX_WITH_PASSWORD = makeFilesPath("password_protected.docx");
    Path SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS = makeFilesPath("with_layers_and_layouts.dwg");
    Path SAMPLE_CSV = makeFilesPath("sample.csv");
    Path SAMPLE_MSG = makeFilesPath("sample.msg");
    Path SAMPLE_EML = makeFilesPath("sample.eml");
    Path SAMPLE_ONE = makeFilesPath("sample.one");
    Path PPTX_WITH_NOTES = makeFilesPath("with_notes.pptx");
    Path SAMPLE_PPTX_HIDDEN_PAGE = makeFilesPath("with_hidden_page.pptx");
    Path SAMPLE_XLSX = makeFilesPath("sample.xlsx");
    Path SAMPLE_XLSX_WITH_HIDDEN_SHEET = makeFilesPath("with_hidden_sheet.xlsx");
    Path SAMPLE_TXT = makeFilesPath("sample.txt");
    Path SAMPLE_TXT_SHIFT_JS_ENCODED = makeFilesPath("shift_jis_encoded.txt");
    Path SAMPLE_DOCX_WITH_TRACKED_CHANGES = makeFilesPath("with_tracked_changes.docx");
    Path SAMPLE_XML_DATASOURCE = makeFilesPath("sample_datasource.xml");
}
