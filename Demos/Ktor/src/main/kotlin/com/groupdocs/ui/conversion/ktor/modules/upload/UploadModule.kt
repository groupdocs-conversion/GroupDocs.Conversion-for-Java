package com.groupdocs.ui.conversion.ktor.modules.upload

import com.groupdocs.ui.conversion.ktor.config.ConverterConfig
import com.groupdocs.ui.conversion.ktor.model.UploadResponse
import com.groupdocs.ui.conversion.ktor.status.InternalServerException
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.io.BufferedInputStream


fun Route.uploadModule() {
    val uploadController by inject<UploadController>()
    val converterConfig by inject<ConverterConfig>()

    post("/uploadDocument") {
        val isUploadEnabled = converterConfig.common.upload
        if (!isUploadEnabled) {
            throw InternalServerException("Files uploading is disabled!")
        }

        var url: String? = null
        var rewrite: Boolean = false
        var fileName: String? = null
        var inputStream: BufferedInputStream? = null

        call.receiveMultipart()
            .forEachPart { part ->
                when (part) {
                    is PartData.FormItem -> {
                        when (part.name) {
                            "url" -> url = part.value
                            "rewrite" -> rewrite = part.value.toBoolean()
                        }
                    }
                    is PartData.FileItem -> {
                        fileName = part.originalFileName as String
                        inputStream = part.streamProvider().buffered()
                    }
                    else -> call.application.log.warn("Unsupported multipart item: $part")
                }
            }

        var response: UploadResponse? = null
        url?.let {
            response = uploadController.uploadUrl(it, rewrite)
        }
        inputStream?.let {
            if (fileName == null) {
                throw InternalServerException("Upload request is not valid! File name is not present.")
            }

            response = uploadController.uploadDisk(fileName!!, inputStream!!, rewrite)
        }

        response?.let {
            call.respond(HttpStatusCode.OK, it)
        } ?: throw InternalServerException("Upload request is not valid! Url or stream must be provided.")
    }
}