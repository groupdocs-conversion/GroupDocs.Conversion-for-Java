package com.groupdocs.conversion.examples;

import java.io.File;


public class Constants {

    public static String LicensePath = (System.getProperty("user.dir") + "\\Resources\\GroupDocs.Conversion.lic");
    public static String SamplesPath = (System.getProperty("user.dir") +"\\Resources\\SampleFiles\\");
    public static String FontsPath = (System.getProperty("user.dir") +"\\Resources\\Fonts\\");
    public static String OutputPath = (System.getProperty("user.dir") +"\\Resources\\Output\\");

    // CAD
    public static String SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS =
    getSampleFilePath("with_layers_and_layouts.dwg");

    // Diagrams
    public static String SAMPLE_VSDX =
    getSampleFilePath("sample.vsdx");

    // Email messages
    public static String SAMPLE_MSG =
    getSampleFilePath("sample.msg");
    public static String SAMPLE_MSG_WITH_ATTACHMENTS =
    getSampleFilePath("with_attachments.msg");
    public static String SAMPLE_OST =
    getSampleFilePath("sample.ost");
    public static String SAMPLE_OST_SUBFOLDERS =
    getSampleFilePath("with_subfolders.ost");

    // Note
    public static String SAMPLE_ONE =
    getSampleFilePath("sample.one");

    // PDFs
    public static String SAMPLE_PDF =
    getSampleFilePath("sample.pdf");
    public static String SAMPLE_PDF_WITH_PASSWORD =
    getSampleFilePath("sample_with_password.pdf");
    public static String HIEROGLYPHS_PDF =
    getSampleFilePath("hieroglyphs.pdf");
    public static String HIEROGLYPHS_1_PDF =
    getSampleFilePath("hieroglyphs_1.pdf");

    // Presentations
    public static String PPTX_WITH_NOTES =
    getSampleFilePath("with_notes.pptx");
    public static String SAMPLE_PPTX_HIDDEN_PAGE =
    getSampleFilePath("with_hidden_page.pptx");
    public static String MISSING_FONT_PPTX =
    getSampleFilePath("with_missing_font.pptx");
    public static String JPG_IMAGE_PPTX =
    getSampleFilePath("with_jpg_image.pptx");

    // Project Management documents
    public static String SAMPLE_MPP =
    getSampleFilePath("sample.mpp");

    // Spreadsheets
    public static String SAMPLE_XLSX =
    getSampleFilePath("sample.xlsx");
    public static String SAMPLE_XLSX_WITH_PRINT_AREAS =
    getSampleFilePath("with_four_print_areas.xlsx");
    public static String SAMPLE_XLSX_WITH_EMPTY_COLUMN =
    getSampleFilePath("with_empty_column.xlsx");
    public static String SAMPLE_XLSX_WITH_EMPTY_ROW =
    getSampleFilePath("with_empty_row.xlsx");
    public static String SAMPLE_XLSX_WITH_HIDDEN_ROW_AND_COLUMN =
    getSampleFilePath("with_hidden_row_and_column.xlsx");
    public static String SAMPLE_XLSX_WITH_TEXT_OVERFLOW =
    getSampleFilePath("with_overflowing_text.xlsx");
    public static String SAMPLE_XLSX_WITH_HIDDEN_SHEET =
    getSampleFilePath("with_hidden_sheet.xlsx");
    public static String SAMPLE_CSV =
    getSampleFilePath("sample.csv");

    // Email documents
    public static String SAMPLE_EML =
    getSampleFilePath("sample.eml");

    // Word Processing documents
    public static String SAMPLE_DOCX =
    getSampleFilePath("sample.docx");
    public static String SAMPLE_DOCX_WITH_COMMENT =
    getSampleFilePath("with_comment.docx");
    public static String SAMPLE_DOCX_WITH_PASSWORD =
    getSampleFilePath("password_protected.docx");
    public static String SAMPLE_DOCX_WITH_TRACKED_CHANGES =
    getSampleFilePath("with_tracked_changes.docx");
    public static String SAMPLE_TXT =
    getSampleFilePath("sample.txt");
    public static String SAMPLE_TXT_SHIFT_JS_ENCODED =
    getSampleFilePath("shift_jis_encoded.txt");

    // Images
    public static String MISSING_FONT_ODG =
    getSampleFilePath("with_missing_font.odg");

    //Xml
    public static String SAMPLE_XML_DATASOURCE = getSampleFilePath("sample_datasource.xml");

    private static String getSampleFilePath(String filePath) {
        return new File(SamplesPath, filePath).getPath();
    }

    public static String getOutputDirectoryPath(String callerFilePath)
    {
        String outputDirectory = new File(OutputPath, callerFilePath != null ? callerFilePath : "").getPath();
        return outputDirectory;
    }

    public static String getConvertedPath(String convertedFileName)
    {
        String convertedPath = new File(OutputPath, convertedFileName).getPath();
        return convertedPath;
    }

		
}
