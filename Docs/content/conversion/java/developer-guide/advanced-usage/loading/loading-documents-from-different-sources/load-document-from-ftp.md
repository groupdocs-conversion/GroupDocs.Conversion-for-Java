---
id: load-document-from-ftp
url: conversion/java/load-document-from-ftp
title: Load document from FTP
weight: 3
description: "This article demonstrates how to convert document stored in FTP storage using GroupDocs.Conversion for Java API."
keywords: Convert document from FTP storage, Convert file
productName: GroupDocs.Conversion for Java
hideChildren: False
---
Following code snippet shows how to convert a document from FTP:

```java
package com.groupdocs.conversion.examples.advanced_usage.loading.loading_documents_from_different_sources;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.examples.Constants;
import com.groupdocs.conversion.exceptions.GroupDocsConversionException;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;
import org.apache.commons.net.ftp.FTPClient;
import java.io.File;
import java.io.InputStream;



/**
* This example demonstrates how to convert document downloaded from FTP.
*/
public class LoadDocumentFromFtp {
    public static void run()
    {
        String server = "ftp.example.com";
        String convertedFile = "C:\\output\\converted.pdf";   
        String filePath = "ftp://localhost/sample.doc";

        try {
            Converter converter = new Converter(getFileFromFtp(server, filePath));
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert(convertedFile, options);
        } 
        catch (Exception e){
            throw new GroupDocsConversionException(e.getMessage());
        }

        System.out.println("\nSource document converted successfully.\nCheck output in " + convertedFile);
    }

    private static InputStream getFileFromFtp(String server, String filePath) throws Exception
    {
        FTPClient client = new FTPClient();
        client.connect(server);
        return client.retrieveFileStream(filePath);
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