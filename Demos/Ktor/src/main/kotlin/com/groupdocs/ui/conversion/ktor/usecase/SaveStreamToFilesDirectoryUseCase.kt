package com.groupdocs.ui.conversion.ktor.usecase

import com.groupdocs.ui.conversion.ktor.manager.PathManager
import com.groupdocs.ui.conversion.ktor.status.InternalServerException
import org.koin.core.component.KoinComponent
import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.nio.file.Files

class SaveStreamToFilesDirectoryUseCase(
    private val pathManager: PathManager
) : KoinComponent {
    operator fun invoke(fileName: String, inputStream: InputStream, rewrite: Boolean) {
        val filePathAsString = pathManager.filesDirectory.resolve(fileName).toAbsolutePath().normalize().toString()
        val filePath = pathManager.assertPathIsInsideFilesDirectory(filePathAsString)

        if (Files.exists(filePath) && !rewrite) {
            throw SaveStreamToFilesDirectoryUseCaseException("File is already exist and rewriting is not allowed!")
        }
        BufferedOutputStream(FileOutputStream(filePath.toFile())).use { outputStream ->
            inputStream.copyTo(outputStream)
        }
    }

}

class SaveStreamToFilesDirectoryUseCaseException(message: String, e: Throwable? = null) : InternalServerException(message, e)