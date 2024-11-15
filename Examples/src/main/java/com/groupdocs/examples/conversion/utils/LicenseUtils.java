package com.groupdocs.examples.conversion.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class LicenseUtils {
    /**
     * <p>
     * Creates a license input stream by checking various sources including system properties, environment variables, and local file paths.
     * </p>
     * The method prioritizes the following sources in order:
     * <ul>
     *   <li>System property `groupdocs.license.path`. Example: <i>-Dgroupdocs.license.path=/home/user/license.lic</i></li>
     *   <li>Environment variable `LIC_GROUPDOCS`. Example: <i>export LIC_GROUPDOCS=/home/user/license.lic</i></li>
     *   <li>Environment variable `CONHOLDATE_LIC_PATH`. Example: <i>export CONHOLDATE_LIC_PATH=/home/user/license.lic</i></li>
     *   <li>Environment variable `GROUPDOCS_LIC_PATH`. Example: <i>export GROUPDOCS_LIC_PATH=/home/user/license.lic</i></li>
     *   <li>File with `.lic` extension in the project directory.</li>
     * </ul>
     * If none of these sources provide a valid license file, null will be returned.
     * <p>
     *     <i>Note: the path to license can be a URL.</i>
     * </p>
     *
     * @return An InputStream for the license file if found.
     * @throws RuntimeException if there is an error accessing any of the specified sources or reading from files.
     */
    public static InputStream createLicenseStream() {
        final String licensePath = obtainLicensePath();

        if (licensePath == null) {
            return null;
        }
        try {
            if (licensePath.matches("https?://.*")) {
                final URL website = new URL(licensePath);
                return website.openStream();
            } else {
                return Files.newInputStream(Paths.get(licensePath));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error accessing license file: " + e.getMessage(), e);
        }
    }

    /**
     * <p>
     * Creates a license path or URL by checking various sources including system properties, environment variables, and local file paths.
     * </p>
     * The method prioritizes the following sources in order:
     * <ul>
     *   <li>System property `groupdocs.license.path`. Example: <i>-Dgroupdocs.license.path=/home/user/license.lic</i></li>
     *   <li>Environment variable `LIC_GROUPDOCS`. Example: <i>export LIC_GROUPDOCS=/home/user/license.lic</i></li>
     *   <li>Environment variable `CONHOLDATE_LIC_PATH`. Example: <i>export CONHOLDATE_LIC_PATH=/home/user/license.lic</i></li>
     *   <li>Environment variable `GROUPDOCS_LIC_PATH`. Example: <i>export GROUPDOCS_LIC_PATH=/home/user/license.lic</i></li>
     *   <li>File with `.lic` extension in the project directory.</li>
     * </ul>
     * If none of these sources provide a valid license file, null will be returned.
     * <p>
     *     <i>Note: the path to license can be a URL.</i>
     * </p>
     *
     * @return A path or URL to the license file if found.
     * @throws RuntimeException if there is an error accessing any of the specified sources or reading from files.
     */
    public static String obtainLicensePath() {
        String licensePath = System.getProperty("licensePath");
        if (licensePath == null || licensePath.isEmpty()) {
            final Optional<String> licPathOptional = Stream.of("CONHOLDATE_LIC_PATH", "GROUPDOCS_LIC_PATH")
                    .map(System::getenv)
                    .filter(Objects::nonNull)
                    .findFirst();
            if (licPathOptional.isPresent()) {
                licensePath = licPathOptional.get();
            }
        }
        if (isUrl(licensePath)) {
            return licensePath;
        }
        if (licensePath == null) {
            licensePath = ""; // current directory
        }
        final Path licPath = Paths.get(licensePath);
        if (!licensePath.isEmpty() && Files.exists(licPath) && Files.isRegularFile(licPath)) {
            return licPath.toAbsolutePath().normalize().toString();
        }
        try (final Stream<Path> files = Files.list(licPath)) {
            final Optional<Path> licFileOptional = files.filter(p -> p.getFileName().toString().toLowerCase().endsWith(".lic")).findFirst();
            if (licFileOptional.isPresent()) {
                return licFileOptional.get().toAbsolutePath().normalize().toString();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error accessing license file: " + e.getMessage(), e);
        }

        System.err.println("\nNone of license sources was provided:\n" +
                "\t1. System property `groupdocs.license.path` ( Example: `-Dgroupdocs.license.path=/home/user/license.lic`)\n" +
                "\t2. Environment variable `LIC_GROUPDOCS`\n" +
                "\t3. Environment variable `CONHOLDATE_LIC_PATH`\n" +
                "\t4. Environment variable `GROUPDOCS_LIC_PATH`\n" +
                "\t5. File with `.lic` extension in project directory\n" +
                "\nLicense was NOT set!\n");
        return null;
    }

    public static boolean isUrl(String licensePath) {
        return licensePath != null && licensePath.matches("https?://.*");
    }
}
