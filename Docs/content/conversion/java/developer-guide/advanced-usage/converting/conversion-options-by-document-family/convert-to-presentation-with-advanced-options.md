---
id: convert-to-presentation-with-advanced-options
url: conversion/java/convert-to-presentation-with-advanced-options
title: Convert to Presentation with advanced options
weight: 4
description: "Follow this guide and learn how to convert documents to PowerPoint presentations of PPT, PPTX formats with height, width, DPI, margins and other customizations using GroupDocs.Conversion for Java."
keywords: Convert to Presentation, Convert Presentation
productName: GroupDocs.Conversion for Java
hideChildren: False
---
[**GroupDocs.Conversion**](https://products.groupdocs.com/conversion/java) provides [PresentationConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PresentationConvertOptions) to give you control over conversion result when convert to presentation format. Along with [common convert options]({{< ref "conversion/java/developer-guide/advanced-usage/converting/conversion-options-by-document-family/convert-to-presentation-with-advanced-options.md" >}}) from base class [PresentationConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PresentationConvertOptions) has the following additional options:

*   ********[setFormat](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/ConvertOptions#setFormat(com.groupdocs.conversion.filetypes.FileType))******** -  desired result document type. Available options are: *Ppt, Pps, Pptx, Ppsx, Odp, Otp, Potx, Pot, Potm, Pptm, Ppsm*
*   **[setPassword](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PresentationConvertOptions#setPassword(java.lang.String))** -  if set, the converted document will be password protected with the specified password
*   **[setZoom](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PresentationConvertOptions#setZoom(int))** -  specifies the zoom level in percentage

Following code snippet shows how to convert to Presentation with advanced options

```java
Converter converter = new Converter("sample.docx");
PresentationConvertOptions options = new PresentationConvertOptions();
options.setPageNumber(2);
options.setPagesCount(1);
options.setFormat(PresentationFileType.Ppt);
converter.convert("converted.ppt", options);
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
