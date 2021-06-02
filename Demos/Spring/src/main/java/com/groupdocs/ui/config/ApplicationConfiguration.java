package com.groupdocs.ui.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.groupdocs.ui.config.DefaultDirectories.defaultLicenseDirectory;
import static com.groupdocs.ui.config.DefaultDirectories.relativePathToAbsolute;

@Component
public class ApplicationConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Value("${application.hostAddress}")
    private String hostAddress;
    @Value("${application.licensePath}")
    private String licensePath;

    @PostConstruct
    public void init() {
        if (StringUtils.isEmpty(hostAddress)) {
            try {
                hostAddress = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                logger.error("Can not get host address ", e);
                hostAddress = "localhost";
            }
        }
        this.licensePath = StringUtils.isEmpty(this.licensePath) ? defaultLicenseDirectory() : relativePathToAbsolute(this.licensePath);
    }

    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    @Override
    public String toString() {
        return "ApplicationConfiguration{" +
                "licensePath='" + licensePath + '\'' +
                ", hostAddress='" + hostAddress + '\'' +
                '}';
    }
}
