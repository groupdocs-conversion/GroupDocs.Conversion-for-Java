---
id: convert-to-html-with-advanced-options
url: conversion/java/convert-to-html-with-advanced-options
title: Convert to HTML with advanced options
weight: 1
description: "Follow this guide and learn how to convert documents to HTML format with fixed layout, zoom and other customizations using GroupDocs.Conversion for Java."
keywords: Convert to HTML, Convert HTML
productName: GroupDocs.Conversion for Java
hideChildren: False
---
**[GroupDocs.Conversion](https://products.groupdocs.com/conversion/java)** provides [MarkupConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/MarkupConvertOptions) to give you control over conversion result. The following options could be set:
*   [setFixedLayout](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/MarkupConvertOptions#setFixedLayout(boolean)) - controls the html generation. If it's set to *true*, fixed layout will be used e.g. absolutely positioned html element. 
*   [setZoom](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/MarkupConvertOptions#setZoom(int)) - specifies the zoom level in percentage. Default is 100.      
*   [setUsePdf](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/MarkupConvertOptions#setUsePdf(boolean)) - in some cases, for better rendering and elements positioning the source document should be converted to PDF first. If this property is set to *true*, the input firstly is converted to PDF and after that to desired format.  
    

 Following code snippet shows how to convert to HTML with advanced options

```java
WordProcessingLoadOptions loadOptions = new WordProcessingLoadOptions();
loadOptions.setPassword("12345");

Converter converter = new Converter("sample.docx", loadOptions);
MarkupConvertOptions options = new MarkupConvertOptions();
options.setPageNumber(2);
options.setFixedLayout(true);
options.setPagesCount(1);

converter.convert("converted.html", options);
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
