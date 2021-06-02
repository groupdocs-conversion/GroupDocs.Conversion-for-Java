package com.groupdocs.ui.conversion.service;

import com.google.common.collect.Ordering;
import com.groupdocs.conversion.License;
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.handler.ConversionHandler;
import com.groupdocs.conversion.handler.ConvertedDocument;
import com.groupdocs.conversion.options.save.*;
import com.groupdocs.ui.common.config.DefaultDirectories;
import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.entity.web.request.FileTreeRequest;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.common.util.comparator.FileNameComparator;
import com.groupdocs.ui.common.util.comparator.FileTypeComparator;
import com.groupdocs.ui.conversion.config.ConversionConfiguration;
import com.groupdocs.ui.conversion.filter.DestinationTypesFilter;
import com.groupdocs.ui.conversion.model.request.ConversionPostedData;
import com.groupdocs.ui.conversion.model.response.ConversionTypesEntity;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ConversionServiceImpl implements ConversionService {

    private static final Logger logger = LoggerFactory.getLogger(ConversionServiceImpl.class);
    private List<String> supportedImageFormats =  Arrays.asList( "jp2", "ico", "psd", "svg", "bmp", "jpeg", "jpg", "tiff", "tif", "png", "gif", "emf", "wmf", "dwg", "dicom", "dxf", "jpe", "jfif" );
    private GlobalConfiguration globalConfiguration;
    private ConversionHandler handler;
    private ConversionConfiguration conversionConfiguration;

    public ConversionServiceImpl(GlobalConfiguration globalConfiguration) {
        this.globalConfiguration = globalConfiguration;
        // check files directories
        conversionConfiguration = globalConfiguration.getConversion();
        String filesDirectory = conversionConfiguration.getFilesDirectory();
        String resultDirectory = conversionConfiguration.getResultDirectory();
        DefaultDirectories.makeDirs(new File(resultDirectory));
        ConversionConfig conversionConfig = new ConversionConfig();
        conversionConfig.setStoragePath(filesDirectory);
        conversionConfig.setOutputPath(resultDirectory);
        // set GroupDocs license
        try {
            License license = new License();
            license.setLicense(globalConfiguration.getApplication().getLicensePath());
        } catch (Throwable exc) {
            logger.error("Can not verify Conversion license!");
        }
        handler = new ConversionHandler(conversionConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ConversionTypesEntity> loadFiles(FileTreeRequest fileTreeRequest) {
        String currentPath = fileTreeRequest.getPath();
        if (StringUtils.isEmpty(currentPath)) {
            currentPath = globalConfiguration.getConversion().getFilesDirectory();
        } else {
            currentPath = String.format("%s%s%s", globalConfiguration.getConversion().getFilesDirectory(), File.separator, currentPath);
        }
        File directory = new File(currentPath);
        List<ConversionTypesEntity> fileList = new ArrayList<>();
        List<File> filesList = Arrays.asList(directory.listFiles());
        try {
            // sort list of files and folders
            filesList = Ordering.from(FileTypeComparator.instance).compound(FileNameComparator.instance).sortedCopy(filesList);
            for (File file : filesList) {
                // check if current file/folder is hidden
                if (file.isHidden()) {
                    // ignore current file and skip to next one
                    continue;
                } else {
                    ConversionTypesEntity fileDescription = getFileDescriptionEntity(file);
                    // add object to array list
                    fileList.add(fileDescription);
                }
            }
            return fileList;
        } catch (Exception ex) {
            logger.error("Exception occurred while load file tree");
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    @Override
    public ConversionConfiguration getConversionConfiguration() {
        return conversionConfiguration;
    }

    @Override
    public void convert(ConversionPostedData postedData) {
        String sourceType = FilenameUtils.getExtension(postedData.getGuid());
        String destinationType = postedData.getDestinationType();
        String destinationFile = FilenameUtils.removeExtension(FilenameUtils.getName(postedData.getGuid())) + "." + destinationType;
        String resultFileName = FilenameUtils.concat(conversionConfiguration.getResultDirectory(),destinationFile);

        Dictionary<String, SaveOptions> availableSaveOptions = handler.getSaveOptions(sourceType);
        SaveOptions saveOptions = availableSaveOptions.get(destinationType);
        ConvertedDocument convertedDocument = handler.convert(postedData.getGuid(), saveOptions);

        if(convertedDocument.getPageCount() > 1 && saveOptions instanceof ImageSaveOptions){
            for(int i = 1; i <= convertedDocument.getPageCount(); i++){
                String fileName = FilenameUtils.removeExtension(resultFileName) + "-page" + i + "." + destinationType;
                convertedDocument.save(fileName,i);
            }
        }else{
            convertedDocument.save(resultFileName);
        }
    }

    @Override
    public String download(String path) throws IOException {
        if(path != null && !path.isEmpty()){

            String destinationPath = FilenameUtils.concat(conversionConfiguration.getResultDirectory(),path);
            String ext = FilenameUtils.getExtension(destinationPath);
            String fileNameWithoutExt = FilenameUtils.removeExtension(path);
            if(supportedImageFormats.contains(ext)){
                String zipName = fileNameWithoutExt + ".zip";
                File zipPath = new File(FilenameUtils.concat(conversionConfiguration.getResultDirectory(),zipName));
                File[] files = new File(conversionConfiguration.getResultDirectory()).listFiles((d, name) ->
                        name.endsWith("." + ext) && name.startsWith(fileNameWithoutExt)
                );
                if(zipPath.exists()){
                    zipPath.delete();
                }
                ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath));
                for (File filePath : files) {
                    File fileToZip = filePath;
                    zipOut.putNextEntry(new ZipEntry(fileToZip.getName()));
                    Files.copy(fileToZip.toPath(), zipOut);
                }
                zipOut.close();
                destinationPath = zipPath.getAbsolutePath();
            }
            if(new File(destinationPath).exists()){
                return destinationPath;
            }
        }
        throw new FileNotFoundException();
    }

    /**
     * Create file description
     *
     * @param file file
     * @return file description
     */
    private ConversionTypesEntity getFileDescriptionEntity(File file) {
        ConversionTypesEntity fileDescription = new ConversionTypesEntity();
        // set path to file
        fileDescription.setGuid(file.getAbsolutePath());
        // set file name
        fileDescription.setName(file.getName());
        // set is directory true/false
        fileDescription.setDirectory(file.isDirectory());
        // set file size
        fileDescription.setSize(file.length());

        String ext = FilenameUtils.getExtension(fileDescription.getGuid());
        if(ext != null && !ext.isEmpty()){
            fileDescription.conversionTypes = new ArrayList<>();
            String[] availableTypes = new DestinationTypesFilter().getPosibleConversions(ext);
            for(String type : availableTypes){
                fileDescription.conversionTypes.add(type);
            }
        }
        return fileDescription;
    }

}
