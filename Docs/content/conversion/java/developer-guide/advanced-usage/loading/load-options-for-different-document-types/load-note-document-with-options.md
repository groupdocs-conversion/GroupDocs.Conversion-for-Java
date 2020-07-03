---
id: load-note-document-with-options
url: conversion/java/load-note-document-with-options
title: Load Note document with options
weight: 4
description: "Learn this article and check how to load and convert Microsoft OneNote documents with advanced options using GroupDocs.Conversion for Java API."
keywords: Load document, Load Microsoft OneNote document
productName: GroupDocs.Conversion for Java
hideChildren: False
---
GroupDocs.Conversion provides [NoteLoadOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/NoteLoadOptions) to give you control over how source Note document will be processed. The following options could be set:

*   **[setDefaultFont](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/NoteLoadOptions#setDefaultFont(java.lang.String))** -  default font for Note document. The specified font will be used if a font is missing
*   **[setFontSubstitutes](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/NoteLoadOptions#setFontSubstitutes(java.util.List))** -  substitutes specific fonts from the Note document
*   **[setPassword](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/NoteLoadOptions#setPassword(java.lang.String))** - password to unlock protected document

### Specify font substitution

The following code sample shows how to convert Note document and specify font substitution for missing fonts:

```java
NoteLoadOptions loadOptions = new NoteLoadOptions();

List<FontSubstitute> fontSubstitutes = new ArrayList<FontSubstitute>();
fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
loadOptions.setFontSubstitutes(fontSubstitutes);
loadOptions.setDefaultFont("Helvetica");

Converter converter = new Converter("sample.one", loadOptions);
PdfConvertOptions options = new PdfConvertOptions();
converter.convert("converted.pdf", options);
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
