---
id: groupdocs-conversion-for-java-17-7-1-release-notes
url: conversion/java/groupdocs-conversion-for-java-17-7-1-release-notes
title: GroupDocs.Conversion for Java 17.7.1 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 17.7.1{{< /alert >}}

## Major Features

There are fixed 1 bug:

*   Single source file DOCX different outputs PDF on different platforms/environment

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONJAVA-451 | Single source file DOCX different outputs PDF on different platforms/environment | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for Java 17.7.1. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Single source file DOCX different outputs PDF on different platforms/environment



```java
// In Fonts folder must be two fonts "Calibri.ttf" and "Cambria Math.ttf" 

String projectPath = new java.io.File("Data/").getAbsolutePath().replace("
", "/");
String storagePath = projectPath + "/Storage/";
String outputPath = projectPath + "/Output/";
String fontsPath = projectPath + "/Fonts/"; 

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setOutputPath(outputPath);
conversionConfig.getFontDirectories().add(fontsPath); 

// Instantiating the conversion handler
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
PdfSaveOptions saveOption = new PdfSaveOptions();
saveOption.setOutputType(OutputType.String); 

// Set absolute path to file
String guid = "Assignment__2_7.1-7.3.docx";
String convertedDocumentPath = conversionHandler.<String>convert(guid, saveOption);
```
