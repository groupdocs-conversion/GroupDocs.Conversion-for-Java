---
id: load-email-document-with-options
url: conversion/java/load-email-document-with-options
title: Load Email document with options
weight: 3
description: "Learn this article and check how to load and convert Email documents with advanced options using GroupDocs.Conversion for Java API."
keywords: Load document, Load Email document
productName: GroupDocs.Conversion for Java
hideChildren: False
---
GroupDocs.Conversion provides [EmailLoadOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/EmailLoadOptions) to give you control over how source email document will be processed. The following options could be set:

*   **[**set**Format](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/EmailLoadOptions#setFormat(com.groupdocs.conversion.filetypes.EmailFileType))** -  the document type is auto detected during loading, however you can specify explicitly the type of the source email document. Available options are: Msg, Eml, Emlx, Pst, Ost, Vcf, Mht 
*   **[**setD**isplayHeader](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/EmailLoadOptions#setDisplayHeader(boolean))** -  option to display or hide the email header      
*   **[**setD**isplayFromEmailAddress](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/EmailLoadOptions#setDisplayFromEmailAddress(boolean))** -  option to display or hide "from" email address
*   **[**setD**isplayEmailAddress](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/EmailLoadOptions#setDisplayEmailAddress(boolean))** - option to display or hide email address
*   **[**setD**isplayToEmailAddress](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/EmailLoadOptions#setDisplayToEmailAddress(boolean))** - option to display or hide "to" email address
*   **[**setD**isplayCcEmailAddress](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/EmailLoadOptions#setDisplayCcEmailAddress(boolean))** - option to display or hide "Cc" email address
*   **[setDisplayBccEmailAddress](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/EmailLoadOptions#setDisplayBccEmailAddress(boolean))** -  option to display or hide "Bcc" email address

### Control fields visibility

The following code sample shows how to convert Email document and control the fields visibility:

```java
EmailLoadOptions loadOptions = new EmailLoadOptions();
loadOptions.setDisplayHeader(false);
loadOptions.setDisplayFromEmailAddress(false);
loadOptions.setDisplayToEmailAddress(false);
loadOptions.setDisplayEmailAddress(false);
loadOptions.setDisplayCcEmailAddress(false);
loadOptions.setDisplayBccEmailAddress(false);

Converter converter = new Converter("sample.msg", loadOptions);
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