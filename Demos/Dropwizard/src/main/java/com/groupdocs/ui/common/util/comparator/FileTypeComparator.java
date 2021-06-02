package com.groupdocs.ui.common.util.comparator;

import java.io.File;
import java.util.Comparator;

/**
 * FileTypeComparator
 * Compare and sort file types - folders first
 * @author Aspose Pty Ltd
 */
public class FileTypeComparator implements Comparator<File> {

    public static FileTypeComparator instance = new FileTypeComparator();

    /**
     * Compare two file types
     * @param file1
     * @param file2
     * @return
     */
    @Override
    public int compare(File file1, File file2) {

        if (file1.isDirectory() && file2.isFile())
            return -1;
        if (file1.isDirectory() && file2.isDirectory()) {
            return 0;
        }
        if (file1.isFile() && file2.isFile()) {
            return 0;
        }
        return 1;
    }
}
