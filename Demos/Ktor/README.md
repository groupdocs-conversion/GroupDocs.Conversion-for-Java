![GroupDocs.Conversion](https://raw.githubusercontent.com/groupdocs-Conversion/groupdocs-Conversion.github.io/master/resources/image/banner.png "GroupDocs.Conversion")
# GroupDocs.Conversion for Java Ktor Example
New GroupDocs.Conversion for Java Ktor UI Example
###### version 23.5

[![GitHub license](https://img.shields.io/github/license/groupdocs-Conversion/GroupDocs.Conversion-for-Java-Spring.svg)](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java-Spring/blob/master/LICENSE)

## System Requirements
- Java 11+ (JDK 11+)


## Compare documents with Java API

**GroupDocs.Conversion for Java** is a library that allows you to **compare PDF, DOCX, PPT, XLS,** and over 90 other document formats. With GroupDocs.Conversion for Java you will be able to compare two or more files, perform style and text Conversion and generate a detailed report with changes.

This application allows you to compare multiple documents and can be used as a standalone application or integrated as part of your project.

**Note:** without a license application will run in trial mode, purchase [GroupDocs.Conversion for Java license](https://purchase.groupdocs.com/order-online-step-1-of-8.aspx) or request [GroupDocs.Conversion for Java temporary license](https://purchase.groupdocs.com/temporary-license).


## Demo Video

<p align="center">
  <a title="Document Conversion for JAVA " href="https://www.youtube.com/watch?v=82RuvtV2qpw"> 
    <img src="https://raw.githubusercontent.com/groupdocs-Conversion/groupdocs-Conversion.github.io/master/resources/image/Conversion.gif" width="100%" style="width:100%;">
  </a>
</p>


## Features
#### GroupDocs.Conversion
- Clean, modern and intuitive design
- Easily switchable colour theme (create your own colour theme in 5 minutes)
- Responsive design
- Mobile support (open application on any mobile device)
- HTML and image modes
- Fully customizable navigation panel
- Compare documents
- Multi-compare several documents
- Compare password protected documents
- Upload documents
- Display clearly visible differences
- Download Conversion results
- Print Conversion results
- Smooth document scrolling
- Preload pages for faster document rendering
- Multi-language support for displaying errors
- Cross-browser support (Safari, Chrome, Opera, Firefox)
- Cross-platform support (Windows, Linux, MacOS)


## How to run

You can run this sample by one of following methods


#### Run using IDE

Download [source code](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/releases/download/v23.5/groupdocs-Conversion-ktor-23.5.0.zip) from github or clone this repository.

```bash
git clone https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java.git
cd GroupDocs.Conversion-for-Java/Demos/Ktor
```
Open project in IDE. Open `Application.kt` file and run `main` method inside it. Then open [http://localhost:8080/Conversion/](http://localhost:8080/Conversion/) in your favorite browser.

#### Run from command line

Download [source code](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/archive/refs/heads/master.zip) from github.

Alternatively you can clone this repository using next command
```bash
git clone https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java.git
```

Run sample from Windows PowerShell or Linux Terminal using next commands

```bash
cd GroupDocs.Conversion-for-Java/Demos/Ktor
.\gradlew.bat :run
```

Open [http://localhost:8080/Conversion/](http://localhost:8080/Conversion/) in your favorite browser.

#### Build distribution archive

Download [source code](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/archive/refs/heads/master.zip) from github.

Alternatively you can clone this repository using next command
```bash
git clone https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java.git
```

Run sample from Windows PowerShell or Linux Terminal using next commands

```bash
cd GroupDocs.Conversion-for-Java/Demos/Ktor
.\gradlew.bat :build
```

After that, go to `.\build\distributions\` directory to get distribution files.

#### Binary release (with all dependencies) for Linux

Download [latest release](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/releases/latest) from [releases page](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/releases).

**Note**: This method is **recommended** for running this sample behind firewall.

```bash
curl -J -L -o release.tar.gz https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/releases/download/v23.5/groupdocs-Conversion-ktor-23.5.0.tar
tar -xvzf release.tar.gz
cd release/Conversion-ktor-23.5
## Make `bin/Conversion-ktor` file to be runnable
bin/Conversion-ktor
## Open http://localhost:8080/Conversion/ in your favorite browser.
```

## Configuration
You can adjust settings in `/src/main/resources/application.conf`. Specify relative/absolute path to license file by setting `licensePath` value in `/src/main/resources/application.conf` or by setting up `LIC_PATH` environment variable

### Conversion configuration options

| Option                 | Type    |     Default value     | Description                                                                                                          |
|------------------------| ------- |:---------------------:|:---------------------------------------------------------------------------------------------------------------------|
| **`filesDirectory`**   | String  |   `DocumentSamples`   | Files directory path. Indicates where uploaded and predefined files are stored. It can be absolute or relative path  |
| **`tempDirectory`**    | String  | system temp directory | Absolute or relative path to directory to save temporary files                                                       |
| **`resultDirectory`**  | String  |     `ResultFiles`     | Result files directory path. Directory must be created before app starts                                             |

## License
The MIT License (MIT). 

Please have a look at the LICENSE.md for more details

## GroupDocs Conversion on other platforms & frameworks

- [Compare documents](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/tree/master/Demos/Compose) with Kotlin in Compose Desktop application
- [Compare documents](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/tree/master/Demos/Dropwizard) with JAVA Dropwizard
- [Compare documents](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/tree/master/Demos/Javalin) with Javalin application
- [Compare documents](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/tree/master/Demos/Spring) with Spring application
- [Compare documents](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-.NET-MVC) with .NET MVC 
- [Compare documents](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-.NET-WebForms) with .NET WebForms 


[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/Conversion/java) | [Documentation](https://docs.groupdocs.com/Conversion/java/) | [Demos](https://products.groupdocs.app/Conversion/family) | [API Reference](https://apireference.groupdocs.com/java/Conversion) | [Examples](https://github.com/groupdocs-Conversion/GroupDocs.Conversion-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/Conversion/) | [Free Support](https://forum.groupdocs.com/c/Conversion) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
