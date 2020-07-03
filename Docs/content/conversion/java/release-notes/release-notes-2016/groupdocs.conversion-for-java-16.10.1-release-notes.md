---
id: groupdocs-conversion-for-java-16-10-1-release-notes
url: conversion/java/groupdocs-conversion-for-java-16-10-1-release-notes
title: GroupDocs.Conversion for Java 16.10.1 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 16.10.1{{< /alert >}}

## Major Features

There are 25 new features in this regular monthly release. The most notable are:

*   Detecting document type from streams.
*   Document conversion progress.
*   When converting to PDF return each page in separate stream
*   When converting to HTML return each page in separate stream
*   Place watermark in the converted document
*   Add support for converting to PSD format
*   Add support for converting from PSD format
*   Introducing two public interfaces IConversionProgressListener and IConversionStatusListener
*   Implement ConversionCompleted event with conversion details
*   Show grid lines when converting Excel files
*   Show hidden sheets when converting Excel files
*   Return conversion guid in ConversionProgressEventArgs
*   Conversion of SVG documents
*   Conversion of XPS documents
*   Conversion of ICO documents
*   When converting to Slides, option for removing slides comments
*   Fixed XLSX to PNG/JPG/HTML conversion
*   Respecting DPI option when converting to image
*   Conversion of Html to image
*   When converting from word, option for hide/show tracked changes in the converted document
*   Fixed respecting dpi setting when converting image to image 
*   Fixed respecting dpi setting when converting diagram to image
*   Converting from CAD documents to Cells, Html, Image, Pdf, Slides and Words
*   Setting default fonts to be used when converting from Slides if used font do not exist in the system
*   FixedLayout option when converting Word and Pdf to Html
*   Setting default Fonts

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-680 | Implement document conversion from stream with auto detect source file type | New Feature |
| CONVERSIONNET-662 | Autodetect source document type when converting from stream | New Feature |
| CONVERSIONNET-655 | Report conversion progress | New Feature |
| CONVERSIONNET-654 | Return all supported conversions types with single method | New Feature |
| CONVERSIONNET-684 | When converting to PDF return each page in separate stream | New Feature |
| CONVERSIONNET-685 | When converting to HTML return each page in separate stream | New Feature |
| CONVERSIONNET-723 | Place watermark in the converted document | New Feature |
| CONVERSIONNET-724 | Add support for converting to PSD format | New Feature |
| CONVERSIONNET-725 | Add support for converting from PSD format | New Feature |
| CONVERSIONNET-789 | Implement ConversionCompleted event with conversion details | New Feature |
| CONVERSIONNET-807 | ConversionStart event | New Feature |
| CONVERSIONNET-812 | Introducing two public interfaces IConversionProgressListener and IConversionStatusListener | New Feature |
| CONVERSIONNET-816 | Show grid lines when converting Excel files | New Feature |
| CONVERSIONNET-817 | Show hidden sheets when converting Excel files | New Feature |
| CONVERSIONNET-834 | Option for removing comments when converting slides documents | New Feature |
| CONVERSIONNET-835 | Implement SVG document conversion | New Feature |
| CONVERSIONNET-846 | Implement XPS document conversion | New Feature |
| CONVERSIONNET-886 | Implement conversion to ICO | New Feature |
| CONVERSIONNET-924 | Option when converting from Words for show/hide markup and tack changes | New Feature |
| CONVERSIONNET-979 | Html to image conversion | New Feature |
| CONVERSIONNET-1318 | Convert from CAD documents to Cells, Html, Image, Pdf, Slides, Words | New Feature |
| CONVERSIONNET-1077 | Setting default Fonts | New Feature |
| CONVERSIONNET-1305 | Add FixedLayout option to Words to Html conversions | New Feature |
| CONVERSIONNET-1304 | Add FixedLayout option to Pdf to Html conversions | New Feature |
| CONVERSIONJAVA-149 | Setting default Fonts | New Feature |
| CONVERSIONJAVA-118 | Implement functionality for convert Project file to multipage Tiff file | New Feature |
| CONVERSIONNET-765 | Return conversion guid in ConversionProgressEventArgs | Improvement |
| CONVERSIONNET-710 | Client Response - In-Proper conversion From PPTX to PDF, Image and Word Document formats | Bug |
| CONVERSIONNET-722 | Exception when converting from ODP to PPT and PPS | Bug |
| CONVERSIONNET-734 | While Converting Xlsx file to HTML with HtmlSaveOptions Specific Pages (Sheets) does not work | Bug |
| CONVERSIONNET-740 | Client Response - HTML to Doc and Docx is not proper for Headings and contents are mixed | Bug |
| CONVERSIONNET-749 | Client Response - Only first page converts to PNG from TIF file (With and Without License) | Bug |
| CONVERSIONNET-750 | Client Response - Convert to HTML from Excel, PDF, MS Word overlaps the images AND some of Words with styling | Bug |
| CONVERSIONNET-757 | Can not find CallBack function to get Conversion Progress for MVC/WebForms Applications | Bug |
| CONVERSIONNET-767 | Client Respose - Could not open the file stream on azure. | Bug |
| CONVERSIONNET-782 | Client Response - FileType not supported Exceptions are not handled | Bug |
| CONVERSIONNET-783 | Client Response - Error for Empty Input Documents as Stream for Conversion | Bug |
| CONVERSIONNET-844 | xlsx to png Object null Reference exception | Bug |
| CONVERSIONNET-889 | Conversion from XLSX to PNG/JPG/HTML not Working Properly | Bug |
| CONVERSIONNET-890 | Converted File Name issue in Excel file to PNG | Bug |
| CONVERSIONNET-897 | Converting large XLS file to image with UsePdf=false is producing blurred images | Bug |
| CONVERSIONNET-898 | Missing pages when converting XLS file to image with UsePdf=true | Bug |
| CONVERSIONNET-899 | Excel to PNG/JPG/JPEG Low Image Quality Dpi not effecing | Bug |
| CONVERSIONNET-907 | PDF to Image conversion - target resolution is not changed when setting Dpi | Bug |
| CONVERSIONNET-908 | Words to Image conversion - target resolution is not changed when setting Dpi | Bug |
| CONVERSIONNET-909 | Slides to Image conversion - target resolution is not changed when setting Dpi | Bug |
| CONVERSIONNET-910 | Tasks to Image conversion - target resolution is not changed when setting Dpi | Bug |
| CONVERSIONNET-911 | Image to Image conversion - target resolution is not changed when setting Dpi | Bug |
| CONVERSIONNET-912 | Diagram to Image conversion - target resolution is not changed when setting Dpi | Bug |
| CONVERSIONNET-911 | Image to Image conversion - target resolution is not changed when setting Dpi | Bug |
| CONVERSIONNET-912 | Diagram to Image conversion - target resolution is not changed when setting Dpi | Bug |
| CONVERSIONNET-1072 |  Txt to Pdf is causing "Unknown format" exception | Bug |
| CONVERSIONNET-1078  | % symbol in the file name trowns an exception | Bug |
| CONVERSIONNET-1206 | Exception in HTML to Excel Conversion | Bug |
| CONVERSIONNET-1207 | Convert Excel from Html - Table with background colour and some html controls are not converted properly | Bug |
| CONVERSIONNET-1351 | Coversion with document as Stream input not working | Bug |
| CONVERSIONJAVA-206 | Multithread conversion is not working | Bug |
| CONVERSIONJAVA-166 | Unable to convert excel files containing empty sheets | Bug |
| CONVERSIONJAVA-169 | Converting excel file to HTML not displaying the entire excel file. | Bug |
| CONVERSIONJAVA-140 | After conversion can't render first page , throws an error "Out of Memory" | Bug |
| CONVERSIONJAVA-142 | Conversion .pptx to .pdf doesn't work with multi-threading | Bug |
| CONVERSIONJAVA-144 | Header and footer incorrect rendered after conversion to .html | Bug |
| CONVERSIONJAVA-115 | Using resolution parameter together height and width parameters | Bug |
| CONVERSIONJAVA-133 | Count pages does not match specified number of pages after conversion. | Bug |
| CONVERSIONJAVA-135 | Static logger binder warning | Bug |
| CONVERSIONJAVA-136 | Converted tiff file has incorrect page count in some TIFF viewers | Bug |
| CONVERSIONJAVA-138 | Incorrect converts to png format. | Bug |
| CONVERSIONJAVA-139 | Conversion Jpg to Png trows an error "LoadingException". | Bug |
| CONVERSIONJAVA-56 | Incorrectly resizing documents when converting to image | Bug |
| CONVERSIONJAVA-91 | Aspose.Words 15.8.0: Lost text after convert | Bug |
| CONVERSIONJAVA-146 | Incorrect order of the documents after merging | Bug |
| CONVERSIONJAVA-131 | Output file after CCITT4 compression not rendered well in IBM Viewer and Google viewer. | Bug |
| CONVERSIONJAVA-148 | Path to image isn't correct after conversion .xls document to .html | Bug |
| CONVERSIONJAVA-163 | Image resolution/size is not effecting by changing DPI | Bug |
| CONVERSIONJAVA-134 | com.groupdocs.conversion.exception.InternalException: Can't convert to image! for conversion from .xls to multipage .tiff file | Bug |
| CONVERSIONJAVA-167 | ConversionHandler not releasing the source file's resource | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for Java 16.10.1. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### How to get conversion progress

