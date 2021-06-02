package com.groupdocs.ui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GlobalConfiguration {

    @Autowired
    private ServerConfiguration server;

    @Autowired
    private ApplicationConfiguration application;

    public ServerConfiguration getServer() {
        return server;
    }

    public void setServer(ServerConfiguration server) {
        this.server = server;
    }

    public ApplicationConfiguration getApplication() {
        return application;
    }

    public void setApplication(ApplicationConfiguration application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "GlobalConfiguration{" +
                "server=" + server +
                ", application=" + application +
                '}';
    }
}
