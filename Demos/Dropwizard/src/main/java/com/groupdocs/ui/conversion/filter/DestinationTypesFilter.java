package com.groupdocs.ui.conversion.filter;

public class DestinationTypesFilter {
    private String[] allTypes = { "ods", "xls", "xlsx", "xlsm", "xlsb", "csv", "xls2003", "xltx", "xltm", "tsv", "tiff", "tif", "jpeg", "jpg", "png", "gif", "bmp", "ico", "psd", "svg", "webp", "jp2", "pdf", "epub", "xps", "ppt", "pps", "pptx", "ppsx", "odp", "otp", "potx", "potm", "pptm", "ppsm", "doc", "docm", "docx", "dot", "dotm", "dotx", "rtf", "txt", "odt", "ott", "html", };
    private String[] csvTypes = { "ods", "xls", "xlsx", "xlsm", "xlsb", "csv", "xls2003", "xltx", "xltm", "tsv", "tiff", "tif", "jpeg", "jpg", "png", "gif", "bmp", "ico", "psd", "webp", "jp2", "pdf", "epub", "xps", "ppt", "pps", "pptx", "ppsx", "odp", "otp", "potx", "potm", "pptm", "ppsm", "doc", "docm", "docx", "dot", "dotm", "dotx", "rtf", "txt", "odt", "ott", "html", };
    private String[] htmlTypes = { "tiff", "tif", "jpeg", "jpg", "png", "gif", "bmp", "ico", "psd", "svg", "webp", "jp2", "pdf", "epub", "ppt", "pps", "pptx", "ppsx", "odp", "otp", "potx", "potm", "pptm", "ppsm", "doc", "docm", "docx", "dot", "dotm", "dotx", "rtf", "odt", "ott", "html", };
    private String[] slidesTypes = { "tiff", "tif", "jpeg", "jpg", "png", "gif", "bmp", "ico", "psd", "svg", "webp", "jp2", "pdf", "epub", "xps", "ppt", "pps", "pptx", "ppsx", "odp", "otp", "potx", "potm", "pptm", "ppsm", "doc", "docm", "docx", "dot", "dotm", "dotx", "rtf", "odt", "ott", "html", };
    private String[] imageTypes = { "ods", "xls", "xlsx", "xlsm", "xlsb", "xls2003", "xltx", "xltm", "tiff", "tif", "jpeg", "jpg", "png", "gif", "bmp", "ico", "psd", "svg", "webp", "jp2", "pdf", "epub", "xps", "ppt", "pps", "pptx", "ppsx", "odp", "otp", "potx", "potm", "pptm", "ppsm", "doc", "docm", "docx", "dot", "dotm", "dotx", "rtf", "odt", "ott", "html", };
    private String[] tsvTypes = { "ods", "xls", "xlsx", "xlsm", "xlsb", "csv", "xls2003", "xltx", "xltm", "tsv", "tiff", "tif", "jpeg", "jpg", "png", "gif", "bmp", "ico", "psd", "webp", "jp2", "pdf", "epub", "xps", "ppt", "pps", "pptx", "ppsx", "odp", "otp", "potx", "potm", "pptm", "ppsm", "doc", "docm", "docx", "dot", "dotm", "dotx", "rtf", "txt", "odt", "ott", "html", };
    private String[] webpTypes = { "ods", "xls", "xlsx", "xlsm", "xlsb", "xls2003", "xltx", "xltm", "tiff", "tif", "jpeg", "jpg", "png", "gif", "bmp", "ico", "psd", "svg", "webp", "jp2", "pdf", "epub", "xps", "ppt", "pps", "pptx", "ppsx", "odp", "otp", "potx", "potm", "pptm", "ppsm", "doc", "docm", "docx", "dot", "dotm", "dotx", "rtf", "odt", "ott", "html", };
    private String[] cellsTypes = { "ods", "xls", "xlsx", "xlsm", "xlsb", "csv", "xls2003", "xltx", "xltm", "tsv", "tiff", "tif", "pdf", "epub", "xps", "ppt", "pps", "pptx", "ppsx", "odp", "otp", "potx", "potm", "pptm", "ppsm", "doc", "docm", "docx", "dot", "dotm", "dotx", "rtf", "txt", "odt", "ott", "html", };

    public String[] getPosibleConversions(String extension)
    {
        switch (extension)
        {
            default:
                return allTypes;
            case "csv":
                return csvTypes;
            case "tsv":
                return tsvTypes;
            case "webp":
                return webpTypes;
            case "html":
            case "htm":
                return htmlTypes;
            case "ppt":
            case "pps":
            case "pptx":
            case "ppsx":
            case "odp":
            case "otp":
            case "potx":
            case "potm":
            case "pptm":
            case "ppsm":
                return slidesTypes;
            case "tiff":
            case "tif":
            case "jpeg":
            case "jpg":
            case "png":
            case "gif":
            case "bmp":
            case "ico":
            case "psd":
            case "svg":
            case "jp2":
                return imageTypes;
            case "ods":
            case "xls":
            case "xlsb":
            case "xlsx":
            case "xlsm":
            case "xls2003":
            case "xltx":
            case "xltm":
                return cellsTypes;
        }
    }
}
