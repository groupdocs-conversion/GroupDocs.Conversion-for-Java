package com.groupdocs.ui.common.util.comparator;

import java.io.File;
import java.util.Comparator;

/**
 * FileNameComparator
 * Compare and sort file names alphabetically
 * @author Aspose Pty Ltd
 */
public class FileNameComparator implements Comparator<File> {

    public static FileNameComparator instance = new FileNameComparator();

    /**
     * Compare two file names
     * @param file1
     * @param file2
     * @return int
     */
    @Override
    public int compare(File file1, File file2) {

        return String.CASE_INSENSITIVE_ORDER.compare(file1.getName(),
                file2.getName());
    }
}
