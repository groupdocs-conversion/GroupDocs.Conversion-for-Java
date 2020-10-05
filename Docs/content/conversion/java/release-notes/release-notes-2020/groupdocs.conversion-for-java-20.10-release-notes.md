---
id: groupdocs-conversion-for-java-20-10-release-notes
url: conversion/java/groupdocs-conversion-for-java-20-10-release-notes
title: GroupDocs.Conversion for Java 20.10 Release Notes
weight: 16
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
## Major Features

There are 20+ features, improvements and bug-fixes in this release, most notable are:

*   Conversions from PST, OST - can convert each message, contact to different format
*   Now is possible to convert each email attachment to different format
*   Conversions from Oxps, Fods, Otg
*   Conversion to Fods
*   Improved caching
*   Introduced in-memory caching
*   Conversions from/to Md (markdown)
*   Conversions from/to Fodp
*   XML can be used as data source for conversion
*   Improved pst/ost documents info
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| CONVERSIONNET-3225 | Feature | Support for auto page numbering while export to PDF |
| CONVERSIONNET-3710 | Feature | Convert each email attachment to different type |
| CONVERSIONNET-3778 | Feature | Convert from PST, OST |
| CONVERSIONNET-3812 | Feature | Implement conversion from Oxps |
| CONVERSIONNET-3816 | Feature | Implement conversion from Fods |
| CONVERSIONNET-3822 | Feature | Implement conversion to Fods |
| CONVERSIONNET-3823 | Feature | Implement conversion from Otg |
| CONVERSIONNET-2875 | Feature | Introduced in memory caching |
| CONVERSIONNET-3659 | Improvement | Improve font substitution when converting from PDF |
| CONVERSIONNET-3874 | Improvement | Improved caching |
| CONVERSIONNET-3888 | Improvement | Improved document info for pst/ost documents |
| CONVERSIONNET-1702 | Bug | A generic error occurred in GDI+ while saving document to LZW TIFF |
| CONVERSIONNET-3699 | Bug | Exception while Converting PST to CSV using GroupDocs.Conversion .NET API v20.1.0 As The Not supported file type |
| CONVERSIONNET-3724 | Bug | Exception while Converting XLSB to XLS using GroupDocs.Conversion .NET API v20.1.0 |
| CONVERSIONNET-3729 | Bug | Exception while Converting XLSB to XLSX As The column index should not be inside the pivot table report |
| CONVERSIONNET-3745 | Bug | XLSB to XLS conversion issue  |
| CONVERSIONNET-3768 | Bug | "System.DllNotFoundException : Unable to load DLL 'libgdiplus': The specified module could not be found." exception on MacOS targeting .NET Standard |
| CONVERSIONNET-3770 | Bug | VSD to DOC conversion issue |
| CONVERSIONNET-3790 | Bug | Xps and Tex files are converted in trial mode when using venture licensing |
| CONVERSIONNET-3804 | Bug | PCL to DOT file conversion |
| CONVERSIONNET-3810 | Bug | XLSX to XLS conversion - The column index should not be inside the pivottable report |
| CONVERSIONNET-3821 | Bug | GroupDocs.Conversion.Exceptions.GroupDocsConversionException was unhandled |
| CONVERSIONNET-3680 | Bug | Exception while Converting TXT to CSV using GroupDocs.Conversion .NET API v20.1.0 |
| CONVERSIONNET-3694 | Bug | Exception while Converting PDF to XLSM using GroupDocs.Conversion .NET API v20.1.0 |
| CONVERSIONNET-3730 | Bug | Exception while Converting VSDX to XLSX using GroupDocs.Conversion .NET API v20.1 |
| CONVERSIONNET-3785 | Bug | Cc filed missing in EmailField  |
| CONVERSIONNET-3795 | Bug | PDF to XLSM Conversion issue |
| CONVERSIONNET-3818 | Bug | DOC to XLS conversion issue for a particular file |
| CONVERSIONNET-3820 | Bug | Can't convert docx to xls |
| CONVERSIONNET-3833 | Bug | VTX to JPG conversion issue |
| CONVERSIONNET-3850 | Bug | Xlsx to xlsm conversion issue  |
| CONVERSIONNET-3852 | Bug | Docx to csv conversion issue - cannot conver the file is corrupt or damaged |
| CONVERSIONNET-3876 | Bug | Exception if provided folder not exist in ost/pst documents |
| CONVERSIONNET-3878 | Bug | VTX to PNG conversion issue  |
| CONVERSIONNET-3879 | Bug | Cannot convert a particular eml file to xls |
| CONVERSIONNET-3884 | Bug | Implement conversion from CFF2 |
| CONVERSIONNET-3885 | Bug | PDF to TSV conversion issue |
| CONVERSIONNET-3890 | Bug | DOCX/DOC to XLS conversion issue |
| CONVERSIONNET-3894 | Bug | TXT to CSV/XLSX conversion issue |
| CONVERSIONNET-3926 | Bug | HTML to XLS conversion issue |
| CONVERSIONNET-3928 | Bug | Doc to Xlsx conversion issue |
| CONVERSIONNET-3938 | Bug | Wrong Height and Width are returning from GetDocumentInfo method  |
| CONVERSIONJAVA-704 | Bug | CrossTableNotFoundException when converting a particular PDF to Image |
| CONVERSIONJAVA-818 | Bug | Issue in converting a Word file to PDF with Arabic font |
| CONVERSIONJAVA-844 | Bug | Error in converting a particular DOCX to PDF |
| CONVERSIONJAVA-933 | Bug | Absolute URI is too short |
| CONVERSIONJAVA-993 | Bug | DWG to JPG ImageSaveException (java heap space) |

