package com.groupdocs.ui.common.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class DefaultDirectories {
    private static final Logger logger = LoggerFactory.getLogger(DefaultDirectories.class);

    public static final String LIC = ".lic";
    public static final String LICENSES = "Licenses";
    public static final String DOCUMENT_SAMPLES = "DocumentSamples";

    public static String defaultLicenseDirectory() {
        Path defaultLicFolder = FileSystems.getDefault().getPath(LICENSES).toAbsolutePath();
        File licFolder = defaultLicFolder.toFile();
        if (licFolder.exists()) {
            Path defaultLicFile = getDefaultLicFile(licFolder);
            if (defaultLicFile != null) {
                return defaultLicFile.toString();
            }
        }
        licFolder.mkdirs();
        logger.info("License file path is incorrect, application launched in trial mode");
        return "";
    }

    public static String defaultConversionDirectory(){
        return getDefaultDir("");
    }

    public static String defaultConversionDirectory(String pathWithinDefaultFolder) {
        return getDefaultDir(pathWithinDefaultFolder);
    }



    public static String getDefaultDir(String folder) {
        String dir = DOCUMENT_SAMPLES + File.separator + folder;
        Path path = FileSystems.getDefault().getPath(dir).toAbsolutePath();
        makeDirs(path.toFile());
        return path.toString();
    }

    public static void makeDirs(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String relativePathToAbsolute(String path) {
        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();

        if (StringUtils.isEmpty(path)) {
            return FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        }

        for (Path root : rootDirectories) {
            if (path.startsWith(root.toString())) {
                makeDirs(new File(path));
                return path;
            }
        }

        Path absolutePath = FileSystems.getDefault().getPath(path).toAbsolutePath();
        makeDirs(absolutePath.toFile());
        return absolutePath.toString();
    }

    public static Path getDefaultLicFile(File licFolder) {
        for (File file : licFolder.listFiles()) {
            if (file.getName().endsWith(LIC)) {
                return FileSystems.getDefault().getPath(LICENSES + File.separator + file.getName()).toAbsolutePath();
            }
        }
        return null;
    }
}
