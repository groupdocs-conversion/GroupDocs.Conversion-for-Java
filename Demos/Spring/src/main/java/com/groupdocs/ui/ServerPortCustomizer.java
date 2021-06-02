package com.groupdocs.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * Customize port from configuration properties
 */
@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    private static final int DEFAULT_PORT = 8080;

    @Value("#{new Integer('${server.connector.port}')}")
    private Integer port;

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(port != null ? port : DEFAULT_PORT);
    }
}
