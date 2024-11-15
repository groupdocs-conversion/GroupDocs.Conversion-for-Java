# GroupDocs.Conversion for Java Examples

## Overview

This package contains [examples](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Examples) that will help you in understanding the API's working and writing your own applications.

GroupDocs.Conversion for Java is a powerful API that enables developers to detect changes between source and target files at paragraph, word, and character levels. Identify styling and formatting changes such as bold, italic, underlines, strike-throughs, font types, and more. This [Examples](https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/tree/master/Examples) will help you get started with integrating conversion features into your Java applications.

<p align="center">

<a title="Download complete GroupDocs.Conversion for Java source code" href="https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java/archive/master.zip">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

---

## Technical details

### Running the Examples

1. Ensure Maven is installed and configured in your system path.
2. Clone (using command `git clone https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-Java.git`) or download the repository from GitHub.
3. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans).

You may find following resources helpful:

1. Learn how to [install and configure](http://www.tutorialspoint.com/maven/maven_environment_setup.htm) Maven - Environment Setup
2. Maven [support](http://www.tutorialspoint.com/maven/maven_netbeans.htm) for NetBeans
3. Maven [support](http://www.tutorialspoint.com/maven/maven_intellij_idea.htm) for IntelliJ IDEA
4. Maven [support](http://www.tutorialspoint.com/maven/maven_eclispe_ide.htm) for Eclipse IDE

#### Running the Examples as a Program Using Maven and Command Line Interface

To run the examples, execute the following command in your terminal or command prompt:
```shell
mvn clean compile exec:java
```

_You can add the option `-Dgroupdocs.license.path=/home/user/GroupDocs.License.lic` to specify the path to your license._

### Running the Examples as a Unit Tests Using Maven and Command Line Interface

```shell
mvn clean compile test
```

_You can add the option `-Dgroupdocs.license.path=/home/user/GroupDocs.License.lic` to specify the path to your license._

#### Running from an Integrated Development Environment (IDE) as a Program

1. Import the Maven project into your preferred IDE, ensuring it is set up to use Maven.
2. Ensure the `src/main/java` directory is marked as a source root.
3. Locate the `com.groupdocs.examples.conversion` package and navigate to its contents.
4. Identify the `Main.java` class within this package.
5. Right-click on `Main.java` and select "Run Main.main()" or equivalent action in your IDE to execute the project.

#### Running from an Integrated Development Environment (IDE) as Unit Tests

1. Import the Maven project into your preferred IDE, ensuring it is set up to use Maven.
2. Ensure the `src/main/java` directory is marked as a source root and `src/test/java` is marked as a tests root.
3. Locate the `com.groupdocs.examples.conversion` package in `src/test/java` directory and navigate to its contents.
4. Run the tests individually or collectively using the "Run All Tests" option in your IDE.

#### Running as a Docker container

You can use the following command to run samples as a Docker container:

```shell
# Put GroupDocs license file into the project root directory with name `GroupDocs.License.lic`
docker-compose up --build
```

### Licensing

The `com.groupdocs.examples.conversion.utils.LicenseUtils#createLicenseStream()` method creates a license input stream by searching for a valid license file from various predefined locations.

#### Priority Sources

The following sources are prioritized in order to obtain a license file:

1. **System Property**
  Check the system property `groupdocs.license.path`.

    ```shell
      mvn clean compile exec:java -Dgroupdocs.license.path=/home/user/GroupDocs.License.lic
    ```

2. **Environment Variables**
  Check environment variables in this order:

    1. `LIC_GROUPDOCS`
   
       ```shell
         export LIC_GROUPDOCS=/home/user/GroupDocs.License.lic
         mvn clean compile exec:java
       ```
    
    2. `CONHOLDATE_LIC_PATH`
   
       ```shell
         export CONHOLDATE_LIC_PATH=/home/user/GroupDocs.License.lic
         mvn clean compile exec:java
       ```
       
    3. `GROUPDOCS_LIC_PATH`
   
       ```shell
         export GROUPDOCS_LIC_PATH=/home/user/GroupDocs.License.lic
         mvn clean compile exec:java
       ```
       
3. **Local File**

  Check for a file with the `.lic` extension in the project directory.

  ```shell
    cp /YOUR_LICENSE_PATH/GroupDocs.License.lic ./GroupDocs.License.lic
    mvn clean compile exec:java
  ```

#### Evaluation Mode

If none of the above sources provide a valid license file, evaluation mode will be activated.

**Note:** The path to the license can be a URL.

The license is not included into this repository, so [GroupDocs.Viewer](https://groupdocs.com) will work in the evaluation mode.
To test all the features you can request temporary license at https://purchase.groupdocs.com/temporary-license.

### Configuring Files and Output Directories

The `FilesUtils` class provides utility methods to handle file paths, allowing users to configure these paths using system properties or environment variables:

#### Configuring File Paths

You can configure the path for input files by setting one of the following options:

1. **System Property**: 
   
   Set the `sample.files.path` property:

     ```shell
     mvn clean compile exec:java -Dsample.files.path=/home/user/files
     ```
2. **Environment Variable**:
  
  Check environment variables in this order:

   - `FILES_PATH`:
     ```shell
     export FILES_PATH=/home/user/files
     mvn clean compile exec:java
     ```

   - `GROUPDOCS_FILES_PATH`:
     ```shell
     export GROUPDOCS_FILES_PATH=/home/user/files
     mvn clean compile exec:java
     ```

#### Configuring Output Directories

You can configure the path for saving generated files by setting one of the following options:

1. **System Property**:

   Set the `sample.output.path` property:

     ```shell
     mvn clean compile exec:java -Dsample.output.path=/home/user/output
     ```
2. **Environment Variable**:

    Check environment variables in this order:
    
    - `OUTPUT_PATH`:
      ```shell
      export FILES_PATH=/home/user/output
      mvn clean compile exec:java
      ```

    - `GROUPDOCS_OUTPUT_PATH`:
      ```shell
      export GROUPDOCS_OUTPUT_PATH=/home/user/output
      mvn clean compile exec:java
      ```

If none of these properties are set, the default locations will be used:

* Input files: `Resources/SampleFiles`
* Output files: `Resources/Output`

## Resources

+ **Website:** [groupdocs.com](http://groupdocs.com)
+ **Product Home:** [GroupDocs.Conversion for Java](https://products.groupdocs.com/conversion/java/)
+ **Product API:** [API of GroupDocs.Conversion for Java](https://reference.groupdocs.com/conversion/java/)
+ **Download:** [Download GroupDocs.Conversion for Java](https://releases.groupdocs.com/conversion/java/)
+ **Documentation:** [GroupDocs.Conversion for Java Documentation](https://docs.groupdocs.com/conversion/java/)
+ **Forum:** [GroupDocs.Conversion for Java Forum](https://forum.groupdocs.com/c/conversion/11)
+ **Blog:** [GroupDocs.Conversion for Java Blog](https://blog.groupdocs.com/categories/groupdocs.conversion-product-family/)

