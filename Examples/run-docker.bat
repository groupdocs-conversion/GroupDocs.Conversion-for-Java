@echo off
set /p input="Before continue, copy GroupDocs License file to the current directory and rename it to 'GroupDocs.License.lic'"
:: echo %input%

:: COPY C:\YourGroupDocsLicense.lic .\GroupDocs.License.lic
call docker-compose up --build

set /p pause="Press [Enter] key to continue..."
