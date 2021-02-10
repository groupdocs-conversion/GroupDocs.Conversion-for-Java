![GitHub release (latest by date)](https://img.shields.io/github/v/release/groupdocs-conversion/GroupDocs.conversion-for-Java) ![GitHub](https://img.shields.io/github/license/groupdocs-conversion/GroupDocs.Conversion-for-Java)
# Document Conversion Java Library

GroupDocs.Conversion for Java is a [Document Conversion Library](https://products.groupdocs.com/conversion/java) designed to convert back and forth between over [50 types of documents and images](https://docs.groupdocs.com/conversion/java/supported-document-formats/), including all Microsoft Office and OpenDocument file formats, PDF documents, HTML, CAD, raster images (TIFF, JPEG, GIF, PNG, BMP) and more. 

<p align="center">

  <a title="Download complete GroupDocs.Conversion for Java source code" href="https://codeload.github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/zip/master">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

Directory | Description
--------- | -----------
[Docs](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Docs)  | Product documentation containing the Developer's Guide, Release Notes and more.
[Examples](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 
[Showcases](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Showcases)  | Build Document Conversion Applications using GroupDocs.Conversion for Java. 

## Universal Document Converter 

- Convert whole document to desired target format.
- [Convert specific document page(s) or page ranges](https://docs.groupdocs.com/conversion/java/convert-specific-pages/).
- Auto-detect source document format on the fly without requiring the file extension.
- Obtain a list of all supported conversion formats.
- Replace missing fonts.
- Add text or image watermarks to any page.
- Extract document's basic information.
- Load source document with extended options;
   - [Specify password for password-protected documents](https://docs.groupdocs.com/conversion/java/load-password-protected-document/).
   - Load specific part or pages of the document.
   - Hide or show document comments.

## Get Started with GroupDocs.Conversion for Java

GroupDocs.Conversion for Java requires J2SE 7.0 (1.7), J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already. 

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-conversion), so simply [configure](https://docs.groupdocs.com/conversion/java/installation/) your Maven project to fetch the dependencies automatically.

## Convert DOCX to HTML

```java
Converter converter = new Converter("sample.docx");
MarkupConvertOptions options = new MarkupConvertOptions();
converter.convert("ConvertToHtml.html", options);
```

## Convert PDF to DOCX

```java
Converter converter = new Converter("sample.pdf");
WordProcessingConvertOptions options = new WordProcessingConvertOptions();
converter.convert("converted.docx", options);
```

## Convert Word to Presentation

```java
Converter converter = new Converter("sample.docx");
PresentationConvertOptions options = new PresentationConvertOptions();
converter.convert("converted.pptx", options);
```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/conversion/java) | [Documentation](https://docs.groupdocs.com/conversion/java/) | [Demos](https://products.groupdocs.app/conversion/family) | [API Reference](https://apireference.groupdocs.com/java/conversion) | [Examples](https://github.com/groupdocs-conversion/GroupDocs.conversion-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/annotation/) | [Free Support](https://forum.groupdocs.com/c/conversion) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
