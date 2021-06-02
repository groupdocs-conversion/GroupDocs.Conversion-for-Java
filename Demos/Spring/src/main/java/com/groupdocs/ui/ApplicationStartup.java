package com.groupdocs.ui;

import com.groupdocs.ui.config.ServerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Component for listening ApplicationContext event
 */
@Component
public class ApplicationStartup implements ApplicationListener<WebServerInitializedEvent> {

    @Autowired
    private ServerConfiguration serverConfiguration;

    /**
     * This method is called during Spring's startup.
     *
     * @param event Event raised when an ApplicationContext gets initialized or
     * refreshed.
     */
    public void onApplicationEvent(WebServerInitializedEvent event) {
        // use this event for obtaining the local port of a running server
        serverConfiguration.setHttpPort(event.getWebServer().getPort());
    }

} 