## Public API and Backward Incompatible Changes

1.  **Converter class has new constructor overloads**
   ```java
   /**
   * Initializes new instance of Converter class.
   * @param document    A readable stream.
   * @param loadOptions The methods that returns document load options.
   */
   public Converter(InputStream document, Func1<FileType, LoadOptions> loadOptions)
    
    
    /**
    * Initializes new instance of Converter class.
    * @param document    The method that returns readable stream.
    * @param loadOptions The methods that returns document load options.
    * @param settings    The Converter settings.
    */
    public Converter(InputStream document, Func1<FileType, LoadOptions> loadOptions, ConverterSettings settings)
    
    /**
    * Initializes new instance of Converter class.
    * @param filePath    The file path to the source document.
    * @param loadOptions The document load options.
    */
    public Converter(String filePath, Func1<FileType, LoadOptions> loadOptions)
    
    /**
    * Initializes new instance of Converter class.
    * @param filePath    The file path to the source document.
    * @param loadOptions The document load options.
    * @param settings    The Converter settings.
    */
    public Converter(String filePath, Func1<FileType, LoadOptions> loadOptions, ConverterSettings settings) 
   ```
    
    Usage
```java
Func1<FileType, LoadOptions> loadOptions = new Func1<FileType, LoadOptions>() {
	@Override
	public LoadOptions invoke(FileType sourceType) {
		if (sourceType == EmailFileType.Msg) {
			EmailLoadOptions emailLoadOptions = new EmailLoadOptions();
			emailLoadOptions.setConvertOwned(true);
			emailLoadOptions.setConvertOwner(true);
			return emailLoadOptions;
		}
		return null;
	}
};
String source = "sample.docx";
Converter converter = new Converter(source, loadOptions);
try {
	...
} finally {
	converter.dispose();
}
```
2.  **Convert method in Converter class has new overloads**
    ```java
    /**
    * Converts source document. Saves the whole converted document.
    * @param document               The stream.
    * @param convertOptionsProvider Convert options provider. Will be called for each conversion to provide specific convert options to desired target document type.
    */
    public void convert(SaveDocumentStream document, ConvertOptionsProvider convertOptionsProvider) 
     
    /**
    * Converts source document. Saves the whole converted document.
    * @param document               The stream.
    * @param documentCompleted      The delegate that receive converted document stream.
    * @param convertOptionsProvider Convert options provider. Will be called for each conversion to provide specific convert options to desired target document type.
    */
    public void convert(SaveDocumentStream document, ConvertedDocumentStream documentCompleted, ConvertOptionsProvider convertOptionsProvider)
    
    /**
    * Converts source document. Saves the whole converted document.
    * @param document       The delegate that saves converted document to a stream.
    * @param convertOptions The convert options specific to desired target file type.
    */
    public void convert(SaveDocumentStreamForFileType document, ConvertOptions convertOptions)
    
    /**
    * Converts source document. Saves the whole converted document.
    * @param document          The delegate that saves converted document to a stream
    * @param documentCompleted The delegate that receive converted document stream
    * @param convertOptions    The convert options specific to desired target file type
    */
    public void convert(SaveDocumentStreamForFileType document, ConvertedDocumentStream documentCompleted, ConvertOptions convertOptions)
    
    /**
    * Converts source document. Saves the whole converted document.
    * @param document               The delegate that saves converted document to a stream.
    * @param convertOptionsProvider Convert options provider. Will be called for each conversion to provide specific convert options to desired target document type.
    */
    public void convert(SaveDocumentStreamForFileType document, ConvertOptionsProvider convertOptionsProvider)
    
    /**
    * Converts source document. Saves the whole converted document.
    * @param document               The delegate that saves converted document to a stream.
    * @param documentCompleted      The delegate that receive converted document stream.
    * @param convertOptionsProvider Convert options provider. Will be called for each conversion to provide specific convert options to desired target document type.
    */
    public void convert(SaveDocumentStreamForFileType document, ConvertedDocumentStream documentCompleted, ConvertOptionsProvider convertOptionsProvider)
    
    /**
    * Converts source document. Saves the converted document page by page.
    * @param document       The output stream.
    * @param convertOptions The convert options specific to desired target file type.
    */
    public final void convertPageByPage(final OutputStream document, final ConvertOptions convertOptions)
    
    /**
    * Converts source document. Saves the converted document page by page.
    * @param document          The output stream.
    * @param documentCompleted The delegate that receive converted document page stream.
    * @param convertOptions    The convert options specific to desired target file type.
    */
    public void convert(final OutputStream document, ConvertedPageStream documentCompleted, final ConvertOptions convertOptions)
    
    /**
    * Converts source document. Saves the converted document page by page.
    * @param document               The output stream.
    * @param convertOptionsProvider Convert options provider. Will be called for each conversion to provide specific convert options to desired target document type.
    */
    public void convert(final OutputStream document, ConvertOptionsProvider convertOptionsProvider)
    
    /**
    * Converts source document. Saves the converted document page by page.
    * @param document          The delegate that saves converted document page to a stream.
    * @param documentCompleted The delegate that receive converted document page stream.
    * @param convertOptions    The convert options specific to desired target file type.
    */
    public void convert(SavePageStreamForFileType document, ConvertedPageStream documentCompleted, final ConvertOptions convertOptions)
    
    /**
    * Converts source document. Saves the converted document page by page.
    * @param document               The delegate that saves converted document to a stream.
    * @param convertOptionsProvider Convert options provider. Will be called for each conversion to provide specific convert options to desired target document type.
    */
    public void convert(SavePageStreamForFileType document, ConvertOptionsProvider convertOptionsProvider)
    
    /**
    * Converts source document. Saves the converted document page by page.
    * @param document               The delegate that saves converted document page to a stream.
    * @param documentCompleted      The delegate that receive converted document page stream.
    * @param convertOptionsProvider Convert options provider. Will be called for each conversion to provide specific convert options to desired target document type.
    */
    public void convert(final SavePageStreamForFileType document, ConvertedPageStream documentCompleted, ConvertOptionsProvider convertOptionsProvider)
    ```
    
    Usage
    
    ```java
    Func1<FileType, LoadOptions> loadOptionsProvider = new Func1<FileType, LoadOptions>() {
        @Override
        public LoadOptions invoke(FileType sourceType) {
            if (sourceType == EmailFileType.Msg) {
                EmailLoadOptions emailLoadOptions = new EmailLoadOptions();
                emailLoadOptions.setConvertOwned(true);
                emailLoadOptions.setConvertOwner(true);
                return emailLoadOptions;
            }
            return null;
        }
    };

    SaveDocumentStream stream = new SaveDocumentStream() {
        @Override
           public Stream invoke() {
            return new FileStream("converted-{index++}.{targetType.Extension}", FileMode.Create);
        }
    };
        
    ConvertOptionsProvider convertOptionsProvider = new ConvertOptionsProvider() {
        @Override
        public ConvertOptions invoke(String sourceDocumentName, FileType sourceType) {
            if (sourceType == WordProcessingFileType.Doc) {
                ImageConvertOptions result = new ImageConvertOptions();
                result.setFormat(ImageFileType.Tiff);
                return result;
            } else if (sourceType == EmailFileType.Msg) {
                return new PdfConvertOptions();
            } else if (sourceType == ImageFileType.Png) {
                ImageConvertOptions result = new ImageConvertOptions();
                result.setFormat(ImageFileType.Jpeg);
                return result;
            }
            return new PdfConvertOptions();
        }
    };

    String source = "sample.docx";
    Converter converter = new Converter(source, loadOptionsProvider);
    try {
        Converter.convert(stream, convertOptionsProvider);
    } finally {
        converter.dispose();
    }
    ```
