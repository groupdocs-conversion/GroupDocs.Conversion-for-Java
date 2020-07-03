---
id: features-overview
url: conversion/java/features-overview
title: Features Overview
weight: 1
description: ""
keywords: 
productName: GroupDocs.Conversion for Java
hideChildren: False
---
## Document conversion

GroupDocs.Conversion main feature is an ability to convert any document from wide list of supported source document formats into any supported target format (check full list of supported conversions [here]({{< ref "conversion/java/getting-started/features-overview.md" >}})). All these conversions are possible without any additional software installed (like MS Office, Apache Open Office, Adobe Acrobat Reader and others).
GroupDocs.Conversion provides flexible set of settings to customize conversion process to fulfill your needs:

*   Convert whole document to desired target format;
*   Convert specific document page(s) or page range;
*   Auto-detect source document format \- document format will be detected on the fly (no document extension is required);
*   Load source document with extended options - to specify password for password-protected documents, for loading specific part of document (for example specific sheet from Spreadsheet document), to show/hide document comments etc.;
*   Obtain all supported conversion formats list;
*   Missing fonts replacement - missing font(s) can be replaced with any provided font(s) instead;    
*   Add text or image watermarks to any page     
*   and much more.
    

## Caching results

GroupDocs.Conversion supports caching conversion result to local disk by default. However any type of cache storage can be supported by implementing appropriate interfaces – Amazon S3, Dropbox, Google Drive, Windows Azure, Reddis or any other.

## Document information extraction

GroupDocs.Conversion allows to obtain basic information about source document - file type, pages count etc. Dependent on source file type some format specific information can be extracted, for example:

*   CAD - list of layers and layouts in a CAD document;    
*   Email – list of folders contained in an Outlook data file document;    
*   PDF – information about document printing restrictions;    
*   Project Management – project start and end dates.
