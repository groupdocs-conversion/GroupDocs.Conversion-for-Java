package com.groupdocs.ui.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GlobalConfiguration {

    @Inject
    private ServerConfiguration server;

    @Inject
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
