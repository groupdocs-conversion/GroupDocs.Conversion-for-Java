package com.groupdocs.ui.conversion.ktor.status

import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun StatusPagesConfig.generalStatusPages() {
    exception<Throwable> { call, cause ->
        call.application.environment.log.error("Something unexpected happened!", cause)
        call.respondText(text = "Something unexpected happened!", status = HttpStatusCode.InternalServerError)
    }
}