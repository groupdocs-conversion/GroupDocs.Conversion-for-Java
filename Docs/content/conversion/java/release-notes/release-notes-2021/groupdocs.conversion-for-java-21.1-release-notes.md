---
id: groupdocs-conversion-for-java-21-1-release-notes
url: conversion/java/groupdocs-conversion-for-java-21-1-release-notes
title: GroupDocs.Conversion for Java 21.1 Release Notes
weight: 16
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 21.1{{< /alert >}}
## Major Features

There are 20+ features, improvements and bug-fixes in this release, most notable are:

*   Conversions to Dif
*   Conversions from/to SXC
*   Conversions from AI
*   Conversions from/to Emz
*   Conversions from/to Wmz
*   Conversions from/to Svgz
*   Conversions from LOG file format
*   Extended meta data for word processing documents with TableOfContent
*   Extended meta data for pdf documents with TableOfContent
*   Fixed conversions from XLSX to PNG
*   Fixed conversions from DWG to DOCX 
*   Properly detect email type even if file extension is incorrect
*   Conversions from Mhtml
*   Improved page extraction when converting from wordprocessing documents
*   Improved csv/ods pagination
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-3968    |	Feature |	Implement conversion to Dif |
| CONVERSIONNET-3970    |	Feature |	Implement conversion from SXC |
| CONVERSIONNET-3971    |	Feature |	Implement conversion to SXC |
| CONVERSIONNET-4039    |	Feature |	Implement conversion from AI |
| CONVERSIONNET-4042    |	Feature |	Implement conversion from/to Emz |
| CONVERSIONNET-4043    |	Feature |	Implement conversion from/to Wmz |
| CONVERSIONNET-4044    |	Feature |	Implement conversion from/to Svgz |
| CONVERSIONNET-4054    |   Feature |   LOG file format support |
| CONVERSIONNET-4163 |  Feature	    | Implement conversion from Mhtml |
| CONVERSIONNET-4006    |	Improvement |	Change watermark font property from System.Drawing.Font to own class |
| CONVERSIONNET-4095 | Improvement | Extend WordprocessingDocumentInfo with TableOfContents property |
| CONVERSIONNET-4096 | Improvement | Extend PdfDocumentInfo with TableOfContents property |
| CONVERSIONNET-4146 |	Improvement | Introduce new load option to exclude Excel checks when converting from Spreadsheet document types |
| CONVERSIONNET-4205 |  Improvement | Improved page extraction when converting from word documents  |
| CONVERSIONNET-4208 |  Improvement | Csv/ods pagination |
| CONVERSIONNET-3707    |	Bug |	Exception while Converting WMF to DOC using GroupDocs.Conversion .NET API v20.1.0 As Image export failed |
| CONVERSIONNET-3809    |	Bug |	PDF to ODS conversion issue |
| CONVERSIONNET-3851    |	Bug |	PDF to HTML conversion issue, additional space in a word |
| CONVERSIONNET-3891    |	Bug |	DOCX to PDF conversion issue for a particular file |
| CONVERSIONNET-3893    |	Bug |	VSDX to PNG Conversion issue |
| CONVERSIONNET-3911    |	Bug |	PDF to CSV conversion issue |
| CONVERSIONNET-3962    |	Bug |	PPT/PPTX to XLS conversion issue |
| CONVERSIONNET-3997    |	Bug |	Conversion is stuck |
| CONVERSIONNET-3998    |	Bug |	XLSM to PDF - Index was outside the bounds of the array |
| CONVERSIONNET-4022    |	Bug |	Bad image quality for low resolution PNG |
| CONVERSIONNET-4056    |	Bug |	HTML to PDF conversion, characters issue |
| CONVERSIONNET-3772 | Bug         | XLSB to XLS conversion - The column index should not be inside the pivottable report |
| CONVERSIONNET-3826 | Bug         | PDF to HTML conversion taking too long |
| CONVERSIONNET-3851 | Bug         | PDF to HTML conversion issue, additional space in a word |
| CONVERSIONNET-3936 | Bug         | ODG to PPT conversion issue |
| CONVERSIONNET-3985 | Bug         | Could not load the file \'Aspose.Slides\'. exception when targeting Xamarin.Mac Full / .NET Framework 4.5 |
| CONVERSIONNET-3999 | Bug         | XLSM to PDF - The row index should not be inside the pivottable report |
| CONVERSIONNET-4124 | Bug         | JPG to BMP conversion throws an exception |
| CONVERSIONNET-3786 |	Bug	        | XLSB to XLSX conversion issue for a particular file |
| CONVERSIONNET-3788 |	Bug	        | WMF to GIF conversion issue |
| CONVERSIONNET-3934 |	Bug	        | XLSX to PNG conversion produces only black image |
| CONVERSIONNET-4143 |	Bug	        | Conversion take to much time |
| CONVERSIONNET-4152 |	Bug	        | DWG to DOCX conversion issue |
| CONVERSIONNET-4161 |	Bug	        | Cannot convert Email document if the file format doesn't match file extension |
| CONVERSIONNET-4157 |  Bug	        | Not supported file type exception |
| CONVERSIONNET-4180 |  Bug         | DOCX->PDF conversion: 'Object reference not set to an instance of an object.' |
| CONVERSIONNET-4206 |  Bug         | Failed conversion from particular Mhtml to Pdf |
| CONVERSIONNET-4211 |  Bug         | Exception is thrown when converting particular Html document to Xlsx |
| CONVERSIONJAVA-1035 |  Bug         | XLS to PDF conversion issue |
| CONVERSIONJAVA-1153 |  Bug         | DOCX to PDF conversion issue |
| CONVERSIONJAVA-1074 |  Bug         | Paragraph splitting issue in PDF to DOCX conversion |
| CONVERSIONJAVA-1187 |  Bug         | License issue when both Comparison and Conversion APIs are used together |
| CONVERSIONJAVA-1189 |  Bug         | Loading certain documents from stream raise an exception |
| CONVERSIONJAVA-1209 |  Bug         | TIFF to PDF conversion issue |

