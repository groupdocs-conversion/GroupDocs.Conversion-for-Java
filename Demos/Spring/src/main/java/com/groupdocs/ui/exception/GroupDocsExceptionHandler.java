package com.groupdocs.ui.exception;

import com.groupdocs.ui.model.response.ExceptionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.groupdocs.ui.exception.PasswordExceptions.INCORRECT_PASSWORD;
import static com.groupdocs.ui.exception.PasswordExceptions.PASSWORD_REQUIRED;

@ControllerAdvice
public class GroupDocsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TotalGroupDocsException.class)
    protected ResponseEntity<ExceptionEntity> handleTotalGroupDocsException(TotalGroupDocsException exception) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        String message = exception.getMessage();
        exceptionEntity.setMessage(message);
        if (PASSWORD_REQUIRED.equals(message) || INCORRECT_PASSWORD.equals(message)) {
            return new ResponseEntity<>(exceptionEntity, HttpStatus.OK);
        }
        if (logger.isDebugEnabled()) {
            exception.printStackTrace();
            exceptionEntity.setException(exception);
        }
        logger.error(exception.getCause() != null? exception.getCause().getLocalizedMessage() : message);
        return new ResponseEntity<>(exceptionEntity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
