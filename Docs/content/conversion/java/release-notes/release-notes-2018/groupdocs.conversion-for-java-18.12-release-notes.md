---
id: groupdocs-conversion-for-java-18-12-release-notes
url: conversion/java/groupdocs-conversion-for-java-18-12-release-notes
title: GroupDocs.Conversion for Java 18.12 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 18.12{{< /alert >}}

## Major Features

This regular monthly release contains 5+ new features, improvements and bug fixes. Most notable are: 

*   Introduced PdfFormatingOptions when converting to PDF    
*   Introduced TxtLoadOptions for conversions from TXT documents    
*   Improved per page savings for all conversions
*   Image to PDF conversions improvements
*   Improved Load and Save Options, moved to new namespace    
*   Introduced conversion from IGS    
*   Introduced conversion from PLT
*   Convert from password protected ODS
*   Convert to password protected ODS
*   Introduced conversion from CGM
*   Fixed bug where image inside presentation isn't the same in ODP output    
*   Fixed bug where border are missing in ODS Excel output    
*   Fixed bug XLSX file eats almost 2 GB RAM while converting and the process never completes
*   Introduced option for removing embedded files in Pdf  
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-2640 | Implement PdfFormattingOptions when converting to PDF | New Feature |
| CONVERSIONNET-2661 | Implement specific options for converting TXT documents | New Feature |
| CONVERSIONNET-1930 | Implement conversion from Igs | New Feature |
| CONVERSIONNET-1927 | Implement conversion from Plt | New Feature |
| CONVERSIONNET-1906 | Support password protection when converting to ODS | New Feature |
| CONVERSIONNET-1905 | Support converting password protected ODS document | New Feature |
| CONVERSIONNET-1894 | Implement conversion from Cgm | New Feature |
| CONVERSIONNET-2633 | Automatically add extension of the converted file if not set | Improvement |
| CONVERSIONNET-2649 | Remove obsolete constructors and properties | Improvement |
| CONVERSIONNET-2658 | Image to PDF conversion improvement | Improvement |
| CONVERSIONNET-2686 | Improve per page savings when converting to Words, Images, Slides, Cells, Pdf, Xps, Html | Improvement |
| CONVERSIONNET-2687 | Security improvements update | Improvement |
| CONVERSIONNET-1930 | Pdf to Cells improvement | Improvement |
| CONVERSIONNET-1917 | Improve Words conversion options | Improvement |
| CONVERSIONNET-1916 | Improve Slides conversion options | Improvement |
| CONVERSIONNET-1915 | Improve Pdf conversion options | Improvement |
| CONVERSIONNET-1913 | Improve Image conversion options | Improvement |
| CONVERSIONNET-1912 | Improve Html conversion options | Improvement |
| CONVERSIONNET-1911 | Improve Cells conversion options | Improvement |
| CONVERSIONNET-1957 | Implement option for removing embedded files in Pdf | Improvement |
| CONVERSIONNET-2683 | Exception when cache is enabled | Bug |
| CONVERSIONNET-1920 | XLS to HTML output is too small | Bug |
| CONVERSIONNET-1907 | Excel to SVG conversion issue | Bug |
| CONVERSIONNET-1520 | Xps to Pdf conversion issue | Bug |
| CONVERSIONNET-1873 | The image inside presentation isn't the same in ODP output | Bug |
| CONVERSIONNET-1874 | Missing border in ODS Excel output | Bug |
| CONVERSIONNET-1923 | XLSX file eats almost 2 GB RAM while converting and the process never completes | Bug |
| CONVERSIONJAVA-433 | Ms word document font substitution issue | Bug |
| CONVERSIONJAVA-441 | Trendlines in graphs on word documents not displaying | Bug |
| CONVERSIONJAVA-444 | Numbered items in .txt file converted to .pdf, output is not as expected | Bug |
| CONVERSIONJAVA-466 | An exception raises while rendering to the image output | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for Java 18.12. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  ### All classes from GroupDocs.Conversion.Converter.Option namespace are now obsolete
    
    This is not breaking change, but the classes are marked as obsolete and will be removed in version 19.+. The new options classes are in GroupDocs.Conversion.Options namespace and are separated in two sub namespaces GroupDocs.Conversion.Options.Load and GroupDocs.Conversion.Options.Save.
