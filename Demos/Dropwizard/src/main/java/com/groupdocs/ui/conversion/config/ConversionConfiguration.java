package com.groupdocs.ui.conversion.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;

import static com.groupdocs.ui.common.config.DefaultDirectories.defaultConversionDirectory;
import static com.groupdocs.ui.common.config.DefaultDirectories.relativePathToAbsolute;

public class ConversionConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private String filesDirectory;

    @Valid
    @JsonProperty
    private String resultDirectory;


    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = StringUtils.isEmpty(filesDirectory) ? defaultConversionDirectory() : relativePathToAbsolute(filesDirectory);
    }

    public String getResultDirectory() {
        return resultDirectory;
    }

    public void setResultDirectory(String resultDirectory) {
        this.resultDirectory = StringUtils.isEmpty(resultDirectory) ? defaultConversionDirectory("Converted") : resultDirectory;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ConversionConfiguration{" +
                "filesDirectory='" + filesDirectory + '\'' +
                ", resultDirectory='" + resultDirectory + '\'' +
                '}';
    }
}
