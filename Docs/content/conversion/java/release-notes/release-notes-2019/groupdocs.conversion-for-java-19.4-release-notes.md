---
id: groupdocs-conversion-for-java-19-4-release-notes
url: conversion/java/groupdocs-conversion-for-java-19-4-release-notes
title: GroupDocs.Conversion for Java 19.4 Release Notes
weight: 5
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Conversion for Java 19.4{{< /alert >}}

## Major Features 

This regular monthly release contains 5+ new features, improvements and bug fixes. Most notable are: 

*   Improved options to make them more meaningful    
*   Conversions from EPS    
*   Conversions from/to TSV
*   Conversion from Pcl
*   Rotate feature when converting to image
*   ConvertedDocument extended with additional property which contain conversion elapsed time   
*   Fixed bug where ImageOptions width and height are not working    
*   Fixed bug where text is too light when rendering a google slide exported pptx file to pdf    
*   Fixed bug where was no access to GroupDocs.Conversion exception classes
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-2814 | Move HideWordTrackedChanges option to WordsLoadOptions class | Improvement |
| CONVERSIONNET-2815 | Move HidePdfAnnotations option to PdfLoadOptions class | Improvement |
| CONVERSIONNET-2816 | Move HideComments option to CellsLoadOptions, SlidesLoadOptions and WordsLoadOptions class | Improvement |
| CONVERSIONNET-1509 | Implement conversion from EPS | Feature |
| CONVERSIONNET-2781 | Implement conversion from TSV and to TSV | Feature |
| CONVERSIONNET-2786 | Implement conversion from Pcl | Feature |
| CONVERSIONNET-2797 | Implement setting default font and font substitution options when converting One document | Feature |
| CONVERSIONNET-2799 | Implement setting default font when converting Psd, Emf, Wmf documents | Feature |
| CONVERSIONNET-2801 | Measure conversion time and return it as property of ConvertedDocument class | Feature |
| CONVERSIONNET-2802 | Set font load folders when converting Image documents | Feature |
| CONVERSIONNET-2810 | Implement rotation feature when converting to image | Feature |
| CONVERSIONNET-2818 | Implement option for flatten all form fields when converting Pdf | Feature |
| CONVERSIONNET-2825 | Implement page rotation when converting to Pdf | Feature |
| CONVERSIONNET-2826 | Implement option for including hidden slides in converted document when converting from Slides | Feature |
| CONVERSIONNET-2828 | Set default font when converting from Diagram | Feature |
| CONVERSIONJAVA-518 | Spreadsheets sometimes show incorrect graph data | Bug |
| CONVERSIONJAVA-542 | Stax2 inclusion from 18.12 creates a class resolver conflict | Bug |
| CONVERSIONJAVA-545 | Some text is too light when rendering a google slide exported pptx file to pdf | Bug |
| CONVERSIONJAVA-551 | Image to Image conversion issue | Bug |
| CONVERSIONJAVA-556 | Visio to image conversion issue | Bug |
| CONVERSIONJAVA-564 | ImageOptions width and height are not working | Bug |
| CONVERSIONJAVA-566 | eml to pdf conversion issue in sent filed | Bug |
| CONVERSIONJAVA-567 | Not able to access "PasswordProtectedException" in Java API | Bug |
| CONVERSIONJAVA-574 | License issue with groupdocs.conversion java 19.3 | Bug |
| CONVERSIONNET-2686 | Improve per page savings when converting to Words, Images, Slides, Cells, Pdf, Xps, Html | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Conversion for Java 19.4. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Conversion which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  ** Measure conversion time and return it as property of ConvertedDocument class**
    
    ```java
    /// <summary>
    /// Class for handling converted document
    /// </summary>
    public final class ConvertedDocument implements IDisposable
    
    {
        ...
        /// <summary>
        /// Get the total elapsed time for the conversion in milliseconds
        /// </summary>
     public long getElapsed() {
        return auto_Elapsed;
      }
    
        ...
    }
    ```
    
    Usage
    
    ```java
    ...
    ConversionConfig config = new ConversionConfig();
    ConversionHandler conversionHandler = new ConversionHandler(config);
    String source = "source.docx";
    PdfSaveOptions saveOptions = new PdfSaveOptions();
    ConvertedDocument convertedDocument = conversionHandler.convert(source, saveOptions);
    System.out.println("Elapsed time: " + convertedDocument.getElapsed() + "ms");
    ...
    ```
    