Here is an example of how to get conversion progress



```java
String sourceFileName = "sample.docx"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setCachePath("CACHE_PATH");
conversionConfig.setStoragePath("STORAGE_PATH");
conversionConfig.setOutputPath("OUTPUT_PATH");

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
conversionHandler.ConversionProgress.add(new ConversionProgressHandler() {
    // Here is the implementation of the conversion progress handler method
    @Override
    public void invoke(ConversionProgressEventArgs args) {
        System.out.println("Conversion progress: {"+args.getProgress()+"}");
    }
});

PdfSaveOptions saveOptions = new PdfSaveOptions();
saveOptions.setOutputType(OutputType.String);

String resultPath = conversionHandler.<String>convert(sourceFileName, saveOptions);

System.out.println("The conversion finished. The result can be located here: "+resultPath+". Press <<ENTER>> to exit.");
```

### How to place watermark in converted document



```java
String sourceFileName = "sample.docx"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setCachePath("CACHE_PATH");
conversionConfig.setStoragePath("STORAGE_PATH");
conversionConfig.setOutputPath("OUTPUT_PATH");

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

// Save options
PdfSaveOptions saveOptions = new PdfSaveOptions();
saveOptions.setOutputType(OutputType.String);
WatermarkOptions watermarkOptions = new WatermarkOptions("Watermark text");
watermarkOptions.setColor(Color.blue);
watermarkOptions.setFont(new Font("Arial", 40, 12));
watermarkOptions.setRotationAngle(45);
watermarkOptions.setTransparency(0.1);
watermarkOptions.setLeft(200);
watermarkOptions.setTop(400);
saveOptions.setWatermarkOptions(watermarkOptions);

String result = conversionHandler.<String>convert(sourceFileName, saveOptions);
System.out.println("The conversion finished. The result can be located here: "+result+". Press <<ENTER>> to exit.");
```

