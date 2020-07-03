---
id: get-possible-conversions
url: conversion/java/get-possible-conversions
title: Get possible conversions
weight: 1
description: "This article explains how to obtain supported conversions when convert documents with GroupDocs.Conversion within your Java applications"
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
**[GroupDocs.Conversion](https://products.groupdocs.com/conversion/java)** allows to get possible conversions for a provided source document by following the below steps:

*   Create new instance of [Converter](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter) class by passing source document path as constructor's parameter
*   Call [GetPossibleConversions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter#getPossibleConversions()) method of converter object

The following code sample demonstrates how to get possible conversions of the source document:

```java
String sourceFile = "sample.docx";
Converter converter = new Converter(sourceFile);

PossibleConversions conversions = converter.getPossibleConversions();

System.out.print(String.format("%s is of type %s and could be converted to:\n",
        Constants.SAMPLE_DOCX, conversions.getSource().getExtension()));

for (Pair<FileType, Boolean> conversion : conversions.getAll()) {
    System.out.print(String.format("\t %s as %s conversion.\n", conversion.getKey().getExtension(), conversion.getValue() ? "primary" : "secondary"));
}
```

## More resources
### Advanced Usage Topics
To learn more about document viewing features, please refer to the [advanced usage section]({{< ref "conversion/java/developer-guide/advanced-usage/_index.md" >}}).

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
