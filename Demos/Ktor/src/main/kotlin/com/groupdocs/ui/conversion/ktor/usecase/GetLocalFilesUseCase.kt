package com.groupdocs.ui.conversion.ktor.usecase

import com.groupdocs.ui.conversion.ktor.status.InternalServerException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import java.nio.file.Files
import java.nio.file.Path

class GetLocalFilesUseCase : KoinComponent {
    suspend operator fun invoke(directory: Path): List<LocalStorageEntry> = withContext(Dispatchers.IO) {
        if (Files.notExists(directory)) {
            throw GetLocalFilesException("Directory does not exist: ${directory.fileName}")
        }
        try {
            val entries = mutableListOf<LocalStorageEntry>()
            Files.newDirectoryStream(directory).use { directoryStream ->
                directoryStream.forEach { path ->
                    val entry: LocalStorageEntry = when (Files.isDirectory(path)) {
                        true -> {
                            LocalStorageEntry.Directory(
                                name = path.fileName.toString(),
                                parentPath = directory
                            )
                        }
                        else -> {
                            LocalStorageEntry.File(
                                name = path.fileName.toString(),
                                parentPath = directory,
                                size = Files.size(path)
                            )
                        }
                    }
                    entries.add(entry)
                }
            }
            entries
        } catch (e: Exception) {
            throw GetLocalFilesException("can't get content of $directory", e)
        }
    }
}

sealed class LocalStorageEntry(val name: String, val parentPath: Path) {
    class File(name: String, val size: Long, parentPath: Path) : LocalStorageEntry(name, parentPath)
    class Directory(name: String, parentPath: Path) : LocalStorageEntry(name, parentPath)

    val fullPath get() = parentPath.resolve(name)
}

class GetLocalFilesException(message: String, e: Throwable? = null) : InternalServerException(message, e)