2.  ### Following obsolete constructors are removed from ConversionHandler
       
    
    ```java
    /// <summary>
    /// Instantiate the ConversionHandler with default <see cref="IOutputDataHandler"/>, <see cref="ICacheDataHandler"/> and custom <see cref="IInputDataHandler"/> implementation
    /// </summary>
    /// <param name="conversionConfig">Instance of <see cref="ConversionConfig"/></param>
    /// <param name="inputDataHandler">Custom implementation of <see cref="IInputDataHandler" /> interface</param>
    public ConversionHandler(ConversionConfig conversionConfig, IInputDataHandler inputDataHandler)
      
    /// <summary>
    /// Instantiate the ConversionHandler with default <see cref="IInputDataHandler"/>, <see cref="IOutputDataHandler"/> and custom <see cref="ICacheDataHandler"/> implementation
    /// </summary>
    /// <param name="conversionConfig">Instance of <see cref="ConversionConfig"/></param>
    /// <param name="cacheDataHandler">Custom implementation of <see cref="IInputDataHandler" /> interface</param>
    public ConversionHandler(ConversionConfig conversionConfig, ICacheDataHandler cacheDataHandler)
      
    /// <summary>
    /// Instantiate the ConversionHandler with default <see cref="IInputDataHandler"/>, <see cref="ICacheDataHandler"/> and custom <see cref="IOutputDataHandler"/> implementation
    /// </summary>
    /// <param name="conversionConfig">Instance of <see cref="ConversionConfig"/></param>
    /// <param name="outputDataHandler">Custom implementation of <see cref="IOutputDataHandler" /> interface</param>
    public ConversionHandler(ConversionConfig conversionConfig, IOutputDataHandler outputDataHandler)
      
    /// <summary>
    /// Instantiate the ConversionHandler with default <see cref="ICacheDataHandler"/> and custom <see cref="IInputDataHandler"/>, <see cref="IOutputDataHandler"/> implementation
    /// </summary>
    /// <param name="conversionConfig">Instance of <see cref="ConversionConfig"/></param>
    /// <param name="inputDataHandler">Custom implementation of <see cref="IInputDataHandler" /> interface</param>
    /// <param name="outputDataHandler">Custom implementation of <see cref="IOutputDataHandler" /> interface</param>
    public ConversionHandler(ConversionConfig conversionConfig, IInputDataHandler inputDataHandler, IOutputDataHandler outputDataHandler)
      
    /// <summary>
    /// Instantiate the ConversionHandler with default <see cref="IOutputDataHandler"/> and custom <see cref="IInputDataHandler"/>, <see cref="ICacheDataHandler"/> implementation
    /// </summary>
    /// <param name="conversionConfig">Instance of <see cref="ConversionConfig"/></param>
    /// <param name="inputDataHandler">Custom implementation of <see cref="IInputDataHandler" /> interface</param>
    /// <param name="cacheDataHandler">Custom implementation of <see cref="ICacheDataHandler" /> interface</param>
    public ConversionHandler(ConversionConfig conversionConfig, IInputDataHandler inputDataHandler, ICacheDataHandler cacheDataHandler)
    /// <summary>
    /// Instantiate the ConversionHandler with default <see cref="IInputDataHandler"/> and custom <see cref="IOutputDataHandler"/>, <see cref="ICacheDataHandler"/> implementation
    /// </summary>
    /// <param name="conversionConfig">Instance of <see cref="ConversionConfig"/></param>
    /// <param name="outputDataHandler">Custom implementation of <see cref="IOutputDataHandler" /> interface</param>
    /// <param name="cacheDataHandler">Custom implementation of <see cref="ICacheDataHandler" /> interface</param>
    public ConversionHandler(ConversionConfig conversionConfig, IOutputDataHandler outputDataHandler, ICacheDataHandler cacheDataHandler)
      
    /// <summary>
    /// Instantiate the ConversionHandler with custom <see cref="IInputDataHandler"/>, <see cref="IOutputDataHandler"/> and custom <see cref="ICacheDataHandler"/> implementations
    /// </summary>
    /// <param name="conversionConfig">Instance of <see cref="ConversionConfig"/></param>
    /// <param name="inputDataHandler">Custom implementation of <see cref="IInputDataHandler" /> interface</param>
    /// <param name="outputDataHandler">Custom implementation of <see cref="IOutputDataHandler" /> interface</param>
    /// <param name="cacheDataHandler">Custom implementation of <see cref="ICacheDataHandler" /> interface</param>
    public ConversionHandler(ConversionConfig conversionConfig, IInputDataHandler inputDataHandler, IOutputDataHandler outputDataHandler, ICacheDataHandler cacheDataHandler)
    ```
          
    Usage    
    
    ```java
    // Setup Conversion configuration
    ConversionConfig conversionConfig = new ConversionConfig();
    conversionConfig.setStoragePath(storagePath);
    conversionConfig.setOutputPath(outputPath);
     
    // Instantiating the conversion handler
    ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
    ```
    
