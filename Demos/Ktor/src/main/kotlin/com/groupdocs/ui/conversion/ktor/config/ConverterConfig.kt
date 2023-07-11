package com.groupdocs.ui.conversion.ktor.config

import com.groupdocs.ui.conversion.ktor.Defaults
import java.nio.file.Path

@kotlinx.serialization.Serializable
data class ConverterConfig(
    val common: Common = Common(),
    val conversion: Conversion = Conversion(),
    val local: Local = Local(),
    private val licensePath: String = ""
) {
    val licensePathOrDefault: String
        get() = licensePath.ifBlank { Defaults.DEFAULT_LICENSE_PATH }
}

@kotlinx.serialization.Serializable
data class Common(
    val pageSelector: Boolean = false,
    val download: Boolean = false,
    val upload: Boolean = false,
    val print: Boolean = false,
    val browse: Boolean = false,
    val rewrite: Boolean = false,
    val enableRightClick: Boolean = false
)

@kotlinx.serialization.Serializable
data class Conversion(
    private val filesProviderType: String = "",
    val preloadResultPageCount: Int = 0,
    private val previewPageWidth: Int = 0,
    private val previewPageRatio: Float = 0f,
    private val tempDirectory: String = "",
) {
    val filesProviderTypeOrDefault: Defaults.Conversion.FilesProviderType
        get() =
            when (filesProviderType.uppercase()) {
                in Defaults.Conversion.FilesProviderType.values()
                    .map { it.name.uppercase() } -> Defaults.Conversion.FilesProviderType.valueOf(filesProviderType.uppercase())
                else -> Defaults.Conversion.DEFAULT_FILES_PROVIDER_TYPE
            }
    val tempDirectoryOrDefault: String
        get() = tempDirectory.ifBlank { Defaults.Conversion.DEFAULT_TEMP_DIRECTORY }
            ?: throw IllegalStateException("Can't get temp directory!")
    val previewPageWidthOrDefault: Int
        get() = if (previewPageWidth == 0) Defaults.Conversion.DEFAULT_PREVIEW_PAGE_WIDTH else previewPageWidth
    val previewPageRatioOrDefault: Float
        get() = if (previewPageRatio == 0f) Defaults.Conversion.DEFAULT_PREVIEW_PAGE_RATIO else previewPageRatio
}

@kotlinx.serialization.Serializable
data class Local(
    private val filesDirectory: String = "",
    private val resultDirectory: String = "",
) {

    val filesDirectoryOrDefault: Path
        get() = Path.of(filesDirectory.ifBlank { Defaults.Local.DEFAULT_FILES_DIRECTORY })

    val resultDirectoryOrDefault: Path
        get() = Path.of(resultDirectory.ifBlank { Defaults.Local.DEFAULT_RESULT_DIRECTORY })
}