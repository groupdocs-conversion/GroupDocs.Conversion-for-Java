---
id: groupdocs-conversion-for-java-17-3-0-release-notes
url: conversion/java/groupdocs-conversion-for-java-17-3-0-release-notes
title: GroupDocs.Conversion for Java 17.3.0 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 17.3.0{{< /alert >}}

## Major Features

There are 26 new features, improvements and fixes in this regular monthly release. The most notable are:

*   Conversions from DjVu format
*   Conversions from EMF format
*   Conversions from WMF format
*   Conversions from DICOM format
*   Conversions from OTP format
*   Helper method to return possible conversions from file extension or stream
*   Helper method to return pages count of a document which will be converted
*   Improved progress reporting
*   Improved performance of Word to Pdf and Word to Epub conversions
*   Conversions from and to Webp format
*   Improved memory handling
*   Improved performance
*   Conversions to XPS format
*   Conversions to SVG format
*   Conversions from OTS format
*   Reduced memory usage
*   Conversions to specific PDF format
*   Conversions from PDF-A
*   Conversions from Mobi
*   Setting different horizontal and vertical resolution when converting to image
*   Conversions from DNG
*   Conversions from DGN
*   Conversions from VSSX and VSTX
*   Conversions from ONE
*   Option to hide WORD comments when converting from word
*   Improved performance of HTML to PDF conversions

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-1387 | Implement OTP file format conversion | New Feature |
| CONVERSIONNET-1413 | Implement DICOM file format conversion | New Feature |
| CONVERSIONNET-1418 | Implement conversion from WMF | New Feature |
| CONVERSIONNET-1419 | Implement conversion from EMF | New Feature |
| CONVERSIONNET-1447 | Count total pages of a document | New Feature |
| CONVERSIONNET-1458 | Return all possible conversions from file extension or stream | New Feature |
| CONVERSIONNET-1425 | Implement conversion from DjVu | New Feature |
| CONVERSIONNET-1480 | Implement conversion from Webp | New Feature |
| CONVERSIONNET-1483 | Implement conversion to Webp | New Feature |
| CONVERSIONNET-1683 | Metered licensing | New Feature |
| CONVERSIONNET-1585 | Implement conversion from OTS | New Feature |
| CONVERSIONNET-1598 | Implement conversion to grayscale image | New Feature |
| CONVERSIONNET-1619 | Implement conversion to XPS | New Feature |
| CONVERSIONNET-1624 | Implement conversion to SVG | New Feature |
| CONVERSIONNET-1685 | Implement conversion to PDF with setting PDF file format | New Feature |
| CONVERSIONNET-1693 | Conversion of PDF-A file to PDF | New Feature |
| CONVERSIONNET-1697 | Implement conversion from Mobi | New Feature |
| CONVERSIONNET-1722 | Horizontal and Vertical resolutions for conversions to Image | New Feature |
| CONVERSIONNET-1729 | Implement conversion from DNG | New Feature |
| CONVERSIONNET-1737 | Implement conversion from DGN | New Feature |
| CONVERSIONNET-1745 | Implement conversion from VSSX and VSTX | New Feature |
| CONVERSIONNET-1761 | Ability to hide words comments when converting from word | New Feature |
| CONVERSIONNET-1760 | Implement conversion from ONE | New Feature |
| CONVERSIONNET-1376 | Improve performance of Word to Pdf and Word to Epub conversions | Improvement |
| CONVERSIONNET-1400 | Improve progress reporting | Improvement |
| CONVERSIONNET-1485 | Improve memory handling | Improvement |
| CONVERSIONNET-1484 | Progress report is not working | Improvement |
| CONVERSIONNET-1645 | Improving memory handling on save | Improvement |
| CONVERSIONNET-1646 | Improving output file name if converting from/to page | Improvement |
| CONVERSIONNET-1648 | Improve memory handling in documents | Improvement |
| CONVERSIONNET-1719 | Convert Html to Pdf improvements | Improvement |
| CONVERSIONNET-1399 | Use LZW compression for internal tiff compression | Bug |
| CONVERSIONNET-1424 | Mssing "Fixedlayout" Property while Updating VB Example | Bug |
| CONVERSIONNET-1414 | File name contains extra symbols | Bug |
| CONVERSIONNET-1518 | Converting to image with set DPI options without setting image width and height is producing invalid image | Bug |
| CONVERSIONNET-1557 | HideWordTrackedChanges set to 'true' but still its showing track chnages and markup | Bug |
| CONVERSIONNET-1564 | Exception when loading EPUB in multithread | Bug |
| CONVERSIONNET-1566 | Exception when converting DWG to PNG in multithread | Bug |
| CONVERSIONNET-1567 | Exception is thrown when resizing specific Pdf file | Bug |
| CONVERSIONNET-1158 | Convert to HTML from PDF - Words in Bold Letters are not properly displayed | Bug |
| CONVERSIONNET-845 | Pdf to Html conversion formatting issue | Bug |
| CONVERSIONNET-1568 | Wrong characters when saving in HTML | Bug |
| CONVERSIONNET-1580 | Multipage Tiff is not converted properly to Pdf | Bug |
| CONVERSIONNET-1615 | Page mode conversions do not work | Bug |
| CONVERSIONNET-1643 | HideWordTrackedChanges not respected when converting from word | Bug |
| CONVERSIONNET-1644 | Dpi resolution not respected when converting Cells to Image | Bug |
| CONVERSIONNET-1692 | When converting a Cell to Pdf, the sheet is split into multiple pdf pages | Bug |
| CONVERSIONNET-1581 | System.ArgumentOutOfRangeException when adding shape to slide and saving | Bug |
| CONVERSIONNET-1709 | Converting TXT to any format with limiting pages produces wrong output | Bug |
| CONVERSIONNET-1684 | Exception when trying to access SaveOptions.ConvertFileType | Bug |
| CONVERSIONNET-1696 | .tif to .png conversion is not as expected | Bug |
| CONVERSIONNET-1597 | Memory leak when converting CAD stream to image | Bug |
| CONVERSIONJAVA-210 | .tif to .png conversion is not as expected | Bug |
| CONVERSIONJAVA-150 | % symbol in the file name trowns an exception | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for .NET 17.3.0. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### How to get pages count of a document which will be converted



