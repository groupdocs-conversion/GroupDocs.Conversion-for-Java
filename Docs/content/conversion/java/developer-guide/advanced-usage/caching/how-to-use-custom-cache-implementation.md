---
id: how-to-use-custom-cache-implementation
url: conversion/java/how-to-use-custom-cache-implementation
title: How to use custom cache implementation
weight: 1
description: "Follow this guide and learn how to implement custom cache implementation when document with GroupDocs.Conversion for Java API."
keywords: Custom cache for GroupDocs.Conversion
productName: GroupDocs.Conversion for Java
hideChildren: False
---
[**GroupDocs.Conversion**](https://products.groupdocs.com/conversion/java) implements caching to local drive out of the box. For flexibility GroupDocs.Conversion provides and extension point which allows you to cache conversion result in your own way. You can do this by using [ICache](https://apireference.groupdocs.com/annotation/java/com.groupdocs.annotation.cache/ICache) interface implementation.  
Let's see how to implement some custom cache implementation using this extension point.

## Using Redis cache

The following steps should be followed.

*   Create *RedisCache* class which implements [ICache](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.caching/ICache) interface.
*   Instantiate the *RedisCache* class.
*   Declare a delegate which will be used from [Converter](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter) class as factory of [ConverterSettings](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/ConverterSettings). In the body of this delegate, instantiate [ConverterSettings](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/ConverterSettings) class and set property [setCache](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/ConverterSettings#setCache(com.groupdocs.conversion.caching.ICache)) with the *RedisCache* class instance from previous step.
*   Instantiate [Converter](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter) class with path to source document and the delegate from the previous step as constructor's parameters.
*   Create instance of [PdfConvertOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.convert/PdfConvertOptions) class.
*   Call [Convert](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter#convert(java.lang.String,%20com.groupdocs.conversion.options.convert.ConvertOptions)) method of [Converter](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion/Converter) instance.

Below is the code that demonstrates how to use custom caching for GroupDocs.Conversion:

```java
package com.groupdocs.conversion.examples.advanced_usage.caching;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.ConverterSettings;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.internal.c.a.ms.System.Diagnostics.Stopwatch;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

public class HowToUseCustomCacheImplementation {
    /**
    * This example demonstrates how to implement custom cache when rendering document.
    */
    public static void run()
    {
        String outputDirectory = Constants.getOutputDirectoryPath(null);

        RedisCache cache = new RedisCache(/*"sample_"*/);
        ConverterSettings settingsFactory = new ConverterSettings();
        settingsFactory.setCache(cache);

        Converter converter = new Converter(Constants.SAMPLE_DOCX, settingsFactory);
        PdfConvertOptions options = new PdfConvertOptions();

        Stopwatch stopWatch = Stopwatch.startNew();
        converter.convert("converted.pdf", options);
        stopWatch.stop();

        System.out.print(String.format("Time taken on first call to Convert method %d (ms).", stopWatch.getElapsedMilliseconds()));

        stopWatch.restart();
        converter.convert("converted-1.pdf", options);
        stopWatch.stop();

        System.out.print(String.format("Time taken on second call to Convert method %d (ms).", stopWatch.getElapsedMilliseconds()));
    }
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
