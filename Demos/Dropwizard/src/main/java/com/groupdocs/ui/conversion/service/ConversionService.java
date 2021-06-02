package com.groupdocs.ui.conversion.service;

import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.conversion.config.ConversionConfiguration;
import com.groupdocs.ui.conversion.model.request.ConversionPostedData;
import com.groupdocs.ui.conversion.model.response.ConversionTypesEntity;

import java.io.IOException;
import java.util.List;

public interface ConversionService {

    /**
     * Load list of elements from directory
     *
     * @param fileTreeRequest request with path to directory
     * @return list of files and folders
     */
    List<ConversionTypesEntity> loadFiles(FileTreeRequest fileTreeRequest);

    /**
     * Get configuration
     *
     * @return configuration
     */
    ConversionConfiguration getConversionConfiguration();

    /**
     * Convert file to specified format
     * @param postedData request with that specifies format and file to be converted
     */
    void convert(ConversionPostedData postedData);


    /**
     * Creates response for downloading converted file
     * @param path coverted file name
     * @return ResponseEntity
     * @throws IOException
     */
    String download(String path) throws IOException;
}
