---
id: groupdocs-conversion-for-java-20-6-release-notes
url: conversion/java/groupdocs-conversion-for-java-20-6-release-notes
title: GroupDocs.Conversion for Java 20.6 Release Notes
weight: 19
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
## Major Features

There are 20+ features, improvements and bug-fixes in this release, most notable are:

*   Legacy API is removed from the product
*   Now client application can hookup to converter and monitor for start, progress and complete states
*   Improved MPP to spreadsheet conversions    
*   XML documents can be converted to any format without transformation    
*   Call ConvertedDocumentStream or ConvertedPageStream delegates providing converted stream for processing or storing.    
*   Introduced EML to MSG conversions
*   API to retrieve prepared default ConvertOptions for desired target conversion
*   Introduced GetAllPossibleConversions method which return all supported conversions
*   GetPossibleConversions method from a documetn extension without instantiating a Converter
*   GetPossibleConversions for currently provided source document
*   Improved document info classes
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-3460 | Feature | Provide information for conversion start, end and progress |
| CONVERSIONNET-3539 | Feature | Convert xml documents without transformation |
| CONVERSIONNET-3290 | Feature | EML to MSG conversion |
| CONVERSIONNET-3512 | Feature | API to retrieve prepared default ConvertOptions for desired target conversion |
| CONVERSIONNET-3536 | Feature | Convert attachments from a mail document |
| CONVERSIONNET-3586 | Feature | GetAllPossibleConversions method which returns all supported conversions |
| CONVERSIONNET-3587 | Feature | GetPossibleConversions for a document extension without instantiating a Converter |
| CONVERSIONNET-3345 | Improvement | MPP to XLS conversion improvement and missing information |
| CONVERSIONNET-3526 | Improvement | New overload Convert methods which accepts ConvertedDocumentStream or ConvertedPageStream delegates |
| CONVERSIONNET-3597 | Improvement | Improve document info classes  |
| CONVERSIONNET-3626 | Improvement | Make proportional image If only Width or Height is provided when converting to image |
| CONVERSIONNET-2819 | Bug | Fail to convert a specific word document to pdf |
| CONVERSIONNET-3420 | Bug | Other than PNG to PDF conversion throw exception for PNG source file |
| CONVERSIONNET-3423 | Bug | "System.DllNotFoundException: Unable to load DLL ?gdiplus?" exception when targeting .NET Standard 2.0 under MacOS |
| CONVERSIONNET-3424 | Bug | Compatibility issues under .NET Standard 2.0 |
| CONVERSIONNET-2922 | Bug | Error converting RTL html to PDF |
| CONVERSIONNET-3357 | Bug | Cross reference table or cross reference stream not found exception thrown when converting a particular PDF to image |
| CONVERSIONNET-3507 | Bug | Convert from XML to any format throw exception - The file is corrupt or damaged. |
| CONVERSIONNET-3508 | Bug | Exception "The process cannot access the file because it is being used by another process." when converting to file |
| CONVERSIONNET-3525 | Bug | Convert to image doesn't release the last image |
| CONVERSIONNET-3534 | Bug | Pages limit for TXT file adds additional empty page at the end |
| CONVERSIONNET-3556 | Bug | GroupDocs.Conversion.Legacy.License not working with Word Documents |
| CONVERSIONNET-3576 | Bug | Email to Excel Conversion Issue |
| CONVERSIONNET-3581 | Bug | Email to Word or PDF License Not working |
| CONVERSIONNET-3625 | Bug | PageNumber and PagesCount not respected when converting to image |
| CONVERSIONNET-3634 | Bug | 'Index was out of range.' exception when converting particular mpx file to html |

## Public API and Backward Incompatible Changes

1.  **GroupDocs.Conversion.ConverterSettings.Listener**  
    
    Introduced new property Listener
    
    ```java
    /**
     * Gets the converter listener implementation used for monitoring conversion status and progress
     * @return The converter listener
     */
    public IConverterListener getListener() {
        return listener;
    }
    
    /**
     * Sets the converter listener implementation used for monitoring conversion status and progress
     * @param listener The converter listener
     */
    public void setListener(IConverterListener listener) {
        this.listener = listener;
    }
    ```
       
    ```java
    ConverterSettings settings = new ConverterSettings();
    settings.setListener(new ConverterListener());
    ```
    
    **ConverterListener** is a class which implement **IConverterListener** interface:
    
    ```java
    public class ConverterListener implements IConverterListener {
       @Override
     public void started() {
          System.out.println("Conversion started...");
       }
    
       @Override
     public void progress(byte current) {
          System.out.println("... "+ current +" % ...");
       }
    
       @Override
     public void completed() {
          System.out.println("... conversion completed");
       }
    }
    ```
    
