package com.groupdocs.ui;

import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.conversion.ConversionConfiguration;
import com.groupdocs.ui.conversion.ConversionService;
import com.groupdocs.ui.model.request.ConversionPostedData;
import com.groupdocs.ui.model.request.FileTreeRequest;
import com.groupdocs.ui.model.response.ConversionTypesEntity;
import com.groupdocs.ui.model.response.UploadedDocumentEntity;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.multipart.FileUpload;
import org.jboss.resteasy.reactive.server.multipart.FormValue;
import org.jboss.resteasy.reactive.server.multipart.MultipartFormDataInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.groupdocs.ui.util.Utils.setLocalPort;
import static com.groupdocs.ui.util.Utils.uploadFile;

@Path("/conversion")
public class ConversionController {
    private static final Logger logger = LoggerFactory.getLogger(ConversionController.class);

    @Inject
    public GlobalConfiguration globalConfiguration;

    @Inject
    public ConversionService conversionService;

    @GET
    @Path("/loadConfig")
    @Produces(MediaType.APPLICATION_JSON)
    public ConversionConfiguration loadConfig() {
        return conversionService.getConversionConfiguration();
    }


    /**
     * Get conversion page
     *
     * @param model model data for template
     * @return template name
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getView() {
        return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/META-INF/resources/index.html"))).lines().collect(Collectors.joining(System.lineSeparator()));
    }

    /**
     * Get files and directories
     *
     * @return files and directories list
     */
    @POST
    @Path("/loadFileTree")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConversionTypesEntity> loadFileTree(FileTreeRequest fileTreeRequest) {
        return conversionService.loadFiles(fileTreeRequest);
    }


    /**
     * Upload document
     *
     * @return uploaded document object (the object contains uploaded document guid)
     */
    @POST
    @Path("/uploadDocument")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public UploadedDocumentEntity uploadDocument(@RestForm("file") FileUpload content,
                                                 @RestForm("url") String url,
                                                 @RestForm("rewrite") Boolean rewrite) {
        // get documents storage path
        String documentStoragePath = conversionService.getConversionConfiguration().getFilesDirectory();
        // save the file
        String pathname = uploadFile(documentStoragePath, content, url, rewrite);
        // create response data
        UploadedDocumentEntity uploadedDocument = new UploadedDocumentEntity();
        uploadedDocument.setGuid(pathname);
        return uploadedDocument;
    }

    @POST
    @Path("/convert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse convert(ConversionPostedData postedData) {
        try {
            conversionService.convert(postedData);
            return RestResponse.ok();
        } catch (Exception e) {
            return RestResponse.ok();
        }
    }


    @GET
    @Path("/downloadDocument")
    public RestResponse downloadDocument(@QueryParam("path") String path) {
        try {
            return conversionService.download(path);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return RestResponse.status(422);
        }
    }
}
