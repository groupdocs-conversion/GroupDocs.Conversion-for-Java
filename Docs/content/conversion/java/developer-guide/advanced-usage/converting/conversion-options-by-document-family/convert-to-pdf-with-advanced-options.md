---
id: convert-to-pdf-with-advanced-options
url: conversion/java/convert-to-pdf-with-advanced-options
title: Convert to PDF with advanced options
weight: 3
description: "Follow this guide and learn how to convert documents to PDF with height, width, DPI, margins and other customizations using GroupDocs.Conversion for Java."
keywords: Convert PDF, Convert to PDF/A
productName: GroupDocs.Conversion for Java
hideChildren: False
---
[GroupDocs.Conversion](https://products.groupdocs.com/conversion/java) provides [PdfConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions) to give you control over conversion result when convert to PDF. Along with [common convert options](https://apireference.groupdocs.com/conversion/java/com.groupdocs.conversion.options.convert/ConvertOptions)  [PdfConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions) has the following additional options:

*   [setFormat](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/ConvertOptions#setFormat(com.groupdocs.conversion.filetypes.FileType)) -  desired result document type. Available options are: *Pdf, Epub, Xps, Tex, Ps, Pcl*
*   [setWidth](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions#setWidth(int)) -  desired image width after conversion
*   [setHeight](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions#setHeight(int)) -  desired image height after conversion
*   [setDpi](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions#setDpi(double)) -  desired page DPI after conversion
*   [setPassword](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions#setPassword(java.lang.String)) -  if set the converted document will be protected with specified password
*   [setMarginTop](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions#setMarginTop(int)) -  desired page top margin after conversion
*   [setMarginBottom](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions#setMarginBottom(int)) -  desired page bottom margin after conversion
*   [setMarginLeft](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions#setMarginLeft(int)) -  desired page left margin after conversion
*   [setMarginRight](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions#setMarginRight(int)) -  desired page right margin after conversion
*   [setPdfOptions](https://apireference.groupdocs.com/conversion/java/com.groupdocs.conversion.options.convert/PdfConvertOptions#setPdfOptions(com.groupdocs.conversion.options.convert.PdfOptions)) -  PDF specific convert options
*   [setRotate](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions#setRotate(com.groupdocs.conversion.options.convert.Rotation)) -  page rotation. Available options are: *None, On90, On180, On270*  
          

Following code snippet shows how to convert to PDF with advanced options

```java
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
loadOptions.setPassword("12345");

Converter converter = new Converter("sample.docx");
PdfConvertOptions options = new PdfConvertOptions();
options.setPageNumber(2);
options.setPagesCount(1);
options.setRotate(Rotation.On180);
options.setDpi(300);
options.setWidth(1024);
options.setHeight(768);

converter.convert("converted.pdf", options);
```

### PdfOptions

[PdfOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptions) class provides specific options when converting document to different versions of PDF format.

*   [setPdfFormat](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptions#setPdfFormat(com.groupdocs.conversion.options.convert.PdfFormats)) - sets pdf format of the converted document. Available options are: *Default, PdfA\_1A, PdfA\_1B, PdfA\_2A, PdfA\_3A, PdfA2B, PdfA\_2U, PdfA\_3B, PdfA\_3U, v1\_3, v1\_4, v1\_5, v1\_6, v1\_7, PdfX\_1A, PdfX\_3*
*   [setRemovePdfACompliance](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptions#setRemovePdfACompliance(boolean)) - removes Pdf-A compliance
*   [setZoom](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptions#setZoom(int)) - specifies the zoom level in percentage
*   [setLinearize](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptions#setLinearize(boolean)) - linearizes PDF document for web
*   [setGrayscale](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptions#setGrayscale(boolean)) - convert to grayscale PDF
*   [setOptimizationOptions](https://apireference.groupdocs.com/conversion/java/com.groupdocs.conversion.options.convert/PdfOptions#setOptimizationOptions(com.groupdocs.conversion.options.convert.PdfOptimizationOptions)) - PDF optimization options
*   [setFormattingOptions](https://apireference.groupdocs.com/conversion/java/com.groupdocs.conversion.options.convert/PdfOptions#setFormatingOptions(com.groupdocs.conversion.options.convert.PdfFormattingOptions)) - PDF formatting options

### PdfOptimizationOptions

[PdfOptimizationOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptimizationOptions) class allows to specify options for adjusting PDF conversion process and improve its speed.

*   [setLinkDuplicateStreams](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptimizationOptions#setLinkDuplicateStreams(boolean)) - link duplicate streams
*   [setRemoveUnusedObjects](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptimizationOptions#setRemoveUnusedObjects(boolean)) - remove unused objects
*   [setCompressImages](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptimizationOptions#setCompressImages(boolean)) - if set to *true*, all images in the document are re-compressed. The amount of compression and image quality are defined by the [setImageQuality](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptimizationOptions#setImageQuality(int))
*   [setImageQuality](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptimizationOptions#setImageQuality(int)) -  value in percent where 100% is unchanged quality and image size. To decrease the image size set this property to less than 100
*   [setUnembedFonts](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfOptimizationOptions#setUnembedFonts(boolean)) - make fonts not embedded

### PdfFormattingOptions

[PdfFormattingOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions) class provides different options to change PDF document look.

*   [setCenterWindow](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions#setCenterWindow(boolean)) - specifies whether position of the document's window will be centered on the screen
*   [setDirection](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions#setDirection(com.groupdocs.conversion.options.convert.PdfDirection)) - sets reading order of text: L2R (left to right) or R2L (right to left). Available options are: *L2R, R2L*
*   [setDisplayDocTitle](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions#setDisplayDocTitle(boolean)) - specifies whether document's window title bar should display document title
*   [setFitWindow](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions#setFitWindow(boolean)) - specifies whether document window must be resized to fit the first displayed page
*   [setHideMenuBar](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions#setHideMenuBar(boolean)) - specifies whether menu bar should be hidden when document is active
*   [setHideToolBar](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions#setHideToolBar(boolean)) - specifies whether toolbar should be hidden when document is active
*   [setHideWindowUI](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions#setHideWindowUI(boolean)) - specifies whether user interface elements should be hidden when document is active
*   [setNonFullScreenPageMode](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions#setNonFullScreenPageMode(com.groupdocs.conversion.options.convert.PdfPageMode)) - specifying how to display the document on exiting full-screen mode. Available options are: *UseNone, UseOutlines, UseThumbs, FullScreen, UseOC, UseAttachments*
*   [setPageLayout](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions#setPageLayout(com.groupdocs.conversion.options.convert.PdfPageLayout)) - sets page layout which shall be used when the document is opened. Available options are: *Default, SinglePage, OneColumn, TwoColumnLeft, TwoColumnRight, TwoPagesLeft, TwoPagesRight*
*   [setPageMode](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfFormattingOptions#setPageMode(com.groupdocs.conversion.options.convert.PdfPageMode)) - specifying how document should be displayed when opened

## More resources

### GitHub Examples
You may easily run the code above and see the feature in action in our GitHub examples:
*   [GroupDocs.Conversion for .NET examples, plugins, and showcase](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-.NET)    
*   [GroupDocs.Conversion for Java examples, plugins, and showcase](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java)    
*   [Document Conversion for .NET MVC UI Example](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-.NET-MVC)     
*   [Document Conversion for .NET App WebForms UI Modern Example](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-.NET-WebForms)    
*   [Document Conversion for Java App Dropwizard UI Modern Example](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java-Dropwizard)    
*   [Document Conversion for Java Spring UI Example](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java-Spring)   

### Free Online Document Converter Apps
Along with full-featured Java library we provide free Apps and free services for document conversion.
In order to see a full potential of GroupDocs.Conversion, you are welcome to convert DOC to PDF, DOC to XLSX, PDF to DOC, PDF to XLSX, PPT to DOC and more with [Free Online Document Converter App](https://products.groupdocs.app/conversion) or get a full advantage of [Free Online Document Converter Suite](https://conholdate.app/features/document-converter-online) with advanced conversion settings and many more enterprise built-in features.
**Please note** that more [premium features](https://conholdate.app/features), advanced options and enhanced document management experience is available for signed-in users at [conholdate.app](https://conholdate.app/) for **FREE**.  
If you don't own an account yet, register it now for free! No credit card is required!