3.  ### Introduced PdfFormatingOptions when converting to PDF  
    
    ```java
    /**
     * <p>
     * Specify whether position of the document's window will be centerd on the
     * screen. Default: false.
     * </p>
     * @return 
     */
    public final boolean getCenterWindow() {
        return auto_CenterWindow;
    }
    /**
     * <p>
     * Specify whether position of the document's window will be centerd on the
     * screen. Default: false.
     * </p>
     * @param value
     */
    public final void setCenterWindow(boolean value) {
        auto_CenterWindow = value;
    }
    private boolean auto_CenterWindow;
    /**
     * <p>
     * Sets reading order of text: L2R (left to right) or R2L (right to left).
     * Default: L2R.
     * </p>
     * @return 
     */
    public final /*PdfDirection*/ int getDirection() {
        return auto_Direction;
    }
    /**
     * <p>
     * Sets reading order of text: L2R (left to right) or R2L (right to left).
     * Default: L2R.
     * </p>
     * @param value
     */
    public final void setDirection(/*PdfDirection*/int value) {
        auto_Direction = value;
    }
    private /*PdfDirection*/ int auto_Direction;
    /**
     * <p>
     * Specifying whether document's window title bar should display document
     * title. Default: false.
     * </p>
     * @return 
     */
    public final boolean getDisplayDocTitle() {
        return auto_DisplayDocTitle;
    }
    /**
     * <p>
     * Specifying whether document's window title bar should display document
     * title. Default: false.
     * </p>
     * @param value
     */
    public final void setDisplayDocTitle(boolean value) {
        auto_DisplayDocTitle = value;
    }
    private boolean auto_DisplayDocTitle;
    /**
     * <p>
     * Specify whether document window must be resized to fit the first
     * displayed page. Default: false.
     * </p>
     * @return 
     */
    public final boolean getFitWindow() {
        return auto_FitWindow;
    }
    /**
     * <p>
     * Specify whether document window must be resized to fit the first
     * displayed page. Default: false.
     * </p>
     * @param value
     */
    public final void setFitWindow(boolean value) {
        auto_FitWindow = value;
    }
    private boolean auto_FitWindow;
    /**
     * <p>
     * Specify whether menu bar should be hidden when document is active.
     * Default: false.
     * </p>
     * @return 
     */
    public final boolean getHideMenubar() {
        return auto_HideMenubar;
    }
    /**
     * <p>
     * Specify whether menu bar should be hidden when document is active.
     * Default: false.
     * </p>
     * @param value
     */
    public final void setHideMenubar(boolean value) {
        auto_HideMenubar = value;
    }
    private boolean auto_HideMenubar;
    /**
     * <p>
     * Specifying whether toolbar should be hidden when document is active.
     * Default: false.
     * </p>
     * @return 
     */
    public final boolean getHideToolBar() {
        return auto_HideToolBar;
    }
    /**
     * <p>
     * Specifying whether toolbar should be hidden when document is active.
     * Default: false.
     * </p>
     * @param value
     */
    public final void setHideToolBar(boolean value) {
        auto_HideToolBar = value;
    }
    private boolean auto_HideToolBar;
    /**
     * <p>
     * Specify whether user interface elements should be hidden when document is
     * active. Default: false.
     * </p>
     * @return 
     */
    // ReSharper disable once InconsistentNaming
    public final boolean getHideWindowUI() {
        return auto_HideWindowUI;
    }
    /**
     * <p>
     * Specify whether user interface elements should be hidden when document is
     * active. Default: false.
     * </p>
     * @param value
     */
    // ReSharper disable once InconsistentNaming
    public final void setHideWindowUI(boolean value) {
        auto_HideWindowUI = value;
    }
    private boolean auto_HideWindowUI;
    /**
     * <p>
     * Sets page mode, specifying how to display the document on exiting
     * full-screen mode.
     * </p>
     * @return 
     */
    public final /*PdfPageMode*/ int getNonFullScreenPageMode() {
        return auto_NonFullScreenPageMode;
    }
    /**
     * <p>
     * Sets page mode, specifying how to display the document on exiting
     * full-screen mode.
     * </p>
     * @param value
     */
    public final void setNonFullScreenPageMode(/*PdfPageMode*/int value) {
        auto_NonFullScreenPageMode = value;
    }
    private /*PdfPageMode*/ int auto_NonFullScreenPageMode;
    /**
     * <p>
     * Sets page layout which shall be used when the document is opened.
     * </p>
     * @return 
     */
    public final /*PdfPageLayout*/ int getPageLayout() {
        return auto_PageLayout;
    }
    /**
     * <p>
     * Sets page layout which shall be used when the document is opened.
     * </p>
     * @param value
     */
    public final void setPageLayout(/*PdfPageLayout*/int value) {
        auto_PageLayout = value;
    }
    private /*PdfPageLayout*/ int auto_PageLayout;
    /**
     * <p>
     * Sets page mode, specifying how document should be displayed when opened.
     * </p>
     * @return 
     */
    public final /*PdfPageMode*/ int getPageMode() {
        return auto_PageMode;
    }
    /**
     * <p>
     * Sets page mode, specifying how document should be displayed when opened.
     * </p>
     * @param value
     */
    public final void setPageMode(/*PdfPageMode*/int value) {
        auto_PageMode = value;
    }
    private /*PdfPageMode*/ int auto_PageMode;
    ```
    
    Usage
    
    ```java
    String guid = "test.pdf";
     
    // Setup Conversion configuration
    ConversionConfig conversionConfig = new ConversionConfig();
    conversionConfig.setStoragePath(storagePath);
    conversionConfig.setOutputPath(outputPath);
     
    // Instantiating the conversion handler
    ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
     
    PdfSaveOptions saveOptions = new PdfSaveOptions();
    saveOptions.getPdfOptions().getFormatingOptions().setPageMode(PdfFormatingOptions.PdfPageMode.FullScreen);
    saveOptions.getPdfOptions().getFormatingOptions().setPageLayout(PdfFormatingOptions.PdfPageLayout.SinglePage);
     
    ConvertedDocument savedPath = conversionHandler.<String>convert(storagePath + "/" +guid, saveOptions);
     
    savedPath.save(guid + "." + savedPath.getFileType());
    ```
    