2.  **GroupDocs.Conversion.Converter.Convert overloads**  
    
    Introduced new overloads of Convert method
    
    ```java
    /**
     * Converts source document. Saves the whole converted document.
     *
     * @param document output stream
     * @param documentCompleted the delegate that receive converted document stream.
     * @param convertOptions the convert options specific to desired target file type.
     */
    public void convert(final OutputStream document, ConvertedDocumentStream documentCompleted, ConvertOptions convertOptions) {...}
         
    /**
     * Converts source document. Saves the converted document page by page.
     *
     * @param document The delegate that saves converted document page to a stream.
     * @param documentCompleted The delegate that receive converted document page stream.
     * @param convertOptions The convert options specific to desired target file type.
     */
    public void convert(final OutputStream document, ConvertedPageStream documentCompleted, ConvertOptions convertOptions) {...}  
    ```
    
    From v20.6 of GroupDocs,Conversion stream created from SaveDocumentStream/SavePageStream delegate is disposed automatically. In order to be able to store converted document stream to file system or database, each time when converted document stream is read the delegates ConvertedDocumentStream/ConvertedPageStream are invoked. 
        
    
    ```java
    String fileName = "source.docx";
    try(FileInputStream fileInputStream = new FileInputStream(fileName)) {
       Converter converter = new Converter(fileInputStream);
    
       ConvertOptions options = new PdfConvertOptions();
       converter.convert(outputStream, new ConvertedDocumentStream() {
          @Override
      public Stream invoke(Stream converted) {
             try(FileOutputStream fileStream = new FileOutputStream("converted.pdf")) {
                converted.copyTo(fileStream);
             } catch (IOException e) {
                ...
             }
             return null;
          }
       }, options);
    
    }
    ```
    
3.  **XML documents can be converted without transformations**  
    
    XML document can be converted without transformations
    
    ```java
    Converter converter = new Converter("sitemap.xml");
    ConvertOptions options = new PdfConvertOptions();
    converter.convert("converted.pdf", options);
    ```
    
4.  **GroupDocs.Conversion.Contracts.PossibleConversions**  
    
    Introduced new class PossibleConversions
    
    ```java
    /**
     * Represents a mapping what conversion pairs are supported for specific source file format
     */
    public final class PossibleConversions extends ValueObject {
        public static final PossibleConversions NULL = new PossibleConversions(FileType.Unknown);
    
     /**
     * Creates possible conversion list for specified source file format
     *
     * @param source source file type
     */
     public PossibleConversions(FileType source) {
          ...
     }
    
     /**
     * All target file types and primary/secondary flag
     *
     * @return Iterable of {@link TargetConversion}
     */
     public Iterable<TargetConversion> getAll() {
            ...
     }
    
     /**
     * Returns target conversion for specified target file type
     *
     * @param target target file type
     * @return conversions
     */
     public TargetConversion getTargetConversion(FileType target) {
            ...
     }
    
     /**
     * Returns target conversion for specified target file type extension
     */
     public TargetConversion getTargetConversion(String extension) {
           ...
        }
    
     /**
     * Primary target file types
     *
     * @return primary target file types
     */
     public Iterable<FileType> getPrimary() {
            ...
     }
    
     /**
     * Secondary target file types
     *
     * @return secondary target file types
     */
     public Iterable<FileType> getSecondary() {
            ...
     }
    
    }
    ```
        
    ```java
    Converter converter = new Converter("source.docx");
    PossibleConversions possibleConversions = converter.getPossibleConversions();
    ```
      
    
