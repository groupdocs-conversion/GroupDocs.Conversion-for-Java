![GitHub release (latest by date)](https://img.shields.io/github/v/release/groupdocs-conversion/GroupDocs.conversion-for-Java) ![GitHub](https://img.shields.io/github/license/groupdocs-conversion/GroupDocs.Conversion-for-Java)
# Document Conversion Java Library

GroupDocs.Conversion for Java is a [Document Conversion Library](https://products.groupdocs.com/conversion/java) designed to convert back and forth between over [50 types of documents and images](https://docs.groupdocs.com/conversion/java/supported-document-formats/), including all Microsoft Office and OpenDocument file formats, PDF documents, HTML, CAD, raster images (TIFF, JPEG, GIF, PNG, BMP) and more.

## Important: Demo Applications Only

The projects in the [Demos](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Demos) folder and the Docker images published as [`groupdocs/conversion`](https://hub.docker.com/r/groupdocs/conversion) are **sample applications** intended to demonstrate [GroupDocs.Conversion for Java](https://products.groupdocs.com/conversion/java) features.

They are **not** production-ready services and must **not** be exposed to the public internet without additional hardening.

Before using a demo in any shared or production-like environment:

- Run it on `localhost` or a trusted private network only
- Do not publish Docker containers directly to the internet without authentication, a reverse proxy, and network restrictions
- Treat file upload, browse, and download features as untrusted input — validate and sandbox file paths in your own integration
- Add authentication, authorization, rate limiting, and logging appropriate for your security requirements
- Keep GroupDocs.Conversion and all dependencies up to date

For production integrations, use the library ([Examples](Examples), [documentation](https://docs.groupdocs.com/conversion/java/)) and implement your own secure document storage and API layer instead of deploying these demos as-is.

<p align="center">

  <a title="Download complete GroupDocs.Conversion for Java source code" href="https://codeload.github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/zip/master">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

Directory | Description
--------- | -----------
[Docs](https://github.com/groupdocs-conversion/GroupDocs.Conversion-Docs)  | Product documentation containing the Developer's Guide, Release Notes and more.
[Examples](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 
[Demos](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Demos)  | Build Document Conversion applications using GroupDocs.Conversion for Java.

## Demos

| Demo | Framework | Run command |
|------|-----------|-------------|
| [Spring](Demos/Spring) | Spring Boot 2.0 | `mvn clean spring-boot:run` |
| [Dropwizard](Demos/Dropwizard) | Dropwizard 1.3 | `mvn clean compile exec:java` |
| [Quarkus](Demos/Quarkus) | Quarkus | `./mvnw compile quarkus:dev` |
| [Ktor](Demos/Ktor) | Ktor | `./gradlew run` |
| [Servlets](Demos/GroupDocs.Conversion-for-java-using-servlets) | Java Servlets | `mvn jetty:run` |

All web demos run on `http://localhost:8080/conversion/`.

## Docker

Pre-built Docker images are available on [Docker Hub](https://hub.docker.com/r/groupdocs/conversion).

```bash
docker pull groupdocs/conversion:latest
docker run -p 8080:8080 groupdocs/conversion:latest
```

**Security notice:** Docker images ship with demo defaults (e.g. upload and browse enabled, no authentication). Use them for local evaluation only. Do not expose port `8080` to untrusted networks without adding authentication, path validation, and other security controls required by your organization.

Available image tags follow the pattern `{version}-java-{jdk}-bullseye-{framework}`:

| Tag | JDK | Framework |
|-----|-----|-----------|
| `{ver}-java-openjdk8-bullseye-spring` | Eclipse Temurin 8 | Spring |
| `{ver}-java-openjdk11-bullseye-spring` | Eclipse Temurin 11 | Spring |
| `{ver}-java-openjdk18-bullseye-spring` | Eclipse Temurin 21 | Spring |
| `{ver}-java-openjdk8-bullseye-dropwizard` | Eclipse Temurin 8 | Dropwizard |
| `{ver}-java-openjdk11-bullseye-dropwizard` | Eclipse Temurin 11 | Dropwizard |
| `{ver}-java-openjdk18-bullseye-dropwizard` | Eclipse Temurin 21 | Dropwizard |

The `latest` tag points to the `openjdk18-bullseye-spring` variant.

The [Docker Hub repository overview](https://hub.docker.com/r/groupdocs/conversion) is generated from [`docs/docker-hub-overview.md`](docs/docker-hub-overview.md) when the [Publish Docker Images](.github/workflows/docker-publish.yml) workflow runs with **Push** enabled.

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

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/conversion/java) | [Documentation](https://docs.groupdocs.com/conversion/java/) | [Demos](https://products.groupdocs.app/conversion/family) | [API Reference](https://apireference.groupdocs.com/java/conversion) | [Examples](https://github.com/groupdocs-conversion/GroupDocs.conversion-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/conversion/) | [Free Support](https://forum.groupdocs.com/c/conversion) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
