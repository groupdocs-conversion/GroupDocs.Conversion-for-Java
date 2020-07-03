---
id: migration-notes
url: conversion/java/migration-notes
title: Migration Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
### Why To Migrate?
  
Here are the key reasons to use the new updated API provided by GroupDocs.Conversion for Java since version 20.2:

*   **Converter** class introduced as a **single entry point** to manage the document conversion process to any supported file format (instead of **ConversionHander** class from previous versions).     
*   The overall **conversion speed improved** dramatically by saving each page as soon as it was converted, not when all pages list were converted.     
*   Product architecture was redesigned from scratch in order to **decreased memory usage** (from 10% to 400% approx. depending on document type).    
*   Document **convert options simplified** for easy control over document conversion and saving processes.  
   

### How To Migrate?

Here is a brief comparison of how to convert document into PDF format using old and new API.  

**Old coding style**

```java
String documentPath = "sample.docx";
String outputPath = "C:\\output\\converted.pdf";

//Instantiating the conversion handler
ConversionHandler conversionHandler = Common.getConversionHandler();

SaveOptions saveOptions = new PdfSaveOptions();
saveOptions.setConvertFileType(PdfFileType.Pdf);
 
ConvertedDocument convertedDocumentPath = conversionHandler.convert(documentPath , saveOptions);
convertedDocumentPath.save("C:\\output\\converted.pdf");
```

**New coding style**

```java
String documentPath = "C:\\sample.docx"; 
String outputPath = "C:\\output\\converted.pdf";
 
try(Converter converter = new Converter(documentPath))
{
    PdfConvertOptions convertOptions = new PdfConvertOptions();
    converter.Convert(outputPath, convertOptions);
}
```

For more code examples and specific use cases please refer to our [Developer Guide]({{< ref "conversion/java/developer-guide/_index.md" >}}) documentation or [GitHub](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java) samples and showcases.
