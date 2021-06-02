package com.groupdocs.ui.model.response;

/**
 * FileDescriptionEntity
 *
 * @author Aspose Pty Ltd
 */
public class FileDescriptionEntity {
    private String guid;
    private String name;
    private String docType;
    private Boolean isDirectory;
    private Long size;

    /**
     * Get guid (file id)
     * @return guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Set guid (File id)
     * @param guid guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * Get file name
     * @return file name
     */
    public String getName() {
        return name;
    }

    /**
     * Set file name
     * @param name file name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get document type
     * @return document type
     */
    public String getDocType() {
        return docType;
    }

    /**
     * Set document type
     * @param docType document type
     */
    public void setDocType(String docType) {
        this.docType = docType;
    }

    /**
     * Check if path is directory
     * @return true/false flag
     */
    public Boolean isDirectory() {
        return isDirectory;
    }

    /**
     * Set is directory flag
     * @param directory true/false flag
     */
    public void setDirectory(Boolean directory) {
        isDirectory = directory;
    }

    /**
     * Get file size
     * @return file size
     */
    public Long getSize() {
        return size;
    }

    /**
     * Set file size
     * @param size file size
     */
    public void setSize(Long size) {
        this.size = size;
    }

}
