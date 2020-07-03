---
id: load-txt-document-with-options
url: conversion/java/load-txt-document-with-options
title: Load TXT document with options
weight: 8
description: "Learn this article and check how to load and convert text files with advanced options using GroupDocs.Conversion for Java API."
keywords: Load and convert text file, Load and convert TXT
productName: GroupDocs.Conversion for Java
hideChildren: False
---
GroupDocs.Conversion provides [TxtLoadOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/TxtLoadOptions) to give you control over how source text document will be processed. The following options could be set: 

*   **[setDetectNumberingWithWhitespaces](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/TxtLoadOptions#setDetectNumberingWithWhitespaces(boolean))** - allows to specify how numbered list items are recognized when plain text document is converted. If this option is set to false, lists recognition algorithm detects list paragraphs, when list numbers ends with either dot, right bracket or bullet symbols (such as "•", "\*", "-" or "o"). If this option is set to true, white spaces are also used as list number delimiters: list recognition algorithm for Arabic style numbering (1., 1.1.2.) uses both white spaces and dot (".") symbols.
*   **[setLeadingSpacesOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/TxtLoadOptions#setLeadingSpacesOptions(com.groupdocs.conversion.options.load.TxtLeadingSpacesOptions))** - specifies how leading spaces will be processed. The available options are: *ConvertToIdent, Preserve, Trim*
*   **[setTrailingSpacesOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/TxtLoadOptions#setTrailingSpacesOptions(com.groupdocs.conversion.options.load.TxtTrailingSpacesOptions))** - specifies how trailing spaces will be processed. The available options are: *Preserve, Trim*
*   **[setEncoding](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/TxtLoadOptions#setEncoding(java.nio.charset.Charset))** -  specifies encoding to be used to load the document

### Control behavior of processing leading spaces

The following code sample shows how to convert TXT document and control the way the leading spaces are processed:

```java
TxtLoadOptions loadOptions =  new TxtLoadOptions();
loadOptions.setLeadingSpacesOptions(TxtLeadingSpacesOptions.ConvertToIndent);
loadOptions.setDetectNumberingWithWhitespaces(true);

Converter converter = new Converter("sample.txt", loadOptions);
PdfConvertOptions options = new PdfConvertOptions();
converter.convert("converted.pdf", options);
```

### Control behavior of processing trailing spaces

The following code sample shows how to convert TXT document and the way the trailing spaces are processed:

```java
TxtLoadOptions loadOptions =  new TxtLoadOptions();
loadOptions.setTrailingSpacesOptions(TxtTrailingSpacesOptions.Trim);

Converter converter = new Converter("sample.txt", loadOptions);
PdfConvertOptions options = new PdfConvertOptions();
converter.convert("converted.pdf", options);
```

### Specify encoding

The following code sample shows how to convert TXT document and specify the encoding

```java
TxtLoadOptions loadOptions =  new TxtLoadOptions();
loadOptions.setEncoding(Charset.forName("shift_jis"));

Converter converter = new Converter("sample.txt", loadOptions);
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
