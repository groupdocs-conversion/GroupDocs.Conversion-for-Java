package com.groupdocs.ui.common;

import io.dropwizard.configuration.ConfigurationSourceProvider;
import org.yaml.snakeyaml.Yaml;

import javax.validation.constraints.NotNull;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Provider for reading two config files default and external file
 */
public class MergedConfigurationSourceProvider implements ConfigurationSourceProvider {
    private String defaultConfigFile;

    public MergedConfigurationSourceProvider(@NotNull String defaultConfigFile) {
        this.defaultConfigFile = defaultConfigFile;
    }

    @Override
    public InputStream open(String path) throws IOException {
        try (InputStream defaultConfigStream = getResourceAsStream(defaultConfigFile);
             InputStream extConfigStream = getResourceFile(path)) {

            Yaml yaml = new Yaml();
            Map<String, Object> defaultConfig = yaml.loadAs(defaultConfigStream, Map.class);
            Map<String, Object> extConfig = yaml.loadAs(extConfigStream, Map.class);

            merge(defaultConfig, extConfig);

            return new ByteArrayInputStream(new Yaml().dump(defaultConfig).getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * Deep merge two map, if there is a property in extConfig, then replace its value in defaultConfig.
     *
     * @param defaultConfig contains all properties with default values
     * @param extConfig     contains properties from external config, to replace its values in default config
     */
    private void merge(Map<String, Object> defaultConfig, Map<String, Object> extConfig) {
        for (String key : defaultConfig.keySet()) {
            if (extConfig.containsKey(key)) {
                if (defaultConfig.get(key) instanceof Map) {
                    merge((Map<String, Object>) defaultConfig.get(key), (Map<String, Object>) extConfig.get(key));
                } else {
                    defaultConfig.replace(key, extConfig.get(key));
                }
            }
        }
    }

    /**
     * Read file from resources
     *
     * @param path path to config file
     * @return
     */
    private InputStream getResourceAsStream(String path) {
        return this.getClass().getClassLoader().getResourceAsStream(path);
    }

    /**
     * Read external file
     *
     * @param path path to config file
     * @return
     * @throws IOException
     */
    private InputStream getResourceFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("File " + file + " not found");
        } else {
            return new FileInputStream(file);
        }
    }
}