2.  **Option for including hidden slides in converted document when converting from Slides**
    
    ```java
    /// <summary>
    /// Slide document load options
    /// </summary>
    public class SlidesLoadOptions extends LoadOptions
    {
        ...
         /**
     * <p>
     * Show hidden slides
     * </p>
     */
     public final boolean getShowHiddenSlides(){ return auto_ShowHiddenSlides; }
     /**
     * <p>
     * Show hidden slides
     * </p>
     */
     public final void setShowHiddenSlides(boolean value){ auto_ShowHiddenSlides = value; }
    
        ...
    }
    ```
    
    Usage
    
    ```java
    ...
    ConversionConfig config = new ConversionConfig();
    ConversionHandler conversionHandler = new ConversionHandler(config);
    String source = "source.pptx";
    SlidesLoadOptions loadOptions = new SlidesLoadOptions();
    loadOptions.setShowHiddenSlides(true);
    PdfSaveOptions saveOptions = new PdfSaveOptions();
    ConvertedDocument convertedDocument = conversionHandler.convert(source, loadOptions, saveOptions);
    convertedDocument.save("result");
    ...
    ```
    
3.  **Option for page rotation when converting to Pdf**
    
    ```java
    /// <summary>
    /// Options for to PDF conversion
    /// </summary>
    public class PdfSaveOptions extends SaveOptions
    {
        ...
         /**
     * <p>
     * Rotation enum
     * </p>
     */
     public static final class Rotation extends Enum {
          private Rotation() {
          }
    
          /**
     * <p>
     * None
     * </p>
     */
      public static final int None = 0;
          /**
     * <p>
     * 90 degrees
     * </p>
     */
      public static final int On90 = 1;
          /**
     * <p>
     * 180 degrees
     * </p>
     */
      public static final int On180 = 2;
          /**
     * <p>
     * 270 degrees
     * </p>
     */
      public static final int On270 = 3;
    
          static {
              GDEnum en = new GDEnum(Rotation.class, Integer.class);
              en.add("None", None);
              en.add("On90", On90);
              en.add("On180", On180);
              en.add("On270", On270);
              Enum.register(en);
          }
      }
    
        ...
         /**
     * <p>
     * Rotate page
     * </p>
     */
     public final int getRotate(){ return auto_Rotate; }
     /**
     * <p>
     * Rotate page
     * </p>
     */
     public final void setRotate(int value){ auto_Rotate = value; }
     private int auto_Rotate;
    
        ...
    }
    ```
    
    Usage
    
    ```java
    ...
    ConversionConfig config = new ConversionConfig();
    ConversionHandler conversionHandler = new ConversionHandler(config);
    String source = "source.docx";
    PdfSaveOptions saveOptions = new PdfSaveOptions();
    saveOptions.setRotate(PdfSaveOptions.Rotation.On90);
    ConvertedDocument convertedDocument = conversionHandler.convert(source, saveOptions);
    convertedDocument.save("result");
    ...
    ```
    
4.  **Option to flatten all form fields when converting Pdf**
    
    ```java
    /// <summary>
    /// Pdf document load options
    /// </summary>
    public class PdfLoadOptions extends LoadOptions
    {
        ...
     /**
     * <p>
     * Flatten all the fields of the PDF form
     * </p>
     */
     public final boolean getFlattenAllFields(){ return auto_FlattenAllFields; }
     /**
     * <p>
     * Flatten all the fields of the PDF form
     * </p>
     */
     public final void setFlattenAllFields(boolean value){ auto_FlattenAllFields = value; }
     private boolean auto_FlattenAllFields;
        ...
    }
    ```
    
    Usage
    
    ```java
    ...
    ConversionConfig config = new ConversionConfig();
    ConversionHandler conversionHandler = new ConversionHandler(config);
    String source = "source.pdf";
    PdfLoadOptions loadOptions = new PdfLoadOptions();
    loadOptions.setFlattenAllFields(true);
    WordsSaveOptions saveOptions = new WordsSaveOptions();
    ConvertedDocument convertedDocument = conversionHandler.convert(source, loadOptions, saveOptions);
    convertedDocument.save("result");
    ...
    ```
    
5.  **Rotation feature when converting to image**
    
    ```java
    /// <summary>
    /// Options for to Image conversion
    /// </summary>
    public class ImageSaveOptions extends SaveOptions
    {
        ...
         /**
     * <p>
     * Image rotation angle
     * </p>
     */
     public final int getRotateAngle(){ return auto_RotateAngle; }
     /**
     * <p>
     * Image rotation angle
     * </p>
     */
     public final void setRotateAngle(int value){ auto_RotateAngle = value; }
     private int auto_RotateAngle;
    
        ...
    }
    ```
    
    Usage
    
    ```java
    ...
    ConversionConfig config = new ConversionConfig();
    ConversionHandler conversionHandler = new ConversionHandler(config);
    String source = "source.pdf";
    ImageSaveOptions saveOptions = new ImageSaveOptions();
    saveOptions.setRotateAngle(45);
    ConvertedDocument convertedDocument = conversionHandler.convert(source, saveOptions);
    convertedDocument.save("result");
    ...
    ```
    