### How to convert to PSD



```java
String sourceFileName = "sample.docx"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setCachePath("CACHE_PATH");
conversionConfig.setStoragePath("STORAGE_PATH");
conversionConfig.setOutputPath("OUTPUT_PATH");

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

// Save options
ImageSaveOptions saveOptions = new ImageSaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setConvertFileType(ImageSaveOptions.ImageFileType.PSD);
PsdOptions psdOptions = new PsdOptions();
psdOptions.setColorMode(PsdOptions.ColorModes.GRAYSCALE);
psdOptions.setCompressionMethod(PsdOptions.CompressionMethods.RAW);
saveOptions.setPsdOptions(psdOptions);

List<String> result = conversionHandler.<List<String>>convert(sourceFileName , saveOptions);
```

### How to convert from PSD



```java
String sourceFileName = "Sample.psd"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setCachePath("CACHE_PATH");
conversionConfig.setStoragePath("STORAGE_PATH");
conversionConfig.setOutputPath("OUTPUT_PATH");

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

// Save options
SaveOptions saveOptions = new PdfSaveOptions();
saveOptions.setOutputType(OutputType.String);

String result = conversionHandler.<String>convert(sourceFileName, saveOptions);
```

### How to use ConversionStart, ConversionProgress and ConversionComplete events



```java
String sourceFileName = "sample.docx"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setCachePath("CACHE_PATH");
conversionConfig.setStoragePath("STORAGE_PATH");
conversionConfig.setOutputPath("OUTPUT_PATH");

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

conversionHandler.ConversionStart.add(new ConversionStartHandler() {
    @Override
    public void invoke(ConversionStartEventArgs args) {
        System.out.println("Conversion " + args.getConversionGuid() + " started");
    }
});

conversionHandler.ConversionProgress.add(new ConversionProgressHandler() {
    @Override
    public void invoke(ConversionProgressEventArgs args) {
        System.out.println("Conversion " + args.getConversionGuid() + " progress: " + args.getProgress() + " %");
    }
});

conversionHandler.ConversionComplete.add(new ConversionCompleteHandler() {
    @Override
    public void invoke(ConversionCompleteEventArgs args) {
        System.out.println("Conversion " + args.getConversionGuid() + " completed");
        System.out.println("Result document is " + args.getConversionType() + ". Cache is " + args.getUsedCache());
        System.out.println("Result document has " + ((PdfConversionCompleteEventArgs) args).getPageCount() + " page(s).")
    }
});

// Save options
SaveOptions saveOptions = new PdfSaveOptions();
saveOptions.setOutputType(OutputType.String);

String result = conversionHandler.<String>convert(sourceFileName, saveOptions);
```

