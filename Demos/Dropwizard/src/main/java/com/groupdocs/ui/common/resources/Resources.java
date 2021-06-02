package com.groupdocs.ui.common.resources;

import com.google.common.collect.Lists;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import io.dropwizard.jetty.ConnectorFactory;
import io.dropwizard.jetty.HttpConnectorFactory;
import io.dropwizard.server.SimpleServerFactory;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Resources
 *
 * @author Aspose Pty Ltd
 */
public abstract class Resources {
    protected final String DEFAULT_CHARSET = "UTF-8";
    protected final GlobalConfiguration globalConfiguration;

    private static final ZoneId GMT = ZoneId.of("GMT");

    /**
     * Get path to storage. Different for different products
     *
     * @param params parameters for calculating the path
     * @return path to files storage
     */
    protected abstract String getStoragePath(Map<String, Object> params);

    /**
     * Internal upload file into server
     *
     * @param documentUrl url for document
     * @param inputStream file stream
     * @param fileDetail file description
     * @param rewrite flag for rewriting file
     * @param params parameters for creating path to files storage
     * @return path to file in storage
     */
    protected String uploadFile(String documentUrl, InputStream inputStream, FormDataContentDisposition fileDetail, boolean rewrite, Map<String, Object> params) {
        InputStream uploadedInputStream = null;
        String pathname;
        try {
            String fileName;
            if (StringUtils.isEmpty(documentUrl)) {
                // get the InputStream to store the file
                uploadedInputStream = inputStream;
                fileName = fileDetail.getFileName();
            } else {
                // get the InputStream from the URL
                URL url =  new URL(documentUrl);
                uploadedInputStream = url.openStream();
                fileName = FilenameUtils.getName(url.getPath());
            }
            // get documents storage path
            String documentStoragePath = getStoragePath(params);
            // save the file
            pathname = String.format("%s%s%s", documentStoragePath, File.separator, fileName);
            File file = new File(pathname);
            // check rewrite mode
            if (rewrite) {
                // save file with rewrite if exists
                Files.copy(uploadedInputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } else {
                if (file.exists()){
                    // get file with new name
                    file = getFreeFileName(documentStoragePath, fileName);
                }
                // save file with out rewriting
                Path path = file.toPath();
                Files.copy(uploadedInputStream, path);
                pathname = path.toString();
            }
        } catch(Exception ex) {
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        } finally {
            try {
                uploadedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pathname;
    }

    /**
     * Date formats with time zone as specified in the HTTP RFC.
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-7.1.1.1">Section 7.1.1.1 of RFC 7231</a>
     */
    private static final DateTimeFormatter[] DATE_FORMATTERS = new DateTimeFormatter[] {
            DateTimeFormatter.RFC_1123_DATE_TIME,
            DateTimeFormatter.ofPattern("EEEE, dd-MMM-yy HH:mm:ss zz", Locale.US),
            DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy",Locale.US).withZone(GMT)
    };

    /**
     * Fill Header Content-disposition parameter for download file
     *
     * @param response http response to fill header
     * @param fileName name of file
     */
    protected void fillResponseHeaderDisposition(HttpServletResponse response, String fileName) {
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
    }

    /**
     * Download file
     *
     * @param response http response
     * @param pathToFile path to file
     */
    protected void downloadFile(HttpServletResponse response, String pathToFile) {
        String fileName = FilenameUtils.getName(pathToFile);
        // don't delete, should be before writing
        fillResponseHeaderDisposition(response, fileName);
        long length;
        try (InputStream inputStream = new FileInputStream(pathToFile);
             OutputStream outputStream = response.getOutputStream()){
            // download the document
            length = IOUtils.copyLarge(inputStream, outputStream);
        } catch (Exception ex){
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
        // set response content disposition
        addFileDownloadHeaders(response, fileName, length);
    }

    /**
     * Constructor
     * @param globalConfiguration global application configuration
     * @throws UnknownHostException
     */
    public Resources(GlobalConfiguration globalConfiguration) throws UnknownHostException {
        this.globalConfiguration = globalConfiguration;

        // set HTTP port
        SimpleServerFactory serverFactory = (SimpleServerFactory) globalConfiguration.getServerFactory();
        ConnectorFactory connector = serverFactory.getConnector();
        globalConfiguration.getServer().setHttpPort(((HttpConnectorFactory) connector).getPort());

        // set host address
        String hostAddress = globalConfiguration.getApplication().getHostAddress();
        if (StringUtils.isEmpty(hostAddress) || hostAddress.startsWith("${")) {
            globalConfiguration.getApplication().setHostAddress(InetAddress.getLocalHost().getHostAddress());
        }
    }

    /**
     * Rename file if exist
     * @param directory directory where files are located
     * @param fileName file name
     * @return new file with new file name
     */
    protected File getFreeFileName(String directory, String fileName){
        File file = null;
        try {
            File folder = new File(directory);
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                int number = i + 1;
                String newFileName = FilenameUtils.removeExtension(fileName) + "-Copy(" + number + ")." + FilenameUtils.getExtension(fileName);
                file = new File(directory + File.separator + newFileName);
                if(file.exists()) {
                    continue;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * Fill header HTTP response with file data
     */
    public void addFileDownloadHeaders(HttpServletResponse response, String fileName, Long fileLength) {
        Map<String, List<String>> fileDownloadHeaders = createFileDownloadHeaders(fileName, fileLength, MediaType.APPLICATION_OCTET_STREAM);
        for (Map.Entry<String, List<String>> entry : fileDownloadHeaders.entrySet()) {
            for (String value : entry.getValue()) {
                response.addHeader(entry.getKey(), value);
            }
        }
    }

    /**
     * Get headers for downloading files
     */
    private static Map<String, List<String>> createFileDownloadHeaders(String fileName, Long fileLength, String mediaType) {
        Map<String, List<String>> httpHeaders = new HashMap<>();
        httpHeaders.put("Content-disposition", Lists.newArrayList("attachment; filename=" + fileName));
        httpHeaders.put("Content-Type", Lists.newArrayList(mediaType));
        httpHeaders.put("Content-Description", Lists.newArrayList("File Transfer"));
        httpHeaders.put("Content-Transfer-Encoding", Lists.newArrayList("binary"));
        httpHeaders.put("Expires", Lists.newArrayList(formatDate(0)));
        httpHeaders.put("Cache-Control", Lists.newArrayList("must-revalidate"));
        httpHeaders.put("Pragma", Lists.newArrayList("public"));
        if (fileLength != null) {
            httpHeaders.put("Content-Length", Lists.newArrayList(Long.toString(fileLength)));
        }
        return httpHeaders;
    }

    private static String formatDate(long date) {
        Instant instant = Instant.ofEpochMilli(date);
        ZonedDateTime time = ZonedDateTime.ofInstant(instant, GMT);
        return DATE_FORMATTERS[0].format(time);
    }

}