6.  **Set default font and font substitution options when converting One document**
    
    ```java
    /**
     * <p>
     * One document load options
     * </p>
     */
    
    public class OneLoadOptions extends LoadOptions
    {
        /**
     * <p>
     * Default font for Note document. The following font will be used if a font is missing.
     * </p>
     */
     public final void setDefaultFont(String value){ auto_DefaultFont = value; }
     private String auto_DefaultFont;
    
     /**
     * <p>
     * Substitute specific fonts when converting Note document.
     * </p>
     */
     public final IGenericList<KeyValuePair<String,String>> getFontSubstitutes(){ return auto_FontSubstitutes; }
     /**
     * <p>
     * Substitute specific fonts when converting Note document.
     * </p>
     */
     private void setFontSubstitutes(IGenericList<KeyValuePair<String,String>> value){ auto_FontSubstitutes = value; }
     private IGenericList<KeyValuePair<String,String>> auto_FontSubstitutes;
    
     /**
     * <p>
     * Set password to unprotect protected document
     * </p>
     */
     public final /*new*/String getPassword_OneLoadOptions_New(){ return auto_Password; }
     /**
     * <p>
     * Set password to unprotect protected document
     * </p>
     */
     public final /*new*/void setPassword_OneLoadOptions_New(String value){ auto_Password = value; }
     private String auto_Password;
    
    }
    ```
    
    Usage
    
    ```java
    ...
    ConversionConfig config = new ConversionConfig();
    ConversionHandler conversionHandler = new ConversionHandler(config);
    String source = "source.one";
    OneLoadOptions loadOptions = new OneLoadOptions();
    loadOptions.setDefaultFont("Helvetica");
    loadOptions.getFontSubstitutes().addItem(new KeyValuePair<String, String>("Arial", "Helvetica"));
    loadOptions.getFontSubstitutes().addItem(new KeyValuePair<String, String>("Harriet", "Transcript"));
    PdfSaveOptions saveOptions = new PdfSaveOptions();
    ConvertedDocument convertedDocument = conversionHandler.convert(source, loadOptions, saveOptions);
    convertedDocument.save("result");
    ...
    ```
    
7.  **Set default font when converting from Diagram**
    
    ```java
    /**
     * <p>
     * Diagram document load options
     * </p>
     */
    public class DiagramLoadOptions extends LoadOptions
    {
        /**
     * <p>
     * Default font for Diagram document. The following font will be used if a font is missing.
     * </p>
     */
     public final String getDefaultFont(){ return auto_DefaultFont; }
        /**
     * <p>
     * Default font for Diagram document. The following font will be used if a font is missing.
     * </p>
     */
     public final void setDefaultFont(String value){ auto_DefaultFont = value; }
        private String auto_DefaultFont;
    }
    ```
    
    Usage
    
    ```java
    ...
    ConversionConfig config = new ConversionConfig();
    ConversionHandler conversionHandler = new ConversionHandler(config);
    String source = "source.vsd";
    DiagramLoadOptions loadOptions = new DiagramLoadOptions();
    loadOptions.setDefaultFont("Helvetica");
    PdfSaveOptions saveOptions = new PdfSaveOptions();
    ConvertedDocument convertedDocument = conversionHandler.convert(source, loadOptions, saveOptions);
    convertedDocument.save("result");
    ...
    ```
    
8.  **Set default font when converting Psd, Emf, Wmf documents**
    
    ```java
    **
     * <p>
     * Image document load options
     * </p>
     */
    public class ImageLoadOptions extends LoadOptions
    {
        /**
     * <p>
     * Default font for Psd, Emf, Wmf document types. The following font will be used if a font is missing.
     * </p>
     */
     public final String getDefaultFont(){ return auto_DefaultFont; }
        /**
     * <p>
     * Default font for Psd, Emf, Wmf document types. The following font will be used if a font is missing.
     * </p>
     */
     public final void setDefaultFont(String value){ auto_DefaultFont = value; }
        private String auto_DefaultFont;
    }
    ```
    
    Usage
    
    ```java
    ...
    ConversionConfig config = new ConversionConfig();
    ConversionHandler conversionHandler = new ConversionHandler(config);
    String source = "source.psd";
    ImageLoadOptions loadOptions = new ImageLoadOptions();
    loadOptions.setDefaultFont("Helvetica");
    PdfSaveOptions saveOptions = new PdfSaveOptions();
    ConvertedDocument convertedDocument = conversionHandler.convert(source, loadOptions, saveOptions);
    convertedDocument.save("result"); 
    ...
    ```
