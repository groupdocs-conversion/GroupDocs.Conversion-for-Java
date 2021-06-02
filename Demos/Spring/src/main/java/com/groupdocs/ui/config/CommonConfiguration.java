package com.groupdocs.ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * CommonConfiguration
 *
 * @author Aspose Pty Ltd
 */
@Component
public class CommonConfiguration {

    @Value("#{new Boolean('${common.download}')}")
    private Boolean download;

    @Value("#{new Boolean('${common.upload}')}")
    private Boolean upload;

    @Value("#{new Boolean('${common.browse}')}")
    private Boolean browse;

    @Value("#{new Boolean('${common.rewrite}')}")
    private Boolean rewrite;

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

    @Override
    public String toString() {
        return "CommonConfiguration{" +
                "download=" + download +
                ", upload=" + upload +
                ", browse=" + browse +
                ", rewrite=" + rewrite +
                '}';
    }
}