```java
String storagePath = "C:\storagePath";
String cachePath = "C:\cachePath";
String sourceFileName = "DOCXsample.docx"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

int count = conversionHandler.getDocumentPagesCount(sourceFileName);

System.out.print("Count is: " + count);
```

### How to get possible conversions from file extension



```java
String storagePath = "C:\storagePath";
String cachePath = "C:\cachePath";

String sourceFileName = "DOCXsample.docx"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
String[] possibleConversions = conversionHandler.getPossibleConversions("docx");

System.out.print("Possible conversions: " + possibleConversions);
```

### How to get possible conversions from stream



```java
String storagePath = "C:\storagePath";
String cachePath = "C:\cachePath";
String sourceFileName = "DOCXsample.docx"; //TODO: Put the source filename here
 
// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

FileInputStream fileStream = new FileInputStream(storagePath + "/" + sourceFileName);

String[] possibleConversions = conversionHandler.getPossibleConversions(fileStream);
System.out.print("Possible conversions: " + possibleConversions);
```

### How to convert to WebP



```java
String storagePath = "C:\storagePath";
        
// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);

//instantiating the conversion handler
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
ImageSaveOptions options = new ImageSaveOptions();
options.setConvertFileType(ImageSaveOptions.ImageFileType.WEBP);
options.getWebpOptions().setLossless(true);

List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert("DOCXsample.docx", options);
System.out.print("Converted file path is: " + convertedDocumentStream);
```

### How to convert to grayscale image



```java
String storagePath = "C:\storagePath";
        
// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);

//instantiating the conversion handler
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
ImageSaveOptions options = new ImageSaveOptions();
options.setConvertFileType(ImageSaveOptions.ImageFileType.JPG);
options.setGrayscale(true);

List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert("DOCXsample.docx", options);
System.out.print("Converted file path is: " + convertedDocumentStream);
```

### How to convert to SVG



```java
String storagePath = "C:\storagePath";
        
// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);

//instantiating the conversion handler
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
ImageSaveOptions options = new ImageSaveOptions();
options.setConvertFileType(ImageSaveOptions.ImageFileType.SVG);

List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert("DOCXsample.docx", options);

System.out.print("Converted file path is: " + convertedDocumentStream);
```

### How to convert to XPS



```java
String storagePath = "C:\storagePath";
        
// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);

//instantiating the conversion handler
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

//PdfSaveOptions options = new PdfSaveOptions();
ImageSaveOptions options = new ImageSaveOptions();
options.setConvertFileType(PdfSaveOptions.PdfFileType.XPS);

List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert("DOCXsample.docx", options);
System.out.print("Converted file path is: " + convertedDocumentStream);
```

### Metered licensing



```java
String storagePath = "C:\storagePath";
        
// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);

// Create new instance of GroupDocs.Conversion.Metered classs
Metered metered = new Metered();

// Set public and private key to metered instance
metered.setMeteredKey(
    "***", 
    "***"
);

// Get metered value before usage of the conversion
double amountBefore = Metered.getConsumptionQuantity();
System.out.print("Amount consumed before: " + amountBefore);

//instantiating the conversion handler
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
PdfSaveOptions options = new PdfSaveOptions();
options.setConvertFileType(PdfSaveOptions.PdfFileType.PDF);

GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert("DOCXsample.docx", options);

// Get metered value after usage of the conversion
double amountAfter = Metered.getConsumptionQuantity();
System.out.print("Amount consumed after: " + amountAfter);
```

### How to hide comments when converting from Words



```java
String storagePath = "C:\storagePath";
String cachePath = "C:\cachePath";
        
// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);
conversionConfig.setCachePath(cachePath);
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

// Save options
SaveOptions saveOptions = new PdfSaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setHideWordComments(false);

String result = conversionHandler.<String>convert(sourceFileName, saveOptions);

System.out.print("Converted file path is: " + result);
```

### ImageSaveOptions.Dpi is marked as obsolete



```java
String storagePath = @"c:\Worx\aspose\sources\GroupDocs.Conversion.Test\SampleFiles";
        
// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setStoragePath(storagePath);

//instantiating the conversion handler
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
ImageSaveOptions options = new ImageSaveOptions();
options.setConvertFileType(ImageSaveOptions.ImageFileType.TIFF);
// Dpi is obsolete, now horizontal and vertical resolutions can be set independently
options.setHorizontalResolution(96);
options.setVerticalResolution(96);

List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert("DOCXsample.docx", options);

System.out.print("Converted file path is: " + convertedDocumentStream);
```
