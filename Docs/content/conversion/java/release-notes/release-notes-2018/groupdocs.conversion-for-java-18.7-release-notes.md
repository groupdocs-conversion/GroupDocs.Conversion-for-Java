---
id: groupdocs-conversion-for-java-18-7-release-notes
url: conversion/java/groupdocs-conversion-for-java-18-7-release-notes
title: GroupDocs.Conversion for Java 18.7 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 18.7{{< /alert >}}

## Major Features

This is hotfix release:

*   Fixed: Missing properties in some options classes    
*   When convert email to pdf the email header is hidden now.
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONJAVA-542 | MailOption to control conversions from email | New Feature |
| CONVERSIONJAVA-544 | MSG to PDF conversion displays incorrect time in the header | Bug |

## Public API and Backward Incompatible Changes

### New EmailOptions in SaveOptions class

```java
/// <summary>
/// Email specific convert options
/// </summary>
public EmailOptions getEmailOptions()
```

Usage

```java
final String fileName = "source.msg";
 
ConversionConfig config = new ConversionConfig();
config.setOutputPath(".");
config.setStoragePath(".");
 
ConversionHandler handler = new ConversionHandler(config);
 
PdfSaveOptions options = new PdfSaveOptions();
EmailOptions emailOptions = options.getEmailOptions();
emailOptions.setDisplayHeader(true);
emailOptions.setDisplayEmailAddress(true);        
emailOptions.setDisplayFromEmailAddress(true);
emailOptions.setDisplayToEmailAddress(true);
emailOptions.setDisplayCcEmailAddress(true);
emailOptions.setDisplayBccEmailAddress(true);
         
ConvertedDocument result = handler.convert(fileName, options);
result.save("result.pdf");
```
