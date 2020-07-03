---
id: load-pdf-document-with-options
url: conversion/java/load-pdf-document-with-options
title: Load PDF document with options
weight: 5
description: "Learn this article and check how to load and convert PDF documents with advanced options using GroupDocs.Conversion for Java API."
keywords: Load document, Load and convert PDF document, Load and converi EPUB document, Load and convert XPS document
productName: GroupDocs.Conversion for Java
hideChildren: False
---
GroupDocs.Conversion provides [PdfLoadOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PdfLoadOptions) to give you control over how source PDF document will be processed. The following options could be set:

*   **[setFormat](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PdfLoadOptions#setFormat(com.groupdocs.conversion.filetypes.PdfFileType))** -  the document type is auto detected during loading, however you can specify explicitly the type of the source document. Available options are: *Pdf, Epub, Xps, Tex, Ps, Pcl*
*   **[setRemoveEmbeddedFiles](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PdfLoadOptions#getRemoveEmbeddedFiles())** -  specifies to remove embedded files from source document during conversion       
*   **[setPassword](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PdfLoadOptions#setPassword(java.lang.String))** -  password to unlock protected document
*   **[setHidePdfAnnotations](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PdfLoadOptions#setHidePdfAnnotations(boolean))** -  specifies that annotations in the source document must be hidden
*   **[setFlattenAllFields](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PdfLoadOptions#setFlattenAllFields(boolean))** - specifies that all fields in the source document will be flatten during conversion

### Flatten all fields

The following code sample shows how to convert PDF document and flatten all fields:

```java
 
PdfLoadOptions loadOptions = new PdfLoadOptions();
loadOptions.setFlattenAllFields(true);

Converter converter = new Converter("sample.pdf", loadOptions);
WordProcessingConvertOptions options = new WordProcessingConvertOptions();
converter.convert("converted.docx", options);
```

### Hide annotations

The following code sample shows how to convert PDF document and hide annotations:

```java
PdfLoadOptions loadOptions = new PdfLoadOptions();
loadOptions.setHidePdfAnnotations(true);

Converter converter = new Converter("sample.pdf", loadOptions);
WordProcessingConvertOptions options = new WordProcessingConvertOptions();
converter.convert("converted.docx", options);
```

### Remove embedded files

The following code sample shows how to convert PDF document and remove embedded files:

```java
PdfLoadOptions loadOptions = new PdfLoadOptions();
loadOptions.setRemoveEmbeddedFiles(true);

Converter converter = new Converter("sample.pdf", loadOptions);
WordProcessingConvertOptions options = new WordProcessingConvertOptions();
converter.convert("converted.docx", options);
```

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
In order to see a full potential of GroupDocs.Conversion, you are welcome to convert DOC to PDF, DOC to XLSX, PDF to DOC, PDF to XLSX, PPT to DOC and more with **[Free Online Document Converter App](https://products.groupdocs.app/conversion)** or get a full advantage of **[Free Online Document Converter Suite](https://conholdate.app/features/document-converter-online)** with advanced conversion settings and many more enterprise built-in features.
**Please note** that more [premium features](https://conholdate.app/features), advanced options and enhanced document management experience is available for signed-in users at [conholdate.app](https://conholdate.app/) for **FREE**.  
If you don't own an account yet, register it now for free! No credit card is required!