package com.groupdocs.examples.conversion.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The FilesUtils class provides utility methods to handle file paths. It allows users to configure these paths using system properties or environment variables:
 * <ul>
 *     <li><code>-Dsample.files.path</code> - Path for input files.</li>
 *     <li><code>-Dsample.output.path</code> - Path for output directories.</li>
 * </ul>
 * Additionally, the following environment variables can be used to configure file paths:
 * <ul>
 *     <li><code>FILES_PATH</code></li>
 *     <li><code>GROUPDOCS_FILES_PATH</code></li>
 *     <li><code>OUTPUT_PATH</code></li>
 *     <li><code>GROUPDOCS_OUTPUT_PATH</code></li>
 * </ul>
 * These properties are used to determine the default locations for input and output files.
 * If these properties are not set, default value for files will be `Resources/SampleFiles`, for output will be `Resources/Output`.
 */

public class FilesUtils {
    private static final Path FILES_PATH;
    private static final Path OUTPUT_PATH;

    static {
        System.out.println("\n-------------------------------------------------------------------------------");

        // Get the path to the files directory
        String filesPath = System.getProperty("filesPath");
        if (filesPath == null || filesPath.isEmpty()) {
            final Optional<String> filesPathOptional = Stream.of("FILES_PATH", "GROUPDOCS_FILES_PATH")
                    .map(System::getenv)
                    .filter(Objects::nonNull)
                    .findFirst();
            if (filesPathOptional.isPresent()) {
                filesPath = filesPathOptional.get();
            }
        }
        FILES_PATH = Paths.get(filesPath == null || filesPath.isEmpty() ? "Resources/SampleFiles" : filesPath).toAbsolutePath().normalize();
        System.out.println("Files path: " + FILES_PATH);

        // Get the path to the output directory
        String outputPath = System.getProperty("outputPath");
        if (outputPath == null || outputPath.isEmpty()) {
            final Optional<String> outputPathOptional = Stream.of("OUTPUT_PATH", "GROUPDOCS_OUTPUT_PATH")
                    .map(System::getenv)
                    .filter(Objects::nonNull)
                    .findFirst();
            if (outputPathOptional.isPresent()) {
                outputPath = outputPathOptional.get();
            }
        }
        OUTPUT_PATH = Paths.get(outputPath == null || outputPath.isEmpty() ? "Resources/Output" : outputPath).toAbsolutePath().normalize();
        System.out.println("Output path: " + OUTPUT_PATH);

        System.out.println("-------------------------------------------------------------------------------\n");
    }

    /**
     * Constructs the full path for input files that are located in the configured files directory.
     *
     * @param relativePath The relative path to resolve against the base files directory path. It can be a file name or a subdirectory structure.
     * @return An absolute Path object representing the resolved file path, which includes the full path to the input file.
     */
    public static Path makeFilesPath(String relativePath) {
        return FILES_PATH.resolve(relativePath).toAbsolutePath().normalize();
    }

    /**
     * Constructs the full path for output files that need to be saved in the configured output directory.
     *
     * @param relativePath The relative path to resolve against the base output directory path. It can be a file name or a subdirectory structure.
     * @return An absolute Path object representing the resolved output path, which includes the full path to the output file.
     */
    public static Path makeOutputPath(String relativePath) {
        final Path normalizedPath = OUTPUT_PATH.resolve(relativePath).toAbsolutePath().normalize();
        if (Files.notExists(normalizedPath.getParent())) {
            try {
                Files.createDirectories(normalizedPath.getParent());
            } catch (IOException e) {
                throw new RuntimeException("Failed to create directories for output path: " + normalizedPath, e);
            }
        }
        return normalizedPath;
    }

    public static String obtainExtension(Path path) {
        return path.getNameCount() > 1 ? path.getFileName().toString().substring(path.getFileName().toString().lastIndexOf('.')) : "";
    }

    public static Path makeFontPath(String relativePath) {
        return makeFilesPath("fonts/" + relativePath);
    }
}
