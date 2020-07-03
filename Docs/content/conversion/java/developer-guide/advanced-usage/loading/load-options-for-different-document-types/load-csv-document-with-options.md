---
id: load-csv-document-with-options
url: conversion/java/load-csv-document-with-options
title: Load CSV document with options
weight: 2
description: "Learn this article and check how to load and convert CSV documents with advanced options using GroupDocs.Conversion for Java API."
keywords: Load document, Load CSV document
productName: GroupDocs.Conversion for Java
hideChildren: False
---
GroupDocs.Conversion provides [CsvLoadOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/CsvLoadOptions) to give you control over how source CSV document will be processed. The following options could be set:

*   **[setSeparator](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/CsvLoadOptions#setSeparator(char))** -  specifies the delimiter 
*   **[setIsMultiEncoded](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/CsvLoadOptions#setMultiEncoded(boolean))** -  if *true*, means that the document contains several encodings     
*   **[hasFormula](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/CsvLoadOptions#hasFormula())** -  specifies that if text starts with "=" it should be parsed as a formula
*   **[setConvertNumericData](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/CsvLoadOptions#setConvertNumericData(boolean))** - specifies that strings with digits should be parsed as numbers
*   **[setConvertDateTimeData](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/CsvLoadOptions#setConvertDateTimeData(boolean))** - specifies that date/time string should be detected and parsed to DateTime
*   **[setEncoding](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/CsvLoadOptions#setEncoding(java.nio.charset.Charset))** - specifies the encoding to be used during load

### Control behavior of converting date/time and numeric data

The following code sample shows how to convert CSV document and control the way the date/time and numeric data have been processed:

```java
CsvLoadOptions loadOptions = new CsvLoadOptions();
loadOptions.setConvertDateTimeData(true);
loadOptions.setConvertNumericData(true);

Converter converter = new Converter("sample.csv", loadOptions);
PdfConvertOptions options = new PdfConvertOptions();
converter.convert("converted.pdf", options);
```

### Specify delimiter

The following code sample shows how to convert CSV document and specify the delimiter

```java
CsvLoadOptions loadOptions = new CsvLoadOptions();
loadOptions.setSeparator(',');

Converter converter = new Converter("sample.csv", loadOptions);
PdfConvertOptions options = new PdfConvertOptions();
converter.convert("converted.pdf", options);
```

### Specify encoding

The following code sample shows how to convert CSV document and specify the encoding

```java
CsvLoadOptions loadOptions = new CsvLoadOptions();
loadOptions.setEncoding(java.nio.charset.Charset.forName("shift_jis"));

Converter converter = new Converter("sample.csv", loadOptions);
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
