package com.groupdocs.ui.model.response;

/**
 * ExceptionEntity
 *
 * @author Aspose Pty Ltd
 */
public class ExceptionEntity {
    private String message;
    private Exception exception;

    public ExceptionEntity() {
    }

    public ExceptionEntity(String message) {
        this.message = message;
    }

    public ExceptionEntity(String message, Exception exception) {
        this.message = message;
        this.exception = exception;
    }

    /**
     * Get exception message
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set exception message
     * @param message message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get exception
     * @return exception
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Set exception
     * @param exception exception
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

}