### How to use IConversionProgressListener and IConversionStatusListener to receive conversion status changes and progress info

Defining conversion callbacks receiver



```java
public class ConversionManager implements IConversionProgressListener, IConversionStatusListener {
    private final ConversionHandler _conversionHandler;
    public ConversionManager(String path) {
        _conversionHandler = Common.getConversionHandler();
        _conversionHandler.setConversionProgressListener(this);
        _conversionHandler.setConversionStatusListener(this);
    }
    @Override
    public void conversionProgressChanged(ConversionProgressEventArgs args) {
        System.out.println("Conversion progress: " + args.getProgress() + " %");
    }
    @Override
    public void conversionStatusChanged(ConversionEventArgs args) {
        System.out.println("Conversion status changed to: " + args.getStatus());
    }
    public String convert(String file) throws IOException {
        PdfSaveOptions option = new PdfSaveOptions();
        option.setOutputType(OutputType.String);

        return _conversionHandler.<String>convert(file, option);
    }
}
```

### Usage of the conversion callback receiver for getting updates from conversion



```java
String sourceFileName = "sample.docx"; //TODO: Put the source filename here
String storagePath = ".";
ConversionManager manager = new ConversionManager(storagePath);

String result = manager.convert(sourceFileName);
System.out.println(result);
```

### How to show grid lines when converting from Excel



```java
String sourceFileName = "sample.xlsx"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setCachePath("CACHE_PATH");
conversionConfig.setStoragePath("STORAGE_PATH");
conversionConfig.setOutputPath("OUTPUT_PATH");

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

// Save options
SaveOptions saveOptions = new HtmlSaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setShowGridLines(true);

String result = conversionHandler.<String>convert(sourceFileName, saveOptions);
```

### How to show hidden sheets when converting from Excel



```java
String sourceFileName = "sample.xlsx"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setCachePath("CACHE_PATH");
conversionConfig.setStoragePath("STORAGE_PATH");
conversionConfig.setOutputPath("OUTPUT_PATH");

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

// Save options
SaveOptions saveOptions = new HtmlSaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setShowHiddenSheets(true);
String result = conversionHandler.<String>convert(sourceFileName, saveOptions);
```

### How to remove slides comments when converting to Slides



```java
String sourceFileName = "sample.pptx"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setCachePath("CACHE_PATH");
conversionConfig.setStoragePath("STORAGE_PATH");
conversionConfig.setOutputPath("OUTPUT_PATH");

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

// Save options
SlidesSaveOptions saveOptions = new SlidesSaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setRemoveSlidesComments(true);

String result = conversionHandler.<String>convert(sourceFileName, saveOptions);
```

### How to hide tracked changes when converting from Words



```java
String sourceFileName = "sample.docx"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setCachePath("CACHE_PATH");
conversionConfig.setStoragePath("STORAGE_PATH");
conversionConfig.setOutputPath("OUTPUT_PATH");

ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

// Save options
SaveOptions saveOptions = new PdfSaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setHideWordTrackedChanges(true);

String result = conversionHandler.<String>convert(sourceFileName, saveOptions);
```

### How to convert html to image



```java
String sourceFileName = "sample.html"; //TODO: Put the source filename here

// Setup Conversion configuration
ConversionConfig conversionConfig = new ConversionConfig();
conversionConfig.setCachePath("cache");
conversionConfig.setStoragePath(".");
ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);

// Save options
ImageSaveOptions saveOptions = new ImageSaveOptions();
saveOptions.setOutputType(OutputType.String);
saveOptions.setDpi(300);
List<String> result = conversionHandler.<List<String>>convert(sourceFileName, saveOptions);
```

### Introduced SlidesLoadOptions with ability to specify default font for rendering if a presentation font is missing



```java
SlidesLoadOptions loadOptions = new SlidesLoadOptions();
loadOptions.setPassword("secret");
loadOptions.setDefaultFont("Verdana"); // Default font for rendering the presentation. The following font will be used if a presentation font is missing.
```

### HtmlSaveOptions class is extended with new property - FixedLayout - if true html will be rendered with absolutely positioned elements



```java
HtmlSaveOptions saveOptions1 = new HtmlSaveOptions();
saveOptions1.setFixedLayout(true);
```
