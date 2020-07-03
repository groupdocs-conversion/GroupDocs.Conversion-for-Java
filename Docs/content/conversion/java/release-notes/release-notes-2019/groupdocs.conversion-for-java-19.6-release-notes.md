---
id: groupdocs-conversion-for-java-19-6-release-notes
url: conversion/java/groupdocs-conversion-for-java-19-6-release-notes
title: GroupDocs.Conversion for Java 19.6 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 19.6{{< /alert >}}

## Major Features 

This regular monthly release contains 5+ new features, improvements and bug fixes. Most notable are: 

*   Implemented conversion improvement when converting Svg to Slides    
*   Conversions from Vcf
*   Added support for setting watermark as background when converting to image
*   Saving converted document to file returns the file name and size
*   Fixed bug where Footnote page numbers only render the first digit    
*   Fixed bug where PowerPoint with black SmartArt Text gets changed into white text when converted to a PDF    
*   Fixed bug where was inconsistent conversion from email file formats when converting to Cells
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-2862 | Implement conversion from Vcf | Feature |
| CONVERSIONNET-2830 | Implement conversion improvement when converting Svg to Slides | Improvement |
| CONVERSIONNET-2878 | Add support for setting watermark as background when converting to image | Improvement |
| CONVERSIONNET-2881 | Save converted document to file should return the file name and size | Improvement |
| CONVERSIONNET-2863 | Issue with conversion .docx (with table of content) to .html | Bug |
| CONVERSIONNET-2864 | Conversion .pdf to .png (or .jpeg) with watermark as background issue | Bug |
| CONVERSIONNET-2871 | Inconsistent conversion from email file formats when converting to Cells | Bug |
| CONVERSIONNET-2876 | Receiving Aspose.Pdf.InvalidValueFormatException when converting a PDF file | Bug |
| CONVERSIONJAVA-543 | Footnote page numbers only render the first digit | Bug |
| CONVERSIONJAVA-468 | PowerPoint with black SmartArt Text gets changed into white text when converted to a PDF | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for Java 19.6. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  ** Removed obsolete package com.groupdocs.conversion.converter.option**
    
    All **`LoadOptions` **and **`SaveOptions` **classes removed from package **`com.groupDocs.conversion.converter.option`**.  
    **`LoadOptions` **classes are now in com.g**`roupdocs.conversion.options.load`** package.  
    **`SaveOptions`** classes are now in com.g**`roupdocs.conversion.options.save`** package.
    
2.  **Save converted document returns saved file name and size**
    
    ```java
    /**
     * <p>
     * Class for handling converted document
     * </p>
     */
    public final class ConvertedDocument implements IDisposable {
     /**
     * <p>
     * Save converted document to stream
     * </p>
     *
     * @param stream
     */
     public SaveInfo save(GroupDocsOutputStream stream) {
     ....
     
     /**
     * <p>
     * Save specific page from converted document to stream
     * </p>
     *
     * @param stream
     * @param page
     */
     public SaveInfo save(GroupDocsOutputStream stream, int page) {
     ....
    ```
    
    Usage
    
    ```java
    ...
    ConversionConfig config = new ConversionConfig();
    ConversionHandler conversionHandler = new ConversionHandler(config);
    String source = "source.docx";
    PdfSaveOptions saveOptions = new PdfSaveOptions();
    ConvertedDocument convertedDocument = conversionHandler.convert(source, saveOptions);
    SaveInfo saveInfo = convertedDocument.save("converted", 1);
    System.out.println(String.format("Page 1 file size: %d", saveInfo.getSize()));
    System.out.println(String.format("Page 1 saved path: %s", saveInfo.getFileName()));
    
    ...
    ```
