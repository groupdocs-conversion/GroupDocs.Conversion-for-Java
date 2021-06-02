package com.groupdocs.ui.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.groupdocs.ui.conversion.config.ConversionConfiguration;
import io.dropwizard.Configuration;

import javax.validation.Valid;

/**
 * GlobalConfiguration
 * Object to hold all application's configurations from yml file
 *
 * @author Aspose Pty Ltd
 */
public class GlobalConfiguration extends Configuration {

    @Valid
    @JsonProperty
    private ServerConfiguration server;

    @Valid
    @JsonProperty
    private ApplicationConfiguration application;

    @Valid
    @JsonProperty
    private CommonConfiguration common;

    @Valid
    @JsonProperty
    private ConversionConfiguration conversion;

    /**
     * Constructor
     */
    public GlobalConfiguration(){
        server = new ServerConfiguration();
        application = new ApplicationConfiguration();
        common = new CommonConfiguration();
        conversion = new ConversionConfiguration();
    }

    /**
     * Get server configuration
     * @return server configuration
     */
    public ServerConfiguration getServer() {
        return server;
    }

    /**
     * Get application configuration
     * @return application configuration
     */
    public ApplicationConfiguration getApplication() {
        return application;
    }

    /**
     * Get common configuration
     * @return common configuration
     */
    public CommonConfiguration getCommon() {
        return common;
    }

    /**
     * Get common configuration
     * @return conversion configuration
     */
    public ConversionConfiguration getConversion() {
        return conversion;
    }
}


