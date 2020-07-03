---
id: convert-to-image
url: conversion/java/convert-to-image
title: Convert to Image
weight: 2
description: "Learn this article and check how to convert documents to JPG, convert documents to PNG, convert documents to TIFF or any supported image format with several lines of Java code and GroupDocs.Conversion for Java."
keywords: Convert to Image, Convert to JPG, Convert to PNG, Convert to PSD, Convert to TIFF
productName: GroupDocs.Conversion for Java
hideChildren: False
---
[**GroupDocs.Conversion**](https://products.groupdocs.com/conversion/java)can convert any source document to the following image formats: *Tiff, Tif, Jpg, Jpeg, Png, Gig, Bmp, Ico, Psd, Wmf, Emf, Dcm, Webp, Dng, Svg, Jp2, Odg, J2c, J2k, Jpx, Jpf, Jpm, Eps, Cgm, Cdr, Cmx, Dib, Jpc, Jls, DjVu.* When just instantiate the [ImageConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/ImageConvertOptions) class without specifying the target format explicitly, *Jpg* will be used as a default format.

Conversion to image format could be triggered by following below steps:

*   Create new instance of [Converter](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter) class and pass source document path as a constructor parameter
*   Instantiate [ImageConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/ImageConvertOptions) class.
*   Call setFormatmethod of the [ImageConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/ImageConvertOptions) instance to specify the desired image format
*   Declare output stream each document page will be stored. This delegate will be called for each page during conversion.
*   Call [Convert](https://apireference.groupdocs.com/net/conversion/groupdocs.conversion/converter/methods/convert/2) method of [Converter](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter) class instance and pass the declared output stream and the instance of [ImageConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/ImageConvertOptions) from the previous two steps

## Conversion to JPG

The following code show how to convert any document to JPG. 

```java
String outputFileTemplate = new File(outputFolder, "converted-page-%d.jpg").getPath();

try (FileOutputStream getPageStream = new FileOutputStream(String.format(outputFileTemplate, 1))) {

    Converter converter = new Converter("sample.pdf");

    ImageConvertOptions options = new ImageConvertOptions();
    options.setFormat(ImageFileType.Jpg);
    options.setPagesCount(1);

    converter.convert(getPageStream, options);
} catch (IOException e) {
    System.out.println(e.getMessage());
}
```

## Conversion to PNG

The following code show how to convert any document to PNG. 

```java
String outputFileTemplate = new File(outputFolder, "converted-page-%d.png").getPath();

try(FileOutputStream getPageStream = new FileOutputStream(String.format(outputFileTemplate, 1))) {

    Converter converter = new Converter("sample.pdf");
    ImageConvertOptions options = new ImageConvertOptions();
    options.setFormat(ImageFileType.Png);
    options.setPagesCount(1);
    converter.convert(getPageStream, options);
} catch (IOException e) {
    System.out.println(e.getMessage());
}
```

## Conversion to PSD

The following code show how to convert any document to PSD. 

```java
String outputFileTemplate = new File(outputFolder, "converted-page-%d.psd").getPath();

try(FileOutputStream getPageStream = new FileOutputStream(String.format(outputFileTemplate, 1))) {

    Converter converter = new Converter("sample.pdf");
    ImageConvertOptions options = new ImageConvertOptions();
    options.setFormat(ImageFileType.Psd);
    options.setPagesCount(1);
    converter.convert(getPageStream, options);
} catch (IOException e ){
    System.out.println(e.getMessage());
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