## Public API and Backward Incompatible Changes
1.  **Introduced new property in class WatermarkOptions**
    
    ```java
    /**
    * Watermark font if text watermark is applied
    * @return font
    */ 
    public Font getWatermarkFont();
    
    /**
    * Sets Watermark font if text watermark is applied
    *
    * @param watermarkFont font
    */
    public void setWatermarkFont(Font watermarkFont);

    ```
    
2.  **Following properties are marked as obsolete**
    
    * **GroupDocs.Conversion.Options.Convert.WatermarkOptions** property **getFont() / setFont()**  - will be removed in v21.3. Property **getWatermarkFont() / setWatermarkFont** must be used instead.
    
3.  **Following properties are removed**
    
    * From **GroupDocs.Conversion.ConverterSettings** property **getDefaultFont() / setDefaultFont()**
    * From **GroupDocs.Conversion.Options.Load.EmailLoadOptions** property **isConvertAttachments() / setConvertAttachments()**

4.  **Introduced new property in class WordprocessingDocumentInfo**
    
    ```java
    /**
    * Table of contents
    */
    public List<TableOfContentsItem> getTableOfContents()
    ```
    
5.  **Introduced new property in class PdfDocumentInfo**
    
    ```java
    /**
    * Table of contents
    */
    public IEnumerable<TableOfContentsItem> getTableOfContents();
    ```
    
6.  **Introduced new class GroupDocs.Conversion.Contracts.TableOfContentsItem**
    
    ```java
    /**
    * Contains Table of contents item metadata
    */
    public class TableOfContentsItem {
        /**
        * Bookmark title
        */
        public string getTitle();
        /**
        * Bookmark page
        */
        public int getPage();
    }
    ```
    Usage
    ```java
    String source = "sample-toc.docx";
    Converter converter = new Converter(source);
    try {
        WordprocessingDocumentInfo documentInfo = (WordprocessingDocumentInfo) converter.getDocumentInfo();
        for (TableOfContentsItem tocItem : documentInfo.getTableOfContents()) {
            System.out.println(tocItem.getTitle() + ": " + tocItem.getPage());
        }
    } finaly {
        converter.dispose();
    }
    ```
    
7.  **Introduced new property in class SpreadsheetLoadOptions**
    
    ```java
    /**
    * Whether check restriction of excel file when user modify cells related objects.
    * For example, excel does not allow inputting string value longer than 32K.
    * When you input a value longer than 32K, if this property is true, you will get an Exception.
    * If this property is false, we will accept your input string value as the cell's value so that later
    * you can output the complete string value for other file formats such as CSV.
    * However, if you have set such kind of value that is invalid for excel file format, you should not save
    * the workbook as excel file format later. Otherwise there may be unexpected error for the generated excel file.
    */
    public boolean isCheckExcelRestriction();
    
    public boolean setCheckExcelRestriction();
   
