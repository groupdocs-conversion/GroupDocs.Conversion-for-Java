#!/bin/sh

read -p "Before continue, copy GroupDocs License file to the current directory and rename it to 'GroupDocs.License.lic'"
# cp /home/user/YourGroupDocsLicense.lic ./GroupDocs.License.lic
docker-compose up --build

read -p "Press [Enter] key to continue..."
