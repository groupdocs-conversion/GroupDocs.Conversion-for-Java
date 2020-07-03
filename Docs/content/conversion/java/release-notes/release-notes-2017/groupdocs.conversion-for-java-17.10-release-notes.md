---
id: groupdocs-conversion-for-java-17-10-release-notes
url: conversion/java/groupdocs-conversion-for-java-17-10-release-notes
title: GroupDocs.Conversion for Java 17.10 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 17.10{{< /alert >}}

## Major Features

There are 4 new features, improvements and fixes in this regular monthly release. The most notable are:

*   Hide comments from Cells documents
*   Option to convert specific pages (e.g. 1,3,5) from source document
*   Simplifying the generated HTML markup
*   Fixed bug with fixed layout when converting to HTML
*   Major improvements in the public API. Note: no braking changes. The redundant methods are marked as obsolete and will be removed after 17.12.0 release
*   Improvement in diagram to HTML conversion
*   Improved conversion from SVG
*   Email to HTML conversion improvements
*   Converting from STL
*   Converting from IFC
*   Improved Cells to XPS conversions
*   Improved Slides to XPS conversions
*   Improved saving on the whole converted document as well as page by page saving functionallity
*   Watermark transparency set to 50% transparent by default
*   9 bugs fixed

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-1999 | Hide comments for Cells documents | New Feature |
| CONVERSIONNET-1984 | Implement possibility to convert specific pages | New Feature |
| CONVERSIONNET-2170 | Implement conversion from STL | New Feature |
| CONVERSIONNET-2171 | Implement conversion from IFC | New Feature |
| CONVERSIONNET-2176 | Conversion of document containing images to RTF with "old readers" compatibility | New Feature |
| CONVERSIONNET-2003 | Simplify the generated HTML markup | Improvement |
| CONVERSIONNET-1841 | Convert Diagram to Html improvements | Improvement |
| CONVERSIONNET-2044 | Conversion from SVG improvement | Improvement |
| CONVERSIONNET-2056 | Email to Html conversion improvement | Improvement |
| CONVERSIONNET-2072 | Improved public API | Improvement |
| CONVERSIONNET-2108 | Improve document savers for saving complete document and save by page | Improvement |
| CONVERSIONNET-2130 | Cells To XPS conversion improvement | Improvement |
| CONVERSIONNET-2152 | WatermarkOptions is instantiated default Width and Height of the watermark | Improvement |
| CONVERSIONNET-2153 | Set default transparency of watermark to 0.5 | Improvement |
| CONVERSIONNET-2155 | Slides To XPS conversion improvement | Improvement |
| CONVERSIONNET-2161 | Expose FileType and PagesCount properties in ConvertedDocument class | Improvement |
| CONVERSIONNET-2020 | Converting to Html with SaveOptions.FixedLayout=false always produce fixed layout html conversion | Bug |
| CONVERSIONNET-1754 | PPTX to HTML Conversion - While converting pptx to html found improper text formatting of Header or missing text | Bug |
| CONVERSIONNET-2042 | ImageSaveOptions.TiffOptions.Compression does not seem to work | Bug |
| CONVERSIONNET-1755 | PPTX to HTML Conversion - Image without background converted with white background also white dot is added near Header Text | Bug |
| CONVERSIONNET-809 | Images are missing when PDF is saved to EPUB | Bug |
| CONVERSIONNET-1908 | Incorrect conversion from One to Pdf | Bug |
| CONVERSIONNET-2158 | PsdOptions does not have constrcutor | Bug |
| CONVERSIONNET-2163 | Converting HTML with external resources produce wrong output | Bug |
| CONVERSIONNET-2167 | Pdf locked with modification password but without view password cannot be converted | Bug |
| CONVERSIONJAVA-143 | Conversion .html to .pdf doesn't load .css and image resources from relative path | Bug |
| CONVERSIONJAVA-405 | Simplify the generated HTML markup | Bug |
| CONVERSIONJAVA-442 | File extension for filetype is not reliable | Bug |
| CONVERSIONJAVA-443 | Corrupted Jpeg scan component id definition. Cannot load image | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for Java 17.10. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### How to hide comments when converting from Cells



```java
 String sourceFileName = "source.xlsx"; //TODO: Put the source filename here 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);
conversionConfig.setOutputPath(outputPath); 

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig); 

PdfSaveOptions options = new PdfSaveOptions();
options.setOutputType(OutputType.String);
options.setHideComments(true); 

ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, options);
result.save(sourceFileName + "." + result.getFileType());
```

### How to convert specific pages from source document



```java
String sourceFileName = "DOCXsample.docx"; //TODO: Put the source filename here with more than 5 pages 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);
conversionConfig.setOutputPath(outputPath); 

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig); 

PdfSaveOptions options = new PdfSaveOptions();
options.setOutputType(OutputType.String);
ArrayList<Integer> arrayList = new ArrayList<Integer>();
arrayList.add(1);
arrayList.add(3);
arrayList.add(5);
options.setConvertPages(arrayList); 

ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, options);
result.save(sourceFileName + "." + result.getFileType());
```

### How to get simplified markup when converting to HTML



```java
String sourceFileName = "DOCXsample.docx"; //TODO: Put the source filename here 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);
conversionConfig.setOutputPath(outputPath); 

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig); 

HtmlSaveOptions options = new HtmlSaveOptions();
options.setOutputType(OutputType.String);
options.setFixedLayout(false); 

ConvertedDocument result = conversionHandler.<String>convert(sourceFileName, options);
result.save(sourceFileName + "." + result.getFileType());
```
