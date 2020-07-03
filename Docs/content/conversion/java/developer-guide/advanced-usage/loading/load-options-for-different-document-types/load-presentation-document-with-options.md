---
id: load-presentation-document-with-options
url: conversion/java/load-presentation-document-with-options
title: Load Presentation document with options
weight: 6
description: "Learn this article and check how to load and convert Microsoft PowerPoint documents with advanced options using GroupDocs.Conversion for Java API."
keywords: Load document, Load and convert PowerPoint document, Load and convert PPTX presentation, Load and convert PPT
productName: GroupDocs.Conversion for Java
hideChildren: False
---
GroupDocs.Conversion provides [PresentationLoadOptions](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PresentationLoadOptions) to give you control over how source presentation document will be processed. The following options could be set:

*   **[setFormat](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PresentationLoadOptions#setFormat(com.groupdocs.conversion.filetypes.PresentationFileType))** -  the document type is auto detected during loading, however you can specify explicitly the type of the source presentation document. Available options are: *Ppt, Pps, Pptx, Ppsx, Odp, Otp, Potx, Pot, Potm, Pptm, Ppsm*
*   **[setDefaultFont](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PresentationLoadOptions#setDefaultFont(java.lang.String))** -  default font for rendering the presentation. The following font will be used if a presentation font is missing.      
*   **[setFontSubstitutes](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PresentationLoadOptions#setFontSubstitutes(java.util.List))** -  substitute specific fonts from the source presentation document
*   **[setPassword](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PresentationLoadOptions#setPassword(java.lang.String))** -  password to unlock protected document
*   **[setHideComments](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PresentationLoadOptions#setHideComments(boolean))** - specifies that comments from source presentation must be hidden during conversion
*   **[setShowHiddenSlides](https://apireference.groupdocs.com/java/conversion/com.groupdocs.conversion.options.load/PresentationLoadOptions#setShowHiddenSlides(boolean))** - specifies that hidden slides should be included in converted document

### Hide comments

The following code sample shows how to convert Presentation document and hide comments:

```java
PresentationLoadOptions loadOptions = new PresentationLoadOptions();
loadOptions.setHideComments(true);

Converter converter = new Converter("sample.pptx", loadOptions);
PdfConvertOptions options = new PdfConvertOptions();
converter.convert("converted.pdf", options);
```

### Specify font substitutions

The following code sample shows how to convert Presentation document and specify font substitutions for missing fonts:

```java
PresentationLoadOptions loadOptions = new PresentationLoadOptions();

List<FontSubstitute> fontSubstitutes = new ArrayList<FontSubstitute>();
fontSubstitutes.add(FontSubstitute.create("Tahoma", "Arial"));
fontSubstitutes.add(FontSubstitute.create("Times New Roman", "Arial"));
loadOptions.setDefaultFont("Helvetica");
loadOptions.setFontSubstitutes(fontSubstitutes);

Converter converter = new Converter("sample.pptx", loadOptions);
PdfConvertOptions options = new PdfConvertOptions();
converter.convert("converted.pdf", options);
```

### Include hidden slides

The following code sample shows how to convert Presentation document including the hidden slides:

```java
PresentationLoadOptions loadOptions = new PresentationLoadOptions();
loadOptions.setShowHiddenSlides(true);

Converter converter = new Converter("sample.pptx", loadOptions);
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