package com.groupdocs.ui.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * CommonConfiguration
 *
 * @author Aspose Pty Ltd
 */
@ApplicationScoped
public class CommonConfiguration {

    @ConfigProperty(name = "common.download")
    private Boolean download;

    @ConfigProperty(name = "common.upload")
    private Boolean upload;

    @ConfigProperty(name = "common.browse")
    private Boolean browse;

    @ConfigProperty(name = "common.rewrite")
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
