package com.groupdocs.ui.conversion.ktor.modules.convert

import com.groupdocs.ui.conversion.ktor.model.ConvertRequest
import com.groupdocs.ui.conversion.ktor.model.ErrorResponse
import com.groupdocs.ui.conversion.ktor.status.InternalServerException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.convertModule() {
    val convertController by inject<ConvertController>()

    post("/convert") {
        try {
            val request = call.receive<ConvertRequest>()
            convertController.convert(request)
            call.respond(HttpStatusCode.OK)
        } catch (e: InternalServerException) {
            call.respond(
                status = HttpStatusCode.InternalServerError,
                message = ErrorResponse(
                    message = if (e.message == "File's types not supported") {
                        "Document types are not supported in sample app, anyway, it is still supported by GroupDocs.Conversion itself"
                    } else {
                        e.message
                    }
                )
            )
        }
    }
}