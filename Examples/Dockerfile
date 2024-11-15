FROM maven:3.6.3-openjdk-8

WORKDIR /app

CMD mkdir ./Resources && mkdir ./Resources/Output

COPY ./Resources/SampleFiles ./Resources/SampleFiles
COPY ./src ./src
COPY ./pom.xml ./pom.xml
COPY ./GroupDocs.License.lic ./GroupDocs.License.lic

ENV GROUPDOCS_LIC_PATH /app/GroupDocs.License.lic

ENTRYPOINT ["mvn"]
