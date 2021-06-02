package com.groupdocs.ui.conversion.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.common.config.CommonConfiguration;
import com.groupdocs.ui.conversion.config.ConversionConfiguration;

import javax.validation.Valid;

public class ConversionConfigurationModel {

    @Valid
    @JsonProperty
    private String filesDirectory;

    @Valid
    @JsonProperty
    private String resultDirectory;


    @Valid
    @JsonProperty
    private boolean download;

    @Valid
    @JsonProperty
    private boolean upload;

    @Valid
    @JsonProperty
    private boolean print;

    @Valid
    @JsonProperty
    private boolean browse;

    @Valid
    @JsonProperty
    private boolean rewrite;


    @Valid
    @JsonProperty
    private boolean pageSelector;

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = filesDirectory;
    }

    public String getResultDirectory() {
        return resultDirectory;
    }

    public void setResultDirectory(String resultDirectory) {
        this.resultDirectory = resultDirectory;
    }


    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }

    public boolean isUpload() {
        return upload;
    }

    public void setUpload(boolean upload) {
        this.upload = upload;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public boolean isBrowse() {
        return browse;
    }

    public void setBrowse(boolean browse) {
        this.browse = browse;
    }

    public boolean isRewrite() {
        return rewrite;
    }

    public void setRewrite(boolean rewrite) {
        this.rewrite = rewrite;
    }


    public boolean isPageSelector() {
        return pageSelector;
    }

    public void setPageSelector(boolean pageSelector) {
        this.pageSelector = pageSelector;
    }

    public static ConversionConfigurationModel createConversionConfiguration(ConversionConfiguration conversion, CommonConfiguration common) {
        ConversionConfigurationModel model = new ConversionConfigurationModel();
        model.setFilesDirectory(conversion.getFilesDirectory());
        model.setResultDirectory(conversion.getResultDirectory());
        model.setPageSelector(common.isPageSelector());
        model.setDownload(common.isDownload());
        model.setUpload(common.isUpload());
        model.setPrint(common.isPrint());
        model.setBrowse(common.isBrowse());
        model.setRewrite(common.isRewrite());
        return model;
    }

    @Override
    public String toString() {
        return "ComparisonConfigurationModel{" +
                "filesDirectory='" + filesDirectory + '\'' +
                ", resultDirectory='" + resultDirectory + '\'' +
                '}';
    }
}
