---
id: groupdocs-conversion-for-java-17-7-release-notes
url: conversion/java/groupdocs-conversion-for-java-17-7-release-notes
title: GroupDocs.Conversion for Java 17.7 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 17.7{{< /alert >}}

## Major Features

There are 14 new features, improvements and fixes in this regular monthly release. The most notable are:

*   Introduced new method for retrieving basic metadata of the source document
*   Improved handling of extension-less urls
*   Improved to HTML conversions
*   Improved HTML to Cells conversions
*   Conversion from XML-FO/XSL to PDF
*   New option to set zoom when converting to HTML
*   Conversion from Vsdm, Vssm, Vstm
*   Conversion from LaTex
*   Improved speed when converting from cells.
*   Improved memory usage
*   Returning available layouts for a CAD document
*   Option to hide PDF annotations when converting from PDF
*   Option to specify exact layout to convert from a CAD document
*   Option to specify Width and Height for the result document when converting From CAD document
*   Fixed 11 bug

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-1810 | Implement method for getting extended document information | New Feature |
| CONVERSIONNET-1892 | Implement conversion from XML-FO/XSL | New Feature |
| CONVERSIONNET-1910 | Option to set zoom when converting to HTML | New Feature |
| CONVERSIONNET-1917 | Conversion from Vsdm, Vssm, Vstm | New Feature |
| CONVERSIONNET-1928 | Implement conversion from LaTex | New Feature |
| CONVERSIONNET-1756 | PPTX to HTML Conversion - Slide zoom level property | New Feature |
| CONVERSIONNET-1968 | Update DocumentInfo class to return all layouts for CAD document types | New Feature |
| CONVERSIONNET-1969 | Implement possibility to convert specific layouts when converting from CAD document | New Feature |
| CONVERSIONNET-1970 | Convert Pdf documents without annotations | New Feature |
| CONVERSIONNET-1835 | Convert Html to Cells improvements | Improvement |
| CONVERSIONNET-1845 | Convert Cad to Html improvements | Improvement |
| CONVERSIONNET-1846 | Convert Note to Html improvements | Improvement |
| CONVERSIONNET-1840 | Convert Slides to Html improvements | Improvement |
| CONVERSIONNET-1847 | Convert Tasks to Html improvements | Improvement |
| CONVERSIONNET-1851 | Convert Words to Html improvements with UsePdf=true option set | Improvement |
| CONVERSIONNET-1871 | Improved handling of extension-less urls | Improvement |
| CONVERSIONNET-1881 | Improve SlidesToHtml saver | Improvement |
| CONVERSIONNET-1885 | Update CellsToImageSaver and CellsToPdfSaver to remove empty rows and columns before saving document | Improvement |
| CONVERSIONNET-1962 | Implement possibility to set Width and Height when converting from CAD document | Improvement |
| CONVERSIONNET-1678 | Failed to validate PDF\_X\_3 and PDF\_X\_1A | Bug |
| CONVERSIONNET-1844 | Converting Image to Html with UsePdf=true always use direct conversion instead converting through Pdf | Bug |
| CONVERSIONNET-1676 | Loading Latex document from stream requires FileStream | Bug |
| CONVERSIONNET-1884 | PPt to PDF Conversion - Tables borders are showing - showgridline property is also not working for this | Bug |
| CONVERSIONJAVA-425 | Issue in TIF to PDF conversion in Gradle project | Bug |
| CONVERSIONJAVA-431 | Word documents with tables are not converting to images properly | Bug |
| CONVERSIONJAVA-399 | PDF to Image output is not as expected | Bug |
| CONVERSIONJAVA-395 | License exception throws in spite of GroupDocs license was set | Bug |
| CONVERSIONJAVA-437 | Output image is always blank or invalid if license is not applied | Bug |
| CONVERSIONJAVA-426 | Unable to set watermark color while converting document to image | Bug |
| CONVERSIONJAVA-219 | Usage of PageMode when converting to PDF is not supported | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for Java 17.7. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### How to get source document metadata



```java
String sourceFileName = "DOCXsample.docx"; //TODO: Put the source filename here 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath); 

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
DocumentInfo documentInfo = conversionHandler.getDocumentInfo(sourceFileName); 

System.out.print("Size: %s}" + documentInfo.getSize());
System.out.print("File type: %s" + documentInfo.getFileType());
System.out.print("Pages count: %s" + documentInfo.getPageCount());
System.out.print("Last modified: %s" + documentInfo.getModifiedDate());
```

### How to convert XML-FO/XSL to PDF



```java
String sourceFileName = "CELLSsample.xlsx"; //TODO: Put the source filename here
String foFileName = "sample.xslt"; 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath); 

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig); 

FileInputStream foStream = new FileInputStream(storagePath + "/" + foFileName); 

PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
pdfSaveOptions.setOutputType(OutputType.String); 

XmlLoadOptions xmlLoadOptions = new XmlLoadOptions();
xmlLoadOptions.setXslFo(foStream); 

String result = conversionHandler.<String>convert(sourceFileName, xmlLoadOptions, pdfSaveOptions);
System.out.print(result);
```

### How to set zoom when converting slides to HTML



```java
String sourceFileName = "sample.pptx"; //TODO: Put the source filename here 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig); 

HtmlSaveOptions saveOptions = new HtmlSaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setZoom(150); 

String resultPath = conversionHandler.<String>convert(sourceFileName, saveOptions); 

System.out.print(resultPath);
```

  

### How to get available layouts in a CAD document



```java
String sourceFileName = "sample.dwg"; //TODO: Put the source filename here 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig); 

DocumentInfo result = conversionHandler.getDocumentInfo(sourceFileName); 

for (String layer : result.getLayers()) {
System.out.println(layer);
}
```

### How to convert specific layout from a CAD document



```java
String sourceFileName = "sample.dwg"; //TODO: Put the source filename here
String[] layoutNames = new String[1];
layoutNames[0] = "layout-1"; 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig); 

PdfSaveOptions options = new PdfSaveOptions();
options.setOutputType(OutputType.String);
options.getCadOptions().setLayoutNames(layoutNames); 

String result = conversionHandler.<String>convert(sourceFileName, options); 

System.out.print(result);
```

### How to set specific width and height for each layout from a CAD document



```java
String sourceFileName = "sample.dwg"; //TODO: Put the source filename here 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath); 

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig); 

PdfSaveOptions options = new PdfSaveOptions();
options.setOutputType(OutputType.String);
options.getCadOptions().setWidth(800);
options.getCadOptions().setHeight(600); 

String result = conversionHandler.<String>convert(sourceFileName, options); 

System.out.print(result);
```

### How to hide annotations when converting from PDF



```java
String sourceFileName = "sample.pdf"; //TODO: Put the source filename here 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig); 

WordsSaveOptions options = new WordsSaveOptions();
options.setOutputType(OutputType.String);
options.setHidePdfAnnotations(true); 

String result = conversionHandler.<String>convert(sourceFileName, options); 

System.out.print(result);
```
