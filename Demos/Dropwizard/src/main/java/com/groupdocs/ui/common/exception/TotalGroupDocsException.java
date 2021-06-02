package com.groupdocs.ui.common.exception;

/**
 * Wrapper for application's exceptions
 */
public class TotalGroupDocsException extends RuntimeException {

    public TotalGroupDocsException(String message) {
        super(message);
    }

    public TotalGroupDocsException(String message, Throwable cause) {
        super(message, cause);
    }
}
