package com.groupdocs.ui.conversion.ktor.modules.download

import com.groupdocs.ui.conversion.ktor.imageTypes
import com.groupdocs.ui.conversion.ktor.manager.PathManager
import com.groupdocs.ui.conversion.ktor.modules.BaseController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.commons.io.FilenameUtils
import org.koin.core.component.KoinComponent
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

private val supportedImageFormats: List<String> = mutableListOf(
    "jp2",
    "ico",
    "psd",
    "svg",
    "bmp",
    "jpeg",
    "jpg",
    "tiff",
    "tif",
    "png",
    "gif",
    "emf",
    "wmf",
    "dwg",
    "dicom",
    "dxf",
    "jpe",
    "jfif"
)
class DownloadControllerImpl(
    private val pathManager: PathManager
) : BaseController(), DownloadController, KoinComponent {
    override suspend fun download(fileName: String, outputStream: OutputStream): String {
        val resultPath = pathManager.resultDirectory.resolve(fileName).toAbsolutePath().normalize().toString()
        var resultDocumentPath = pathManager.assertPathIsInsideFilesDirectory(resultPath)

        val ext = FilenameUtils.getExtension(resultPath)
        val fileNameWithoutExt = FilenameUtils.removeExtension(fileName)

        var zipName: String? = null

        if (supportedImageFormats.contains(ext) && "tiff" != ext && "tif" != ext) {
            zipName = fileNameWithoutExt + ".zip"
            val zipPath = File(FilenameUtils.concat(pathManager.resultDirectory.toString(), zipName))
            val files: Array<out File>? =
                File(pathManager.resultDirectory.toString()).listFiles { d: File?, name: String ->
                    name.endsWith(".$ext") && name.startsWith(
                        fileNameWithoutExt
                    )
                }
            if (zipPath.exists()) {
                zipPath.delete()
            }
            val zipOut = ZipOutputStream(withContext(Dispatchers.IO) {
                FileOutputStream(zipPath)
            })
            if (files != null) {
                for (filePath in files) {
                    withContext(Dispatchers.IO) {
                        zipOut.putNextEntry(ZipEntry(filePath.name))
                        Files.copy(filePath.toPath(), zipOut)
                    }

                }
            }
            withContext(Dispatchers.IO) {
                zipOut.close()
            }
            resultDocumentPath = Paths.get(zipPath.absolutePath)
        }

        withContext(Dispatchers.IO) {
            Files.copy(resultDocumentPath, outputStream)
        }
        return zipName ?: fileName
    }

}

interface DownloadController {
    suspend fun download(fileName: String, outputStream: OutputStream): String
}