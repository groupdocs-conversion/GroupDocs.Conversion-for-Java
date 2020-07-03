---
id: add-watermark
url: conversion/java/add-watermark
title: Add watermark
weight: 1
description: "Following this article you will learn how to apply watermark to document pages when convert document with GroupDocs.Conversion for Java API."
keywords: Apply watermark to converted document, Watermark document, Add page watermark
productName: GroupDocs.Conversion for Java
hideChildren: False
---
[**GroupDocs.Conversion**](https://products.groupdocs.com/conversion/java) allows you to apply a watermark to the converted document.  You can set the following options for controlling how the watermark will be stamped in the converted document:

### WatermarkOptions

*   **[Text](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions#getText())** -  watermark text
*   **[Font](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions#getFont())** -  watermark font name
*   **[Color](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions#getColor())** - watermark color
*   **[Width](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions#getWidth())** - watermark width
*   **[Height ](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions#getHeight())** -  watermark height
*   **[Top](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions#getTop())** -  watermark top position
*   **[Left ](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions#getLeft())** - watermark left position
*   **[RotationAngle](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions#getRotationAngle())** -  watermark rotation angle
*   **[Transparency](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions#getTransparency())** -  watermark transparency
*   **[Background](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions#getBackground())** -  specifies that the watermark is stamped as background. If the value is true, the watermark is laid at the bottom. By default is false and the watermark is laid on top.

  

Here are the steps to follow:

*   Create new instance of [Converter](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter) class and pass source document path as a constructor parameter
*   Instantiate the proper [ConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/ConvertOptions) class e.g. (**[PdfConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions)**, **[WordProcessingConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WordProcessingConvertOptions)**, **[SpreadsheetConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/SpreadsheetConvertOptions)** etc.)
*   Create new instance of [WatermarkOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions) class. Set needed properties to specify the watermark color, width, height, text, image etc.
*   Set [Watermark](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/ConvertOptions#setWatermark(com.groupdocs.conversion.options.convert.WatermarkOptions))property of the [ConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/ConvertOptions) instance with the instance of [WatermarkOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/WatermarkOptions) class created in the previous step 
*   Call [convert](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter#convert(java.lang.String,%20com.groupdocs.conversion.options.convert.ConvertOptions)) method of [Converter](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter) class instance and pass filename for the converted document and the instance of [ConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/ConvertOptions) from the previous step

Following code snippet shows how to apply watermark to the output document:

```java
Converter converter = new Converter("sample.docx");
PdfConvertOptions options = new PdfConvertOptions();

WatermarkOptions watermark = new WatermarkOptions();
watermark.setText("Sample watermark");
watermark.setColor(Color.red);
watermark.setWidth(100);
watermark.setHeight(100);
watermark.setBackground(true);

options.setWatermark(watermark);

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
