---
id: listening
url: conversion/java/listening
title: Listening
weight: 4
description: "Follow this guide and learn how to track conversion process by subscribing to specific events of GroupDocs.Conversion for Java API."
keywords: Track conversion process, Subscribe to conversion process events
productName: GroupDocs.Conversion for Java
hideChildren: False
---
In some cases there is the need to monitor conversion process and to receive update for start, progress and completion of a conversion. For such situations [**GroupDocs.Conversion**](https://products.groupdocs.com/conversion/java) expose extension point where the client application may hook up and receive updates.. 

To enable listening you have to:

*   Implement you own implementation of [IConverterListener](https://apireference.groupdocs.com/conversion/java/com.groupdocs.conversion.reporting/IConverterListener) interface.
*   Instantiate [ConverterSettings](https://apireference.groupdocs.com/conversion/java/com.groupdocs.conversion/ConverterSettings) class and pass an instance of the class created in first step
*   Pass [ConverterSettings](https://apireference.groupdocs.com/conversion/java/com.groupdocs.conversion/ConverterSettings) object factory to constructor of a [Converter](https://apireference.groupdocs.com/conversion/java/com.groupdocs.conversion/Converter) class.
*   Call [Convert](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter#convert(java.lang.String,%20com.groupdocs.conversion.options.convert.ConvertOptions))method of [Converter](https://apireference.groupdocs.com/conversion/java/com.groupdocs.conversion/Converter) class.

Here is a code that demonstrates how to enable listening for GroupDocs.Conversion.

```java
public class ConverterListener implements IConverterListener
{
    public void started()
    {
        System.out.println("Conversion started...");
    }
    public void progress(byte current)
    {
        System.out.println($"... " + current + "% ...");
    }
    public void completed()
    {
        System.out.println("... conversion completed");
    }
}
```

```java
IConverterListener listener = new ConverterListener();
ConverterSettings settingsFactory = new ConverterSettings
{
    Listener = listener
};
try(Converter converter = new Converter("sample.docx", settingsFactory))
{
    PdfConvertOptions options = new PdfConvertOptions();
    converter.convert("converted.pdf", options);
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
