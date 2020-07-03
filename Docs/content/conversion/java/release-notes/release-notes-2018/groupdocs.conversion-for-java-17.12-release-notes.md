---
id: groupdocs-conversion-for-java-17-12-release-notes
url: conversion/java/groupdocs-conversion-for-java-17-12-release-notes
title: GroupDocs.Conversion for Java 17.12 Release Notes
weight: 5
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 17.12{{< /alert >}}

## Major Features

There are 5+ new features, improvements and fixes in this regular monthly release. The most notable are:

*   Cells to SVG conversion improvement
*   Diagram to SVG conversion improvement
*   Detecting unsupported Excel 95 format and throw meaningful exception
*   Conversion from/to POTX and POTM
*   Conversion from/to PPTM and PPSM
*   Conversion from/to XLTX and XLTM
*   Conversion from/to Jpeg 2000    
*   Option to convert one sheet per page depending from print area when converting Cells to PDF    
*   Option to optimize resulting PDF to minimum file size    
*   Improved image to SVG conversion    
*   Improved word to GIF conversion    
*   5 bugs fixed  
          

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-2183 | Implement conversion from/to POTX and POTM | New Feature |
| CONVERSIONNET-2209 | Implement conversion from/to PPTM and PPSM | New Feature |
| CONVERSIONNET-2218 | Implement conversion from/to XLTX and XLTM | New Feature |
| CONVERSIONNET-2277 | Implement conversion from/to Jpeg2000 | New Feature |
| CONVERSIONNET-2206 | Check for unsupported Excel 95 XLS file format and throw an exception | Improvement |
| CONVERSIONNET-2225 | Cells to SVG conversion improvement | Improvement |
| CONVERSIONNET-2235 | Diagram to SVG conversion improvement | Improvement |
| CONVERSIONNET-2245 | Set custom font directories | Improvement |
| CONVERSIONNET-2257 | Implement possibility to convert one sheet per page or depending on print area when converting Cells to Pdf | Improvement |
| CONVERSIONNET-2258 | Implement possibility to optimize target Pdf for minimum file size when converting Cells to Pdf | Improvement |
| CONVERSIONNET-2262 | Image to SVG conversion improvement | Improvement |
| CONVERSIONNET-2266 | Words to Gif conversion improvement | Improvement |
| CONVERSIONNET-2180 | Conversion for Doc with macro to Docx failed | Bug |
| CONVERSIONNET-2103 | System.ArgumentException when converting Mobi to Ppt or Pps | Bug |
| CONVERSIONNET-2173 | Conversion of specific pptx to jpg results wrong output | Bug |
| CONVERSIONNET-2240 | PDF to TIF conversion, InvalidValueFormatException | Bug |
| CONVERSIONNET-2234 | Index was outside the bounds of the array, while Converting .xlsx File To PDF | Bug |
| CONVERSIONJAVA-445 | Numerous new exceptions when using Conversion 17.3.0 | Bug |
| CONVERSIONJAVA-483 | The protected presentation throws some other exception than PasswordProtectedException | Bug |
| CONVERSIONJAVA-401 | Certain presentation slide is not converting properly to any output format | Bug |
| CONVERSIONJAVA-444 | File reading error | Bug |
| CONVERSIONJAVA-448 | Does the API supports output HTML styles | Bug |
| CONVERSIONJAVA-201 | Performance issue while converting PDF files | Bug |
| CONVERSIONJAVA-217 | Getting file's metadata using Document Conversion API | Bug |
| CONVERSIONJAVA-474 | Saving complete multipage document to image is not supported | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for Java 17.12. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behaviorintroduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### v 17.11 GroupDocs.Conversion.Config.ConversionConfig.FontDirectories

Introduced new property:

```java
// The custom font directories paths
public List<String> getFontDirectories() {}
```

Usage:

```java
ConversionConfig config = new ConversionConfig();
config.getFontDirectories().add("c:\custom-fonts");
```

### v 17.12 GroupDocs.Conversion.Converter.Option.CellsOptions

## Introduced new property OnePagePerSheet

```java
// If OnePagePerSheet is true the content of the sheet will be converted to one page in the PDF document. Default value is true.
public boolean getOnePagePerSheet() {}
public void setOnePagePerSheet(boolean value) {}
```

Usage:

```java
PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
pdfSaveOptions.setOnePagePerSheet(false);
```

## Introduced new property OptimizedPdfSize

```java
// If True and converting to Pdf the conversion is optimized for better file size than print quality
public boolean getOptimizePdfSize() {}
public void setOptimizePdfSize(boolean value) {}
```

Usage:

```java
PdfSaveOptions saveOptions = new PdfSaveOptions();
saveOptions.getCellsOptions().setOptimizePdfSize(false);
```
