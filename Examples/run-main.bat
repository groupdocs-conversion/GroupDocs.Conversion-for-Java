@echo off

:: set LIC_GROUPDOCS=C:\license.lic
set "MAVEN_OPTS=-Xms512m -Xmx1g"

call mvn clean compile exec:java

set /p pause="Press [Enter] key to continue..."
