---
id: load-document-from-stream
url: conversion/java/load-document-from-stream
title: Load document from Stream
weight: 5
description: "This article demonstrates how to convert document presented as stream using GroupDocs.Conversion for Java API."
keywords: Convert document from stream, Convert file
productName: GroupDocs.Conversion for Java
hideChildren: False
---
There might be the case when your document is not physically located on the disk. Instead, you have the document in the form of a stream. In this case, to avoid the overhead of saving stream as a file on disk, [**GroupDocs.Conversion**](https://products.groupdocs.com/conversion/java) enables you to convert the file streams directly.

The following are the steps to be followed:

*   Specify the method to obtain document stream; 
*   Pass method's name to [Converter](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter) class constructor.

Following code snippet serves this purpose:

```java
try{
    Converter converter = new Converter(new FileInputStream("sample.docx"));
    PdfConvertOptions options = new PdfConvertOptions();

    converter.convert("converted.pdf", options);
} catch (Exception e){
    throw new GroupDocsConversionException(e.getMessage());
}
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