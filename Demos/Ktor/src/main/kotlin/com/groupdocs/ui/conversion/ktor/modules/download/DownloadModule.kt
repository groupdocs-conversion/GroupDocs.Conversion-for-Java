package com.groupdocs.ui.conversion.ktor.modules.download

import com.groupdocs.ui.conversion.ktor.status.InternalServerException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.ktor.ext.inject
import java.io.ByteArrayOutputStream
import java.nio.file.Paths

fun Route.downloadModule() {
    val downloadController by inject<DownloadController>()

    get("/downloadDocument") {
        call.parameters["path"]?.let { guid ->
            val out = ByteArrayOutputStream()
            val resultFileName = downloadController.download(
                fileName = guid,
                outputStream = out
            )
            call.response.headers.apply {
                append("Content-disposition", "attachment; filename=${resultFileName}")
                append("Content-Description", "File Transfer")
                append("Content-Transfer-Encoding", "binary")
                append("Cache-Control", "must-revalidate")
                append("Pragma", "public")
            }

            call.respondOutputStream(
                status = HttpStatusCode.OK,
                contentType = ContentType.Application.OctetStream
            ) {
                withContext(Dispatchers.IO) {
                    write(out.toByteArray())
                }
            }
        } ?: throw InternalServerException("Document guid is not provided!")
    }
}