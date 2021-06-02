package com.groupdocs.ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerConfiguration {

    private Integer httpPort;
    @Value("#{servletContext.contextPath}")
    private String applicationContextPath;

    public Integer getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(Integer httpPort) {
        this.httpPort = httpPort;
    }

    public String getApplicationContextPath() {
        return applicationContextPath;
    }

    public void setApplicationContextPath(String applicationContextPath) {
        this.applicationContextPath = applicationContextPath;
    }

    @Override
    public String toString() {
        return "ServerConfiguration{" +
                "httpPort=" + httpPort +
                ", applicationContextPath='" + applicationContextPath + '\'' +
                '}';
    }
}
