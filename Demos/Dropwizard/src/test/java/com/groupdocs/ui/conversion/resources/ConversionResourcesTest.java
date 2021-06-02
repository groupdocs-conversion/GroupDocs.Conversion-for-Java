package com.groupdocs.ui.conversion.resources;

import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricFilter;
import com.google.gson.Gson;
import com.groupdocs.ui.common.MainService;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.conversion.model.request.ConversionPostedData;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.apache.commons.io.FilenameUtils;
import org.glassfish.jersey.client.ClientProperties;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class ConversionResourcesTest {

    private GlobalConfiguration configuration;
    private Client client;

    @ClassRule
    public static final DropwizardAppRule<GlobalConfiguration> RULE =
            new DropwizardAppRule<>(MainService.class, System.getProperty("user.dir") + File.separator + "configuration.yml");

    @Before
    public void setUp(){
        stripLingeringMetrics(RULE.getEnvironment());

        configuration = RULE.getConfiguration();
        client = new JerseyClientBuilder(RULE.getEnvironment()).build("test client");
        client.property(ClientProperties.CONNECT_TIMEOUT, 5000);
        client.property(ClientProperties.READ_TIMEOUT,    5000);

        File resourcesDirectory = new File("src/test/resources");

        configuration.getConversion().setFilesDirectory(resourcesDirectory.getAbsolutePath());
        configuration.getConversion().setResultDirectory(FilenameUtils.concat(resourcesDirectory.getAbsolutePath(),"Converted"));
    }


    @Test
    public void getView() {
        Response response = client.target(
                String.format("http://localhost:%d/conversion", RULE.getLocalPort()))
                .request()
                .get();
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void loadFileTree() {
        FileTreeRequest fileTreeRequest = new FileTreeRequest();
        fileTreeRequest.setPath("");

        Response response = client.target(
                String.format("http://localhost:%d/conversion/loadFileTree", RULE.getLocalPort()))
                .request()
                .post(Entity.json(fileTreeRequest));
        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void convertDocxToPng() throws Exception {
        new File("src/test/resources/Converted/calibre-page1.png").delete();
        new File("src/test/resources/Converted/calibre-page2.png").delete();
        new File("src/test/resources/Converted/calibre-page3.png").delete();

        File testFile = new File("src/test/resources/calibre.docx");

        ConversionPostedData conversionRequest = new ConversionPostedData();
        conversionRequest.setGuid(testFile.getAbsolutePath());
        conversionRequest.setDestinationType("png");

        client.property(ClientProperties.CONNECT_TIMEOUT, 100000);
        client.property(ClientProperties.READ_TIMEOUT,    100000);
        Response response = client.target(
                String.format("http://localhost:%d/conversion/convert", RULE.getLocalPort()))
                .request()
                .post(Entity.json(conversionRequest));
        assertThat(response.getStatus()).isEqualTo(200);

        assertTrue(new File("src/test/resources/Converted/calibre-page1.png").exists());
        assertTrue(new File("src/test/resources/Converted/calibre-page2.png").exists());
        assertTrue(new File("src/test/resources/Converted/calibre-page3.png").exists());

    }

    /**
     * This is to remove the metrics that the constructor of InstrumentedHttpClientConnectionManager
     * adds to an environments MetricsRegistry (related to https://github.com/dropwizard/dropwizard/issues/832).
     *
     * @param env Environment whose MetricRegistry should be stripped
     */
    private static void stripLingeringMetrics(Environment env) {
        env.metrics().removeMatching(new MetricFilter() {
            @Override
            public boolean matches(String name, Metric metric) {
                return name.contains("test client");
            }
        });
    }
}