5.  **GroupDocs.Conversion.Contracts.TargetConversion**  
    
    Introduced new class TargetConversion
    
    ```java
    /**
     * Represents possible target conversion and a flag is it a primary or secondary
     */
    public final class TargetConversion {
    
     /**
     * Target document format
     * @return Target document format
     */
     public FileType getFormat() {
            ...
     }
    
     /**
     * Is the conversion primary
     * @return <code>true</code> if primary
     */
     public boolean isPrimary() {
            ...
     }
    
     /**
     * Predefined convert options which could be used to convert to current type
     * @return convert options
     */
     public ConvertOptions getConvertOptions() {
            ...
     }
    } 
    ```
    
    ```java
    Converter converter = new Converter("source.docx");
    PossibleConversions possibleConversions = converter.getPossibleConversions();
    TargetConversion targetConversion = possibleConversions.getTargetConversion("pdf");
    if (targetConversion != null) {
       ConvertOptions convertOptions = targetConversion.getConvertOptions();
    }
    ```
    
6.  **GroupDocs.Conversion.Converter.GetAllPossibleConversions**  
    
    Introduced new static method GetAllPossibleConversions in Converter class
    
    ```java
    /**
     * Gets all supported conversions
     *
     * @return supported conversions
     */
    public static List<PossibleConversions> getAllPossibleConversions() {
        ...
    }
    ```
    
    ```java
    List<PossibleConversions> allPossibleConversions = Converter.getAllPossibleConversions();
    for (PossibleConversions possibleConversions : allPossibleConversions) {
       System.out.println("Source format:" + possibleConversions.getSource().getDescription());
       for (FileType primary : possibleConversions.getPrimary()) {
          System.out.println("\t-->" + primary.getDescription());
       }
       for (FileType secondary : possibleConversions.getSecondary())
       {
          System.out.println("\t-->" + secondary.getDescription());
       }
    
    }
    ```
    
7.  **GroupDocs.Conversion.Converter.GetPossibleConversions**  
    
    Introduced new method GetPossibleConversions in Converter class
    
    ```java
    /**
     * Gets all supported conversions
     *
     * @return supported conversions
     */
    public static List<PossibleConversions> getAllPossibleConversions()
    ```

    ```java
    Converter converter = new Converter("source.docx");
    PossibleConversions possibleConversions = converter.getPossibleConversions();    
        ...
    ```   
    
    Introduced new static method GetPossibleConversions in Converter class
    
    ```java
    /**
     * Gets supported conversions for provided document extension
     * <example>Converter.GetPossibleConversions(".docx")</example>
     * <example>Converter.GetPossibleConversions("docx")</example>
     *
     * @param extension Document extension
     * @return possible conversions
     */
    public static PossibleConversions getPossibleConversions(String extension)
    ```
        
    ```java
    PossibleConversions possibleConversions = Converter.getPossibleConversions("docx");
    TargetConversion targetConversion = possibleConversions.getTargetConversion("pdf"); // docx -> pdf
    ConvertOptions convertOptions = targetConversion != null ? targetConversion.getConvertOptions() : null;
    ```
    
8.  **GroupDocs.Conversion.Legacy**
    
    {{< alert style="danger" >}}We have removed all public types form GroupDocs.Conversion.Legacy namespace.{{< /alert >}}
    
9.  **GroupDocs.Conversion.Options.Convert.EmailConvertOptions**  
    
    Introduced new class EmailConvertOptions
    
    ```java
    /**
     * Options for conversion to Email file type.
     */
    public class EmailConvertOptions extends ConvertOptions<EmailFileType> {
    
    }
    ```
    
    ```java
    Converter converter = new Converter("source.eml");
    ConvertOptions convertOptions = new EmailConvertOptions();
    convertOptions.setFormat(EmailFileType.Msg);
    converter.convert("converted.msg",  convertOptions);
    ```
    
    
10.  **GroupDocs.Conversion.Options.Load.EmailLoadOptions**      
    Introduced new property ConvertAttachments in EmailLoadOptions  
    
```java
    //Get option to convert attachments in source email or not. Default: false.
    //@return Option to convert attachments in source email or not. Default: false.   
    public boolean isConvertAttachments() {
        return convertAttachments;
    }

    /**
        * Set option to convert attachments in source email or not
        * @param convertAttachments Option to convert attachments in source email or not.
        */
    public void setConvertAttachments(boolean convertAttachments) {
        this.convertAttachments = convertAttachments;
    }
```

```java
    String source = "sample-with-attachment.eml";
    EmailLoadOptions loadOptions = new EmailLoadOptions();
    loadOptions.setConvertAttachments(true);
    Converter converter = new Converter(source, loadOptions);
    int index = 1;
    ConvertOptions options = new PdfConvertOptions();
    converter.convert(new FileOutputStream(String.format("converted-%d.pdf", index)), options);    
```
