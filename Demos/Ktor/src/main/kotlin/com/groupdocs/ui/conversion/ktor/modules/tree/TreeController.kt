package com.groupdocs.ui.conversion.ktor.modules.tree

import com.groupdocs.conversion.filetypes.FileType
import com.groupdocs.ui.conversion.ktor.*
import com.groupdocs.ui.conversion.ktor.manager.PathManager
import com.groupdocs.ui.conversion.ktor.model.FileDescriptionEntity
import com.groupdocs.ui.conversion.ktor.model.TreeRequest
import com.groupdocs.ui.conversion.ktor.modules.BaseController
import com.groupdocs.ui.conversion.ktor.usecase.GetLocalFilesUseCase
import com.groupdocs.ui.conversion.ktor.usecase.LocalStorageEntry
import org.apache.commons.io.FilenameUtils
import org.koin.core.component.KoinComponent
import java.util.*

class TreeControllerImpl(
    private val getLocalFiles: GetLocalFilesUseCase,
    private val pathManager: PathManager
) : BaseController(), TreeController, KoinComponent {
    override suspend fun tree(request: TreeRequest): List<FileDescriptionEntity> {
        val path = pathManager.assertPathIsInsideFilesDirectory(request.path)

        val localFiles = getLocalFiles(path)
        return localFiles.sortedBy {
            it is LocalStorageEntry.File
        }.map {
            val docType = if (it is LocalStorageEntry.File) FileType.fromExtension(it.name).fileFormat else null
            val isDirectory = it is LocalStorageEntry.Directory
            val size = if (it is LocalStorageEntry.File) it.size else 0

            val filesDirectory = pathManager.filesDirectory
            val fileFullPath = it.fullPath
            val guid = filesDirectory.relativize(fileFullPath).toString()
            val extension = parseFileExtension(guid);
            FileDescriptionEntity(
                guid = guid,
                name = it.name,
                docType = docType,
                directory = isDirectory,
                size = size,
                conversionTypes = getPosibleConversions(extension).toList()
            )
        }
    }

    companion object DestinationTypesFilter {
        fun getPosibleConversions(extension: String?): Array<String> {
            return when (extension) {
                "csv" -> csvTypes
                "tsv" -> tsvTypes
                "webp" -> webpTypes
                "html", "htm" -> htmlTypes
                "ppt", "pps", "pptx", "ppsx", "odp", "otp", "potx", "potm", "pptm", "ppsm" -> slidesTypes
                "tiff", "tif", "jpeg", "jpg", "png", "gif", "bmp", "ico", "psd", "svg", "jp2" -> imageTypes
                "ods", "xls", "xlsb", "xlsx", "xlsm", "xls2003", "xltx", "xltm" -> cellsTypes
                else -> allTypes
            }
        }

        fun parseFileExtension(documentGuid: String?): String? {
            return FilenameUtils.getExtension(documentGuid)?.lowercase(Locale.getDefault())
        }
    }
}

interface TreeController {
    suspend fun tree(request: TreeRequest): List<FileDescriptionEntity>
}