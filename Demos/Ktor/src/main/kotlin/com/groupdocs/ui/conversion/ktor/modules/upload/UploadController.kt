package com.groupdocs.ui.conversion.ktor.modules.upload

import com.groupdocs.ui.conversion.ktor.model.UploadResponse
import com.groupdocs.ui.conversion.ktor.modules.BaseController
import com.groupdocs.ui.conversion.ktor.usecase.SaveStreamToFilesDirectoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.io.BufferedInputStream
import java.net.URL
import java.nio.file.Paths

class UploadControllerImpl(
    private val saveStreamToFilesDirectory: SaveStreamToFilesDirectoryUseCase
) : BaseController(), UploadController, KoinComponent {
    override suspend fun uploadDisk(fileName: String, inputStream: BufferedInputStream, rewrite: Boolean): UploadResponse {
        saveStreamToFilesDirectory(fileName, inputStream, rewrite)
        return UploadResponse(fileName)
    }

    override suspend fun uploadUrl(fileUrl: String, rewrite: Boolean): UploadResponse {
        val url = URL(fileUrl)
        val fileName = Paths.get(url.path).fileName.toString()

        withContext(Dispatchers.IO) {
            url.openStream().use { inputStream ->
                saveStreamToFilesDirectory(fileName, inputStream, rewrite)
            }
        }
        return UploadResponse(fileName)
    }
}

interface UploadController {
    suspend fun uploadDisk(fileName: String, inputStream: BufferedInputStream, rewrite: Boolean): UploadResponse
    suspend fun uploadUrl(fileUrl: String, rewrite: Boolean): UploadResponse
}