4.  ### Introduced PdfLoadOptions when converting from PDF
        
    ```java
    public class PdfLoadOptions extends LoadOptions {
        /**
         * <p>
         * Remove embedded files
         * </p>
         * @return 
         */
        public final boolean getRemoveEmbeddedFiles() {
            return auto_RemoveEmbeddedFiles;
        }
        /**
         * <p>
         * Remove embedded files
         * </p>
         * @param value
         */
        public final void setRemoveEmbeddedFiles(boolean value) {
            auto_RemoveEmbeddedFiles = value;
        }
        private boolean auto_RemoveEmbeddedFiles;
    }
    ```
    
    Usage
    
    ```java
    String guid = "source.pdf";
     
    // Setup Conversion configuration
    ConversionConfig conversionConfig = new ConversionConfig();
    conversionConfig.setStoragePath(storagePath);
    conversionConfig.setOutputPath(outputPath);
     
    // Instantiating the conversion handler
    ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
     
    PdfLoadOptions loadOptions = new PdfLoadOptions();
    loadOptions.setRemoveEmbeddedFiles(true);
     
    PdfSaveOptions saveOptions = new PdfSaveOptions();
    saveOptions.getPdfOptions().getFormatingOptions().setPageMode(PdfFormatingOptions.PdfPageMode.FullScreen);
    saveOptions.getPdfOptions().getFormatingOptions().setPageLayout(PdfFormatingOptions.PdfPageLayout.SinglePage);
     
    ConvertedDocument savedPath = conversionHandler.convert(storagePath + "/" + guid, saveOptions);
     
    savedPath.save(guid + "." + savedPath.getFileType());
    ```
    
