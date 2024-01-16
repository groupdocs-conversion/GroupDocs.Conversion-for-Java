package com.groupdocs.ui.config;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServerConfiguration {

    private Integer httpPort;

    public Integer getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(Integer httpPort) {
        this.httpPort = httpPort;
    }

    @Override
    public String toString() {
        return "ServerConfiguration{" +
                "httpPort=" + httpPort +
                '}';
    }
}
