package com.groupdocs.ui.exception;

import com.groupdocs.ui.model.response.ExceptionEntity;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

import static com.groupdocs.ui.exception.PasswordExceptions.INCORRECT_PASSWORD;
import static com.groupdocs.ui.exception.PasswordExceptions.PASSWORD_REQUIRED;

@Provider
public class GroupDocsExceptionHandler implements ExceptionMapper<TotalGroupDocsException> {
    private static final Logger logger = Logger.getLogger(GroupDocsExceptionHandler.class);

    @Override
    public Response toResponse(TotalGroupDocsException exception) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        String message = exception.getMessage();
        exceptionEntity.setMessage(message);
        if (PASSWORD_REQUIRED.equals(message) || INCORRECT_PASSWORD.equals(message)) {
            return Response.status(RestResponse.Status.OK).entity(exceptionEntity).build();
        }
        if (logger.isDebugEnabled()) {
            exception.printStackTrace();
            exceptionEntity.setException(exception);
        }
        logger.error(exception.getCause() != null? exception.getCause().getLocalizedMessage() : message);
        return Response.status(RestResponse.Status.INTERNAL_SERVER_ERROR).entity(exceptionEntity).build();
    }

}
