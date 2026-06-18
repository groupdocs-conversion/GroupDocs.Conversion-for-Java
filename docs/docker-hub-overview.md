### GroupDocs Document Conversion API

[Product Page](https://products.groupdocs.com/conversion/java) | [Docs](https://docs.groupdocs.com/conversion/java/) | [Demos](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Demos) | [API Reference](https://apireference.groupdocs.com/java/conversion) | [Examples](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/conversion/) | [Free Support](https://forum.groupdocs.com/c/conversion) | [Temporary License](https://purchase.groupdocs.com/temporary-license)

**GroupDocs.Conversion Demos** are applications that demonstrate powerful features of [GroupDocs.Conversion for Java](https://products.groupdocs.com/conversion/java) distributed as Docker images. Convert **DOCX, PDF, PPT, XLS**, and over 50 document formats without additional dependencies. Use these images as-is or customize and integrate them into your own project.

**Note:** without a license the application runs in trial mode. [Purchase a license](https://purchase.groupdocs.com/conversion/java) or request a [temporary license](https://purchase.groupdocs.com/temporary-license).

## Security Notice

These Docker images ship **sample/demo applications** — not production-ready services.

- Intended for **local development and evaluation** only
- Demo defaults enable upload, browse, and download; **no authentication** is included
- Do **not** expose port `8080` to untrusted networks without authentication, a reverse proxy, path validation, and other controls required by your organization
- For production, use the [GroupDocs.Conversion library](https://docs.groupdocs.com/conversion/java/) and implement your own secure document storage and API layer

Source code: [GroupDocs.Conversion-for-Java](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java)

## Supported Document Formats

| Family | Formats |
| --- | --- |
| Microsoft Word | DOC, DOCM, DOCX, DOT, DOTM, DOTX, RTF, TXT, ODT, OTT |
| Microsoft Excel | XLS, XLSB, XLSM, XLSX |
| Portable Document Format | PDF |
| Microsoft PowerPoint | PPT, PPS, PPTX, PPSX, ODP |
| Microsoft Visio | VSD, VSDX, VSS, VST, VSX, VTX, VDW, VDX, SVG |
| Microsoft Project | MPT, MPP |
| HTML | HTML |
| Image files | XPS, TIFF, TIF, JPEG, JPG, PNG, GIF, BMP, ICO, DXF, DWG, PSD |

See the [full list of supported formats](https://docs.groupdocs.com/conversion/java/supported-document-formats/) in the documentation.

## Document Conversion Demo Features

- Clean, modern and intuitive design
- Responsive design and mobile support
- Convert individual documents and batch convert multiple files
- Upload documents via drag and drop
- Download converted results
- Cross-browser and cross-platform support

## Available Docker Images

Six images are published for each GroupDocs.Conversion for Java release: three Spring and three Dropwizard variants.

Tag format: `{version}-java-{jdk}-bullseye-{framework}`

Example: `{{VERSION}}-java-openjdk8-bullseye-dropwizard` — GroupDocs.Conversion for Java **{{VERSION}}**, Eclipse Temurin 8, Debian Bullseye, Dropwizard.

| Tag | JDK | Framework |
| --- | --- | --- |
| `{{VERSION}}-java-openjdk8-bullseye-dropwizard` | Eclipse Temurin 8 | Dropwizard |
| `{{VERSION}}-java-openjdk11-bullseye-dropwizard` | Eclipse Temurin 11 | Dropwizard |
| `{{VERSION}}-java-openjdk18-bullseye-dropwizard` | Eclipse Temurin 21 | Dropwizard |
| `{{VERSION}}-java-openjdk8-bullseye-spring` | Eclipse Temurin 8 | Spring |
| `{{VERSION}}-java-openjdk11-bullseye-spring` | Eclipse Temurin 11 | Spring |
| `{{VERSION}}-java-openjdk18-bullseye-spring` | Eclipse Temurin 21 | Spring |

The `latest` tag points to the `{{VERSION}}-java-openjdk18-bullseye-spring` variant when published with the **latest** workflow option.

## How to Run

Pull and run a Dropwizard image:

```shell
docker run -p 8080:8080 --name conversion --rm groupdocs/conversion:{{VERSION}}-java-openjdk8-bullseye-dropwizard
# Open http://localhost:8080/conversion/ in your browser.
```

Bind volumes for sample files and license:

```shell
docker run -p 8080:8080 --name conversion --rm \
  -v "C:/DocumentSamples/:/home/groupdocs/app/DocumentSamples" \
  -v "C:/Licenses/:/home/groupdocs/app/Licenses" \
  groupdocs/conversion:{{VERSION}}-java-openjdk8-bullseye-dropwizard
```

The sample reads license files from the mounted `Licenses` directory and lists documents from `DocumentSamples`.

## Conversion Configuration Options

Environment variables:

| Variable | Description | Default |
| --- | --- | --- |
| `LIC_PATH` | Path to directory with license file | `/home/groupdocs/app/Licenses` |
| `DOWNLOAD_ON` | Enable download button in UI | `true` |
| `UPLOAD_ON` | Enable file upload | `true` |
| `BROWSE_ON` | Enable document browse dialog | `true` |
| `REWRITE` | Overwrite files with the same name on upload | `true` |
| `FILES_DIR` | Directory for uploaded files | `/home/groupdocs/app/DocumentSamples` |
| `RESULT_DIR` | Directory for converted output files | `/home/groupdocs/app/DocumentSamples/Conversion/Converted` |
| `HOST_ADDRESS` | Host name or IP for the server instance | (empty) |

## See Also

- [View documents](https://products.groupdocs.com/viewer/java) with GroupDocs.Viewer
- [Compare documents](https://products.groupdocs.com/comparison/java) with GroupDocs.Comparison
- [Sign documents](https://products.groupdocs.com/signature/java) with GroupDocs.Signature

[Product Page](https://products.groupdocs.com/conversion/java) | [Docs](https://docs.groupdocs.com/conversion/java/) | [Demos](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Demos) | [API Reference](https://apireference.groupdocs.com/java/conversion) | [Examples](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/conversion/) | [Free Support](https://forum.groupdocs.com/c/conversion) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
