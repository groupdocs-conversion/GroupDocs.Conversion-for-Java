package com.groupdocs.ui.conversion;

import com.groupdocs.ui.config.CommonConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

import static com.groupdocs.ui.config.DefaultDirectories.defaultConversionDirectory;
import static com.groupdocs.ui.config.DefaultDirectories.relativePathToAbsolute;

@Component
public class ConversionConfiguration extends CommonConfiguration {
    private String defaultResultDirectory = "DocumentSamples/Conversion/Converted";

    @Value("${conversion.filesDirectory}")
    private String filesDirectory;

    @Value("${conversion.resultDirectory}")
    private String resultDirectory;

    @PostConstruct
    public void init() {
        this.filesDirectory = StringUtils.isEmpty(this.filesDirectory)
                ? defaultConversionDirectory()
                : relativePathToAbsolute(this.filesDirectory);

        this.resultDirectory = this.resultDirectory == null || StringUtils.isEmpty(this.resultDirectory)
                ? relativePathToAbsolute(defaultResultDirectory)
                : relativePathToAbsolute(this.resultDirectory);
    }

    public String getFilesDirectory() {
        return filesDirectory;
    }

    public void setFilesDirectory(String filesDirectory) {
        this.filesDirectory = filesDirectory;
    }

    public String getResultDirectory() {
        return resultDirectory;
    }

    public void setResultDirectory(String resultDirectory) {
        this.resultDirectory = resultDirectory;
    }

}
