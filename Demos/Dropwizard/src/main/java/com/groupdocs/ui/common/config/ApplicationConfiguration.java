package com.groupdocs.ui.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;

import static com.groupdocs.ui.common.config.DefaultDirectories.defaultLicenseDirectory;
import static com.groupdocs.ui.common.config.DefaultDirectories.relativePathToAbsolute;

/**
 * ApplicationConfiguration
 *
 * @author Aspose Pty Ltd
 */
public class ApplicationConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private String licensePath;
    @Valid
    @JsonProperty
    private String hostAddress;

    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = StringUtils.isEmpty(licensePath) ? defaultLicenseDirectory() : relativePathToAbsolute(licensePath);
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }
}