5.  ### Introduced TxtLoadOptions for conversions from TXT documents
    
    ```java
    /**
     * <p>
     * Txt document load options
     * </p>
     */
    public class TxtLoadOptions extends LoadOptions {
     
    /**
     * <p>
     * Allows to specify how numbered list items are recognized when plain text
     * document is converted. The default value is true.</p><p>
     * <hr>
     * <p>
     * If this option is set to false, lists recognition algorithm detects list
     * paragraphs, when list numbers ends with either dot, right bracket or
     * bullet symbols (such as "•", "*", "-" or "o").</p>
     * <p>
     * If this option is set to true, whitespaces are also used as list number
     * delimeters: list recognition algorithm for Arabic style numbering (1.,
     * 1.1.2.) uses both whitespaces and dot (".") symbols.</p>
     * </hr></p>
     * @return 
     */
    public final boolean getDetectNumberingWithWhitespaces() {
        return auto_DetectNumberingWithWhitespaces;
    }
    /**
     * <p>
     * Allows to specify how numbered list items are recognized when plain text
     * document is converted. The default value is true.</p><p>
     * <hr>
     * <p>
     * If this option is set to false, lists recognition algorithm detects list
     * paragraphs, when list numbers ends with either dot, right bracket or
     * bullet symbols (such as "•", "*", "-" or "o").</p>
     * <p>
     * If this option is set to true, whitespaces are also used as list number
     * delimeters: list recognition algorithm for Arabic style numbering (1.,
     * 1.1.2.) uses both whitespaces and dot (".") symbols.</p>
     * </hr></p>
     * @param value
     */
    public final void setDetectNumberingWithWhitespaces(boolean value) {
        auto_DetectNumberingWithWhitespaces = value;
    }
    private boolean auto_DetectNumberingWithWhitespaces;
    /**
     * <p>
     * Gets or sets preferred option of a trailing space handling. Default value
     * is {@link TxtTrailingSpacesOptions#Trim}.
     * </p>
     * @return 
     */
    public final /*TxtTrailingSpacesOptions*/ int getTrailingSpacesOptions() {
        return auto_TrailingSpacesOptions;
    }
    /**
     * <p>
     * Gets or sets preferred option of a trailing space handling. Default value
     * is {@link TxtTrailingSpacesOptions#Trim}.
     * </p>
     * @param value
     */
    public final void setTrailingSpacesOptions(/*TxtTrailingSpacesOptions*/int value) {
        auto_TrailingSpacesOptions = value;
    }
    private /*TxtTrailingSpacesOptions*/ int auto_TrailingSpacesOptions;
    /**
     * <p>
     * Gets or sets preferred option of a leading space handling. Default value
     * is {@link TxtLeadingSpacesOptions#ConvertToIndent}.
     * </p>
     * @return 
     */
    public final /*TxtLeadingSpacesOptions*/ int getLeadingSpacesOptions() {
        return auto_LeadingSpacesOptions;
    }
    /**
     * <p>
     * Gets or sets preferred option of a leading space handling. Default value
     * is {@link TxtLeadingSpacesOptions#ConvertToIndent}.
     * </p>
     * @param value
     */
    public final void setLeadingSpacesOptions(/*TxtLeadingSpacesOptions*/int value) {
        auto_LeadingSpacesOptions = value;
    }
    private /*TxtLeadingSpacesOptions*/ int auto_LeadingSpacesOptions;
    //JAVA-added public wrapper for internalized property accessor
    /**
     * <p>
     * Gets or sets the encoding that will be used when loading Txt document.
     * Can be null. Default is null.
     * </p>
     * @return 
     */
    public final java.nio.charset.Charset getEncoding() {
        return Encoding.toJava(getEncodingInternal());
    }
    //JAVA: property accessor is internalized
    Encoding getEncodingInternal() {
        return auto_Encoding;
    }
    //JAVA-added public wrapper for internalized property accessor
    /**
     * <p>
     * Gets or sets the encoding that will be used when loading Txt document.
     * Can be null. Default is null.
     * </p>
     * @param value
     */
    public final void setEncoding(java.nio.charset.Charset value) {
        setEncodingInternal(Encoding.fromJava(value));
    }
    //JAVA: property accessor is internalized
    void setEncodingInternal(Encoding value) {
        auto_Encoding = value;
    }
    private Encoding auto_Encoding;
     
    }
    ```
    
    Usage
    
    ```java
    String guid = "test.txt";
     
    // Setup Conversion configuration
    ConversionConfig conversionConfig = new ConversionConfig();
    conversionConfig.setStoragePath(storagePath);
    conversionConfig.setOutputPath(outputPath);
     
    // Instantiating the conversion handler
    ConversionHandler conversionHandler = new ConversionHandler(conversionConfig);
     
    TxtLoadOptions loadOptions = new TxtLoadOptions();
    loadOptions.setDetectNumberingWithWhitespaces(false);
    loadOptions.setLeadingSpacesOptions(TxtLoadOptions.TxtLeadingSpacesOptions.Trim);
    loadOptions.setTrailingSpacesOptions(TxtLoadOptions.TxtTrailingSpacesOptions.Trim);
     
    PdfSaveOptions saveOptions = new PdfSaveOptions();
     
    ConvertedDocument savedPath = conversionHandler.<String>convert(storagePath + "/" +guid, saveOptions);
     
    savedPath.save(guid + "." + savedPath.getFileType());
    ```
