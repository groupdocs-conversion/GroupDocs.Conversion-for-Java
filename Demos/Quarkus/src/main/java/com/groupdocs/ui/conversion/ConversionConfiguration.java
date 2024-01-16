package com.groupdocs.ui.conversion;

import com.groupdocs.ui.config.CommonConfiguration;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Optional;

import static com.groupdocs.ui.config.DefaultDirectories.defaultConversionDirectory;
import static com.groupdocs.ui.config.DefaultDirectories.relativePathToAbsolute;

@ApplicationScoped
public class ConversionConfiguration extends CommonConfiguration {
    private String defaultResultDirectory = "DocumentSamples/Conversion/Converted";

    @ConfigProperty(name = "conversion.filesDirectory")
    private String filesDirectory;

    @ConfigProperty(name = "conversion.resultDirectory")
    private Optional<String> resultDirectory;

    @PostConstruct
    public void init() {
        this.filesDirectory = StringUtils.isEmpty(this.filesDirectory)
                ? defaultConversionDirectory()
                : relativePathToAbsolute(this.filesDirectory);

        this.resultDirectory = Optional.of(this.resultDirectory.orElse(null) == null || StringUtils.isEmpty(this.resultDirectory.orElse(null))
                ? relativePathToAbsolute(defaultResultDirectory)
                : relativePathToAbsolute(this.resultDirectory.orElse(null)));
    }

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = filesDirectory;
    }

    public String getResultDirectory() {
        return resultDirectory.orElse(null);
    }

    public void setResultDirectory(String resultDirectory) {
        this.resultDirectory = Optional.ofNullable(resultDirectory);
    }

}
