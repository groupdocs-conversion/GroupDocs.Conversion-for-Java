---
id: groupdocs-conversion-for-java-18-6-release-notes
url: conversion/java/groupdocs-conversion-for-java-18-6-release-notes
title: GroupDocs.Conversion for Java 18.6 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 18.6{{< /alert >}}

## Major Features

There are 5+ new features, improvements and fixes in this regular monthly release. The most notable are:

*   Conversion from DWF    
*   Improved caching    
*   Conversion from PostScript    
*   Option to convert specific range when converting from cells    
*   Option for skipping blank rows and columns when converting from cells
*   Bug fixes
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-1943 | Implement conversion from DWF | New Feature |
| CONVERSIONNET-2322 | Convert specific range when converting cells document | New Feature |
| CONVERSIONNET-2344 | Implement conversion from PostScript | New Feature |
| CONVERSIONNET-2397 | Implement specific options for converting CSV documents | New Feature |
| CONVERSIONNET-2414 | Implement setting default zoom when converting to Cells | New Feature |
| CONVERSIONNET-2417 | Implement setting default zoom when converting to Words | New Feature |
| CONVERSIONNET-2418 | Implement setting default zoom when converting to Slides | New Feature |
| CONVERSIONNET-2423 | Implement configurable option for setting a watermark as background | New Feature |
| CONVERSIONNET-2340 | Improve caching with provided LocalCacheDataHandler | Improvement |
| CONVERSIONNET-2338 | Implement configuration option for selecting if blank rows and columns should be skipped when converting Cells document | Improvement |
| CONVERSIONNET-2395 | Set zoom when converting to Pdf document | Improvement |
| CONVERSIONNET-2406 | Update API for getting document info to detect page orientation for the supported formats | Improvement |
| CONVERSIONNET-2392 | Set default font to replace all missing fonts when converting Words document | Improvement |
| CONVERSIONNET-2394 | Set default font to replace all missing fonts when converting Cells document | Improvement |
| CONVERSIONNET-2421 | Conversion improvement when converting Psd and Odg to Pdf | Improvement |
| CONVERSIONNET-2284 | Unable to set watermark text | Bug |
| CONVERSIONNET-2339 | Converting specific docx document fails with Value cannot be null, parameter trueTypeFont | Bug |
| CONVERSIONNET-2341 | Fix failing conversion from Odg | Bug |
| CONVERSIONNET-2342 | Fix failing conversion from Ifc | Bug |
| CONVERSIONNET-2324 | Just print area is getting converted, not the entire spreadsheet | Bug |
| CONVERSIONNET-2304 | XPS to PDF conversion failed | Bug |
| CONVERSIONJAVA-441 | LoadOptions doesn't possess setDefaultFont method | Bug |
| CONVERSIONJAVA-455 | Just print area is getting converted, not the entire spreadsheet | Bug |
| CONVERSIONJAVA-468 | Problem in converting large excel files. Is there a way to paginate the excel sheet? | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for Java 18.6. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behaviorintroduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Introduced new property PageOrientation in DocumentInfo class

**Get page orientation**

```java
public int getPageOrientation();
public void setPageOrientation(int value); 
```

**Usage**

```java
DocumentInfo sut = conversionHandler.getDocumentInfo("source.docx");
int po = sut.getPageOrientation(); 
```

### Introduced new property ConvertRange

**Convert specific range when converting to other than cells format. Example: "D1:F8"**

```java
public String getConvertRange();
public void setConvertRange(String value); 
```

**Usage**

```java
com.groupdocs.conversion.converter.option.ImageSaveOptions saveOptions = new com.groupdocs.conversion.converter.option.ImageSaveOptions();
saveOptions.getCellsOptions().setConvertRange("D1:F8"); 
```

### Introduced new property SkipEmptyRowsAndColumns

**Skips empty rows and columns when converting. Default is True**

```java
public boolean getSkipEmptyRowsAndColumns();
public void setSkipEmptyRowsAndColumns(boolean value); 
```

**Usage**

```java
PdfSaveOptions saveOptions = new PdfSaveOptions();
saveOptions.getCellsOptions().setSkipEmptyRowsAndColumns(false); 
```

### Introduced new property DefaultFont in CellsLoadOptions class

**Default font for Cells document. The following font will be used if a font is missing**

```java
public String getDefaultFont();
public void setDefaultFont(String value); 
```

**Usage**

```java
ConversionConfig config = new ConversionConfig();
ConversionHandler conversionHandler = new ConversionHandler(config);
CellsLoadOptions loadOptions = new CellsLoadOptions();
loadOptions.setDefaultFont("Verdana");
PdfSaveOptions saveOptions = new PdfSaveOptions();
ConvertedDocument convertedDocument = conversionHandler.convert("source.xlsx", loadOptions, saveOptions);
```

### Introduced new property DefaultFont in WordsLoadOptions class

**Default font for Words document. The following font will be used if a font is missing**

```java
public String getDefaultFont();
public void setDefaultFont(String value);
```

**Usage**

```java
ConversionConfig config = new ConversionConfig();
ConversionHandler conversionHandler = new ConversionHandler(config);
WordsLoadOptions loadOptions = new WordsLoadOptions();
loadOptions.setDefaultFont("Verdana");
PdfSaveOptions saveOptions = new PdfSaveOptions();
ConvertedDocument convertedDocument = conversionHandler.convert("source.docx", loadOptions, saveOptions);
```

### Introduced new property Backgroud in WatermarkOptions class

**Indicates that the watermark is stamped as background. If the value is true, the watermark is layed at the bottom. By default is false and the watermark is layed on top**

```java
public boolean getBackground();
public void setBackground(boolean value); 
```

**Usage**

```java
PdfSaveOptions saveOptions = new PdfSaveOptions();
saveOptions.getWatermarkOptions().setBackground(true); 
```
