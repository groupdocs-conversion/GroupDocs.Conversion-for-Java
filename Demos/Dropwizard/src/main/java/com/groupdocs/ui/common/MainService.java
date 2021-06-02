package com.groupdocs.ui.common;

import com.google.common.collect.Sets;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.exception.TotalGroupDocsExceptionMapper;
import com.groupdocs.ui.common.health.TemplateHealthCheck;
import com.groupdocs.ui.conversion.resources.ConversionResources;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.io.File;
import java.util.EnumSet;
import java.util.HashSet;

/**
 * Main class
 * Where all the magic starts
 *
 * @author Aspose Pty Ltd
 */

public class MainService extends Application<GlobalConfiguration> {

    static {
        ImageIO.scanForPlugins();
    }

    private static final Logger logger = LoggerFactory.getLogger(MainService.class);

    private static final String SERVER_COMMAND = "server";
    private static final String CHECK_COMMAND = "check";
    private static final HashSet<String> COMMANDS = Sets.newHashSet(SERVER_COMMAND, CHECK_COMMAND);
    private static final String DEFAULT_CONFIGURATION_FILE = "defaultConfiguration.yml";
    private static final String EXTERNAL_CONFIGURATION_FILE = "configuration.yml";

    private boolean defaultConfiguration;

    public MainService(){
        super();
        this.defaultConfiguration = false;
    }
    
    public MainService(boolean defaultConfiguration) {
        super();
        this.defaultConfiguration = defaultConfiguration;
    }

    public static void main(String[] args) throws Exception {
        if (args == null || args.length == 0 || (args.length == 1 && !COMMANDS.contains(args[0]))) {
            logger.info("Command is not specified. Use default: server.");
            args = args.length == 1 ? new String[]{SERVER_COMMAND, args[0]} : new String[]{SERVER_COMMAND, EXTERNAL_CONFIGURATION_FILE};
        }
        if (args.length > 1 && StringUtils.isNotEmpty(args[1]) && new File(args[1]).exists()) {
            new MainService(false).run(args);
        } else {
            logger.info("Can not find external configuration file. Use default.");
            String[] newArgs = new String[]{args[0], DEFAULT_CONFIGURATION_FILE};
            new MainService(true).run(newArgs);
        }
    }

    @Override
    public void initialize(Bootstrap<GlobalConfiguration> bootstrap) {
        if (defaultConfiguration) {
            bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        } else {
            bootstrap.setConfigurationSourceProvider(new MergedConfigurationSourceProvider(DEFAULT_CONFIGURATION_FILE));
        }
        // add assets bundle in order to get resources from assets directory
        bootstrap.addBundle(new AssetsBundle());
        // init view bundle
        bootstrap.addBundle(new ViewBundle());
        // for injection file content in resource methods
        bootstrap.addBundle(new MultiPartBundle());
    }

    @Override
    public void run(GlobalConfiguration globalConfiguration, Environment environment) throws Exception {
        // Enable CORS headers
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        // Initiate resources (web pages)
        environment.jersey().register(new ConversionResources(globalConfiguration));

        // Add custom exception mapper
        environment.jersey().register(new TotalGroupDocsExceptionMapper());

        // Add dummy health check to get rid of console warnings
        // TODO: implement health check
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck("");
        environment.healthChecks().register("HealthCheck", healthCheck);
    }
}