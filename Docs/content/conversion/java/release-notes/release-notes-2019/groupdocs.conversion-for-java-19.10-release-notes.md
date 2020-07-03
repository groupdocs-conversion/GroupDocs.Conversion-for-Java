---
id: groupdocs-conversion-for-java-19-10-release-notes
url: conversion/java/groupdocs-conversion-for-java-19-10-release-notes
title: GroupDocs.Conversion for Java 19.10 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 19.10{{< /alert >}}

## Major Features

This regular monthly release contains 10+ new features, improvements and bug fixes. Most notable are: 

*   Conversions from Cdr    
*   Adjusting brightness, contrast, gamma when converting to image    
*   Flip image option when converting to image
*   Converstions from Excel95/5.0
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-2892 | Implement conversion from Cdr | Feature |
| CONVERSIONNET-2911 | Set color mode when converting to Jpeg | Feature |
| CONVERSIONNET-2912 | Set compression mode when converting to Jpeg | Feature |
| CONVERSIONNET-2925 | Implement option for adjusting brightness when converting to image | Feature |
| CONVERSIONNET-2926 | Implement option for adjusting contrast when converting to image | Feature |
| CONVERSIONNET-2927 | Implement option for adjusting gamma when converting to image | Feature |
| CONVERSIONNET-2928 | Implement option for flip image when converting to image | Feature |
| CONVERSIONNET-2891 | Support conversion from Excel95/5.0 XLS files | Improvement |
| CONVERSIONNET-2913 | Set image quality when converting to WebP | Improvement |
| CONVERSIONNET-2914 | Extend DocumentInfo with new property IsPasswordProtected | Improvement |
| CONVERSIONNET-2965 | Remove HideComments from SaveOptions | Improvement |
| CONVERSIONNET-2966 | Remove HidePdfAnnotations from SaveOptions | Improvement |
| CONVERSIONNET-2967 | Remove HideWordTrackedChanges from SaveOptions | Improvement |
| CONVERSIONNET-2880 | ImageSaveOptions.JpegQuality issue when converting .pdf to .jpeg | Bug |
| CONVERSIONNET-2916 | Multi-line merged cell in excel renders only the first line | Bug |
| CONVERSIONNET-1937 | Arrows point in the wrong direction in ODP output | Bug |
| CONVERSIONJAVA-82 | Unable to generate Scalable/Adjustable HTML | Bug |
| CONVERSIONJAVA-544 | Multi-line merged cell in excel renders only the first line | Bug |
| CONVERSIONJAVA-705 | Cannot open an image exception when converting a Cells to Image | Bug |
| CONVERSIONJAVA-732 | Ch.qos.logback conflict with GroupDocs.Conversion API | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for Java 19.10. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  **Control brightness, contrast, gamma and flip when convert to image**
    
    ```java
    /**
     * <p>
     * Options for to Image conversion
     * </p>
     */
    public final class ImageSaveOptions extends SaveOptions {
    
        ...
         /**
     * Get flip mode
     * @return flip mode
     */
     public FlipModes getFlipMode() {
            ...
     
     /**
     * Set flip mode
     * @param flipMode flip mode
     */
     public void setFlipMode(FlipModes flipMode) {
            ...
    
     /**
     * Image brightness
     * @return brightness
     */
     public int getBrightness() {
            ...
    
     /**
     * Set brightness
     * @param brightness brightness
     */
     public void setBrightness(int brightness) {
            ...
    
     /**
     * Get image contrast
     * @return contrast
     */
     public int getContrast() {
         ...
    
     /**
     * Set image contrast
     * @param contrast contrast
     */
     public void setContrast(int contrast) {
         ...
    
     /**
     * Get image gamma
     * @return gamma
     */
     public float getGamma() {
           ...
    
     /**
     * Set image gamma
     * @param gamma gamma
     */
     public void setGamma(float gamma) {
        ...
    
    }
    ```
    
    Usage:
       
    
    ```java
    ...
    ConversionConfig config = new ConversionConfig();
    ConversionHandler conversionHandler = new ConversionHandler(config);
    String source = "source.pdf";
    ImageSaveOptions saveOptions = new ImageSaveOptions();
    saveOptions.setFlipMode(ImageSaveOptions.FlipModes.FLIP_X);
    saveOptions.setBrightness(50);
    saveOptions.setContrast(50);
    saveOptions.setGamma(0.5f);
    ConvertedDocument convertedDocument = conversionHandler.convert(source, saveOptions);
    convertedDocument.save("result");    
    ...
    ```
    
2.  **Removed HideComments from SaveOptions**  
    Replaced by HideComments property in CellsLoadOptions, SlidesLoadOptions or WordsLoadOptions classes
3.  **Removed HidePdfAnnotations from SaveOptions**  
    Replaced by GroupDocs.Conversion.Options.Load.PdfLoadOptions.HidePdfAnnotations property
4.  **Removed HideWordTrackedChanges from SaveOptions**  
    Replaced by GroupDocs.Conversion.Options.Load.WordsLoadOptions.HideWordTrackedChanges property