3.  **New delegates are introduced**
    ```java
    /**
     * Describes delegate for saving converted document into stream.
     */
    public abstract class SaveDocumentStreamForFileType
    /**
    * <p>
    * Saves converted document into stream.
    * </p>
    * @param fileType Converted document type
    * @return Must return a stream where the converted document will be saved
    */
    public abstract Stream invoke(FileType fileType);
    
    **
     * Describes delegate for saving converted document page into stream.
     */
    public abstract class SavePageStreamForFileType    
    /**
    * <p>
    * Saves converted document page into stream.
    * </p>
    * @param pageNumber Converted page number
    * @param fileType Converted document type
    * @return Must return a stream where the converted document page will be saved
    */
    public abstract Stream invoke(int pageNumber, FileType fileType)
    
    /**
     * Describes delegate to provide convert options for specific source document.
     * The delegate will be called before each conversion and provide a chance to provide specific convert options for desired target conversion.
     * The decision could be made based on provided source file name and source file type.
     */
    public abstract class ConvertOptionsProvider
    /**
    * <p>
    * Provides convert options for specific source document.
    * </p>
    *
    * @param sourceDocumentName Source file name
    * @param sourceType         Source file type
    * @return Must return ConvertOptions to be used for conversion of FileType sourceType< document
    */
    public abstract ConvertOptions invoke(String sourceDocumentName, FileType sourceType)
    ```
