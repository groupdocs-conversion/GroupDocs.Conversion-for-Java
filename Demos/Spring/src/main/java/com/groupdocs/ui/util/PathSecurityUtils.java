package com.groupdocs.ui.util;

import com.groupdocs.ui.exception.TotalGroupDocsException;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class PathSecurityUtils {

    public static final String ACCESS_DENIED = "Access denied";

    private PathSecurityUtils() {
    }

    public static Path resolveInsideBaseDirectory(String baseDirectory, String userGuid) {
        if (userGuid == null || userGuid.trim().isEmpty()) {
            throw new TotalGroupDocsException(ACCESS_DENIED);
        }

        if (userGuid.contains("://")) {
            throw new TotalGroupDocsException(ACCESS_DENIED);
        }

        Path base = Paths.get(baseDirectory).toAbsolutePath().normalize();
        Path userPath = Paths.get(userGuid.replace('/', File.separatorChar));

        Path resolved;
        if (userPath.isAbsolute()) {
            resolved = userPath.normalize();
        } else {
            resolved = base.resolve(userPath).normalize();
        }

        if (!resolved.startsWith(base)) {
            throw new TotalGroupDocsException(ACCESS_DENIED);
        }
        return resolved;
    }

    public static String resolveInsideBaseDirectoryAsString(String baseDirectory, String userGuid) {
        return resolveInsideBaseDirectory(baseDirectory, userGuid).toString();
    }

    public static Path resolveInsideBaseDirectoryOrRoot(String baseDirectory, String userPath) {
        if (userPath == null || userPath.trim().isEmpty() || ".".equals(userPath.trim())) {
            return Paths.get(baseDirectory).toAbsolutePath().normalize();
        }
        return resolveInsideBaseDirectory(baseDirectory, userPath);
    }

    public static String sanitizeFileName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new TotalGroupDocsException(ACCESS_DENIED);
        }

        String fileName = Paths.get(name).getFileName().toString();
        if (fileName.isEmpty() || fileName.contains("..")) {
            throw new TotalGroupDocsException(ACCESS_DENIED);
        }
        return fileName;
    }
}
