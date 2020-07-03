---
id: groupdocs-conversion-for-java-20-2-release-notes
url: conversion/java/groupdocs-conversion-for-java-20-2-release-notes
title: GroupDocs.Conversion for Java 20.2 Release Notes
weight: 30
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
## Major Features

{{< alert style="danger" >}}In this version we're introducing new public API which was designed to be simple and easy to use. For more details about new API please check Public Docs section. The legacy API have been moved into legacy package so after update to this version it is required to make project-wide replacement of package usages from com.groupdocs.conversion. to com.groupdocs.conversion.legacy. to resolve build issues.{{< /alert >}}

Additionally 5 features, improvements and bug-fixes in this release, most notable are: 

*   Exception "Specified argument was out of the range of valid values" is raised when converting a spreadsheet document to PDF    
*   Added an option to set timezone offset when converting from email.
*   Converting from spreadsheet to html now respects specified range for conversion.
*   Improved conversion of multi-page TIFF to PDF    
*   Fixed bug while exception stream is not expandable when converting to html
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-3323 | Feature | Keep the timezone of the SENT field |
| CONVERSIONNET-3416 | Improvement | Converting multi-page TIFF to PDF |
| CONVERSIONNET-3356 | Bug | Converting spreadsheet to html, ranges are not respected |
| CONVERSIONNET-3376 | Bug | Exception stream is not expandable when converting to html |
| CONVERSIONNET-3142 | Bug | Specified argument was out of the range of valid values when converting a spreadsheet document to pdf |

## Public API and Backward Incompatible Changes

#### All public types from com.groupdocs.conversion package 

1.  Have been moved into **com.groupdocs.conversion.legacy** package
2.  Marked as **Obsolete** with message: *This interface/class/enumeration is obsolete and will be available till April 2020 (v20.4).*

#### Full list of types that have been moved and marked as obsolete:

1.  com.groupdocs.conversion.config.ConversionConfig => com.groupdocs.conversion.legacy.config.ConversionConfig
2.  com.groupdocs.conversion.domain.CacheFileDescription => com.groupdocs.conversion.legacy.domain.CacheFileDescription
3.  com.groupdocs.conversion.domain.ConversionType => com.groupdocs.conversion.legacy.domain.ConversionType
4.  com.groupdocs.conversion.domain.FileDescription => com.groupdocs.conversion.legacy.domain.FileDescription
5.  com.groupdocs.conversion.exceptions.CorruptOrDamagedFileException => com.groupdocs.conversion.legacy.exceptions.CorruptOrDamagedFileException
6.  com.groupdocs.conversion.exceptions.FileTypeNotSupportedException => com.groupdocs.conversion.legacy.exceptions.FileTypeNotSupportedException
7.  com.groupdocs.conversion.exceptions.GroupDocsException => com.groupdocs.conversion.legacy.exceptions.GroupDocsException
8.  com.groupdocs.conversion.exceptions.PasswordProtectedException => com.groupdocs.conversion.legacy.exceptions.PasswordProtectedException
9.  com.groupdocs.conversion.handler.Cache.ICacheDataHandler => com.groupdocs.conversion.legacy.handler.Cache.ICacheDataHandler
10.  com.groupdocs.conversion.handler.Input.IInputDataHandler => com.groupdocs.conversion.legacy.handler.Input.IInputDataHandler
11.  com.groupdocs.conversion.handler.Output.IOutputDataHandler => com.groupdocs.conversion.legacy.handler.Output.IOutputDataHandler
12.  com.groupdocs.conversion.handler.Temp.ITempDataHandler => com.groupdocs.conversion.legacy.handler.Temp.ITempDataHandler
13.  com.groupdocs.conversion.handler.CellsConversionCompleteEventArgs => com.groupdocs.conversion.legacy.handler.CellsConversionCompleteEventArgs
14.  com.groupdocs.conversion.handler.ConversionCompleteHandler => com.groupdocs.conversion.legacy.handler.ConversionCompleteHandler
15.  com.groupdocs.conversion.handler.ConversionCompleteEventArgs => com.groupdocs.conversion.legacy.handler.ConversionCompleteEventArgs
16.  com.groupdocs.conversion.handler.ConversionEventArgs => com.groupdocs.conversion.legacy.handler.ConversionEventArgs
17.  com.groupdocs.conversion.handler.ConversionHandler => com.groupdocs.conversion.legacy.handler.ConversionHandler
18.  com.groupdocs.conversion.handler.ConversionProgressHandler => com.groupdocs.conversion.legacy.handler.ConversionProgressHandler
19.  com.groupdocs.conversion.handler.ConversionProgressEventArgs => com.groupdocs.conversion.legacy.handler.ConversionProgressEventArgs
20.  com.groupdocs.conversion.handler.ConversionStartHandler => com.groupdocs.conversion.legacy.handler.ConversionStartHandler
21.  com.groupdocs.conversion.handler.ConversionStartEventArgs => com.groupdocs.conversion.legacy.handler.ConversionStartEventArgs
22.  com.groupdocs.conversion.handler.ConversionStatus => com.groupdocs.conversion.legacy.handler.ConversionStatus
23.  com.groupdocs.conversion.handler.ConvertedDocument => com.groupdocs.conversion.legacy.handler.ConvertedDocument
24.  com.groupdocs.conversion.handler.DocumentInfo => com.groupdocs.conversion.legacy.handler.DocumentInfo
25.  com.groupdocs.conversion.handler.IConversionProgressListener => com.groupdocs.conversion.legacy.handler.IConversionProgressListener
26.  com.groupdocs.conversion.handler.IConversionStatusListener => com.groupdocs.conversion.legacy.handler.IConversionStatusListener
27.  com.groupdocs.conversion.handler.ImageConversionCompleteEventArgs => com.groupdocs.conversion.legacy.handler.ImageConversionCompleteEventArgs
28.  com.groupdocs.conversion.handler.MarkupConversionCompleteEventArgs => com.groupdocs.conversion.legacy.handler.MarkupConversionCompleteEventArgs
29.  com.groupdocs.conversion.handler.PdfConversionCompleteEventArgs => com.groupdocs.conversion.legacy.handler.PdfConversionCompleteEventArgs
30.  com.groupdocs.conversion.handler.PresentationConversionCompleteEventArgs => com.groupdocs.conversion.legacy.handler.PresentationConversionCompleteEventArgs
31.  com.groupdocs.conversion.handler.SaveInfo => com.groupdocs.conversion.legacy.handler.SaveInfo
32.  com.groupdocs.conversion.handler.WordProcessingConversionCompleteEventArgs => com.groupdocs.conversion.legacy.handler.WordProcessingConversionCompleteEventArgs
33.  com.groupdocs.conversion.options.load.CadLoadOptions => com.groupdocs.conversion.legacy.options.load.CadLoadOptions
34.  com.groupdocs.conversion.options.load.CsvLoadOptions => com.groupdocs.conversion.legacy.options.load.CsvLoadOptions
35.  com.groupdocs.conversion.options.load.DiagramLoadOptions => com.groupdocs.conversion.legacy.options.load.DiagramLoadOptions
36.  com.groupdocs.conversion.options.load.EmailLoadOptions => com.groupdocs.conversion.legacy.options.load.EmailLoadOptions
37.  com.groupdocs.conversion.options.load.ImageLoadOptions => com.groupdocs.conversion.legacy.options.load.ImageLoadOptions
38.  com.groupdocs.conversion.options.load.LoadOptions => com.groupdocs.conversion.legacy.options.load.LoadOptions
39.  com.groupdocs.conversion.options.load.OneLoadOptions => com.groupdocs.conversion.legacy.options.load.OneLoadOptions
40.  com.groupdocs.conversion.options.load.PdfLoadOptions => com.groupdocs.conversion.legacy.options.load.PdfLoadOptions
41.  com.groupdocs.conversion.options.load.PresentationLoadOptions => com.groupdocs.conversion.legacy.options.load.PresentationLoadOptions
42.  com.groupdocs.conversion.options.load.SpreadsheetLoadOptions => com.groupdocs.conversion.legacy.options.load.SpreadsheetLoadOptions
43.  com.groupdocs.conversion.options.load.TxtLoadOptions => com.groupdocs.conversion.legacy.options.load.TxtLoadOptions
44.  com.groupdocs.conversion.options.load.WordProcessingLoadOptions => com.groupdocs.conversion.legacy.options.load.WordProcessingLoadOptions
45.  com.groupdocs.conversion.options.load.XmlLoadOptions => com.groupdocs.conversion.legacy.options.load.XmlLoadOptions
46.  com.groupdocs.conversion.options.save.ImageSaveOptions => com.groupdocs.conversion.legacy.options.save.ImageSaveOptions
47.  com.groupdocs.conversion.options.save.JpegOptions => com.groupdocs.conversion.legacy.options.save.JpegOptions
48.  com.groupdocs.conversion.options.save.MarkupSaveOptions => com.groupdocs.conversion.legacy.options.save.MarkupSaveOptions
49.  com.groupdocs.conversion.options.save.PdfFormattingOptions => com.groupdocs.conversion.legacy.options.save.PdfFormattingOptions
50.  com.groupdocs.conversion.options.save.PdfOptimizationOptions => com.groupdocs.conversion.legacy.options.save.PdfOptimizationOptions
51.  com.groupdocs.conversion.options.save.PdfOptions => com.groupdocs.conversion.legacy.options.save.PdfOptions
52.  com.groupdocs.conversion.options.save.PdfSaveOptions=> com.groupdocs.conversion.legacy.options.save.PdfSaveOptions
53.  com.groupdocs.conversion.options.save.PresentationSaveOptions => com.groupdocs.conversion.legacy.options.save.PresentationSaveOptions
54.  com.groupdocs.conversion.options.save.PsdOptions => com.groupdocs.conversion.legacy.options.save.PsdOptions
55.  com.groupdocs.conversion.options.save.RtfOptions => com.groupdocs.conversion.legacy.options.save.RtfOptions
56.  com.groupdocs.conversion.options.save.SaveOptions => com.groupdocs.conversion.legacy.options.save.SaveOptions
57.  com.groupdocs.conversion.options.save.SpreadsheetSaveOptions => com.groupdocs.conversion.legacy.options.save.SpreadsheetSaveOptions
58.  com.groupdocs.conversion.options.save.TiffOptions => com.groupdocs.conversion.legacy.options.save.TiffOptions
59.  com.groupdocs.conversion.options.save.WatermarkOptions => com.groupdocs.conversion.legacy.options.save.WatermarkOptions
60.  com.groupdocs.conversion.options.save.WebpOptions => com.groupdocs.conversion.legacy.options.save.WebpOptions
61.  com.groupdocs.conversion.options.save.WordProcessingBookmarksOptions=> com.groupdocs.conversion.legacy.options.save.WordProcessingBookmarksOptions
62.  com.groupdocs.conversion.options.save.WordProcessingSaveOptions => com.groupdocs.conversion.legacy.options.save.WordProcessingSaveOptions
