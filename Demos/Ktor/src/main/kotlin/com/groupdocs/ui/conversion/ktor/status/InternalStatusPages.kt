package com.groupdocs.ui.conversion.ktor.status

import com.groupdocs.ui.conversion.ktor.model.ExceptionResponse
import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun StatusPagesConfig.internalStatusPages() {
    exception<InternalServerException> { call, cause ->
        call.application.environment.log.error(cause.message, cause)
        call.respond(HttpStatusCode.InternalServerError, ExceptionResponse(cause.message))
    }
}

open class InternalServerException(override val message: String = "Internal server error", throwable: Throwable? = null) : Exception(message, throwable)