4.  **FormatingOptions in PdfOptions class is marked as obsolete**
    FormattingOptions must be used
5.  **DefaultFont in GroupDocs.Conversion.ConverterSettings class is marked as obsolete**
    DefaultFont in specific ConvertOptions instance must be used.
6.  **ConvertAttachments in EmailLoadOptions class is marked as obsolete**
    ConvertOwned must be used
7.  **Introduced new class GroupDocs.Conversion.Contracts.PersonalStorageDocumentInfo**
    
    ```java
    /**
     * Contains personal storage document metadata
     */
    public class PersonalStorageDocumentInfo extends DocumentInfo {  
    
        public PersonalStorageDocumentInfo(PersonalStorage storage, FileType format, long size) 
    
        /**
         * Is storage password protected
         */
        public boolean isPasswordProtected() 
    
        /**
         * Root folder name
         *
         * @return Root folder name
         */
        public String getRootFolderName() 
    
        /**
         * Get count of contents in the root folder
         *
         * @return count of contents in the root folder
         */
        public int getContentCount() 
    
        /**
         * Folders in the storage
         *
         * @return Folders in the storage
         */
        public List<String> getFolders() 
    }
    ```
    
    Usage
    
    ```java
    String source = "ContactsExport.pst";
    Converter converter = new Converter(source);
    try {
        IDocumentInfo documentInfo = converter.getDocumentInfo();
        PersonalStorageDocumentInfo pstInfo = (PersonalStorageDocumentInfo) documentInfo;
        for(String folder : pstInfo.getFolders())
        {
            System.out.println(folder);
        }
    } finally {
        converter.dispose();
    }
    ```
    
8.  **Introduced new property in class XmlLoadOptions**
    
    ```java
    /**
     * Use Xml document as data source
     * @return true if use
     */
    public boolean isUseAsDataSource()

    /**
     * Set use Xml document as data source
     * @param useAsDataSource use Xml document as data source
     */
    public void setUseAsDataSource(boolean useAsDataSource) 
    ```
    
    Usage
    
    ```java
    String source = "sample.xml";
    Converter converter = new Converter(source, new Func1<FileType, LoadOptions>() {
        @Override
        public LoadOptions invoke(FileType arg) {
            XmlLoadOptions loadOptions = new XmlLoadOptions();
            loadOptions.setUseAsDataSource(true);
            return loadOptions;
        }
    });
    try {
        SpreadsheetConvertOptions options = new SpreadsheetConvertOptions();
        converter.convert("converted.xlsx" , options);
    } finally {
        converter.dispose();
    }
    ```
