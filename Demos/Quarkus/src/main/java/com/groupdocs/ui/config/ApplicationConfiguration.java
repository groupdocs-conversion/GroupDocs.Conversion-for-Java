package com.groupdocs.ui.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import static com.groupdocs.ui.config.DefaultDirectories.defaultLicenseDirectory;
import static com.groupdocs.ui.config.DefaultDirectories.relativePathToAbsolute;

@ApplicationScoped
public class ApplicationConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @ConfigProperty(name = "application.hostAddress", defaultValue = "")
    private Optional<String> hostAddress;
    @ConfigProperty(name = "application.licensePath", defaultValue = "")
    private Optional<String> licensePath;

    @PostConstruct
    public void init() {
        if (StringUtils.isEmpty(hostAddress.orElse(null))) {
            try {
                hostAddress = Optional.ofNullable(InetAddress.getLocalHost().getHostAddress());
            } catch (UnknownHostException e) {
                logger.error("Can not get host address ", e);
                hostAddress =  Optional.of("localhost");
            }
        }
        this.licensePath = Optional.of(StringUtils.isEmpty(this.licensePath.orElse(null)) ? defaultLicenseDirectory() : relativePathToAbsolute(this.licensePath.orElse(null)));
    }

    public String getLicensePath() {
        return licensePath.orElse(null);
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = Optional.ofNullable(licensePath) ;
    }

    public String getHostAddress() {
        return hostAddress.orElse(null);
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = Optional.ofNullable(hostAddress);
    }

    @Override
    public String toString() {
        return "ApplicationConfiguration{" +
                "licensePath='" + licensePath + '\'' +
                ", hostAddress='" + hostAddress + '\'' +
                '}';
    }
}
