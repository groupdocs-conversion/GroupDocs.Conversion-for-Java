package com.groupdocs.ui.conversion.resources;

import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.entity.web.UploadedDocumentEntity;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.common.resources.Resources;
import com.groupdocs.ui.conversion.model.ConversionConfigurationModel;
import com.groupdocs.ui.conversion.model.request.ConversionPostedData;
import com.groupdocs.ui.conversion.model.response.ConversionTypesEntity;
import com.groupdocs.ui.conversion.service.ConversionService;
import com.groupdocs.ui.conversion.service.ConversionServiceImpl;
import com.groupdocs.ui.conversion.views.Conversion;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import static javax.ws.rs.core.MediaType.*;

@Path(value = "/conversion")
public class ConversionResources extends Resources {
    private static final Logger logger = LoggerFactory.getLogger(ConversionResources.class);

    private ConversionService conversionService;

    @Override
    protected String getStoragePath(Map<String, Object> params) {
        return globalConfiguration.getConversion().getFilesDirectory();
    }

    /**
     * Constructor
     *
     * @param globalConfiguration global application configuration
     * @throws UnknownHostException
     */
    public ConversionResources(GlobalConfiguration globalConfiguration) throws UnknownHostException {
        super(globalConfiguration);
        conversionService = new ConversionServiceImpl(globalConfiguration);
    }

    @GET
    @Path(value = "/loadConfig")
    @Produces(APPLICATION_JSON)
    public ConversionConfigurationModel loadConfig() {
        return ConversionConfigurationModel.createConversionConfiguration(globalConfiguration.getConversion(), globalConfiguration.getCommon());
    }


    /**
     * Get conversion page
     * @return template name
     */
    @GET
    public Conversion getView() {
        logger.debug("conversion config: {}", globalConfiguration.getConversion());
        // initiate index page
        return new Conversion(globalConfiguration, DEFAULT_CHARSET);
    }

    /**
     * Get files and directories
     * @return files and directories list
     */
    @POST
    @Path(value = "/loadFileTree")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public List<ConversionTypesEntity> loadFileTree(FileTreeRequest fileTreeRequest){
        return conversionService.loadFiles(fileTreeRequest);
    }

    /**
     * Upload document
     * @return uploaded document object (the object contains uploaded document guid)
     */
    @POST
    @Path(value = "/uploadDocument")
    @Produces(APPLICATION_JSON)
    @Consumes(MULTIPART_FORM_DATA)
    public UploadedDocumentEntity uploadDocument(@FormDataParam("file")  InputStream inputStream,
                                                 @FormDataParam("file") FormDataContentDisposition fileDetail,
                                                 @FormDataParam("url") String url,
                                                 @FormDataParam("rewrite") Boolean rewrite) {
        // upload file
        String pathname = uploadFile(url, inputStream, fileDetail, rewrite, null);
        // create response
        UploadedDocumentEntity uploadedDocument = new UploadedDocumentEntity();
        uploadedDocument.setGuid(pathname);
        return uploadedDocument;
    }

    @POST
    @Path(value = "/convert")
    @Produces(TEXT_PLAIN)
    @Consumes(APPLICATION_JSON)
    public void convert(ConversionPostedData postedData, @Context HttpServletResponse response){
        try{
            conversionService.convert(postedData);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("");
            response.getWriter().flush();
            response.getWriter().close();
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Path(value = "/downloadDocument")
    public void download(@QueryParam("path") String path, @Context HttpServletResponse response){
        try {
            String downloadPath = conversionService.download(path);
            downloadFile(response,downloadPath);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            response.setStatus(422);
        }
    }

}
