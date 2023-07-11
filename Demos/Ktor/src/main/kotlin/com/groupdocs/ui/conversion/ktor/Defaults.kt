package com.groupdocs.ui.conversion.ktor


interface Defaults {
    companion object {
        const val DEFAULT_LICENSE_PATH = "Licenses"
        const val DEFAULT_LICENSE_EXTENSION = ".lic"
    }

    interface Conversion {
        enum class FilesProviderType {
            LOCAL
        }

        companion object {
            const val DEFAULT_PREVIEW_PAGE_WIDTH = 768
            const val DEFAULT_PREVIEW_PAGE_RATIO = 1.3f
            val DEFAULT_FILES_PROVIDER_TYPE = FilesProviderType.LOCAL
            val DEFAULT_TEMP_DIRECTORY: String? = System.getProperty("java.io.tmpdir")
        }
    }

    interface Local {
        companion object {
            const val DEFAULT_FILES_DIRECTORY = "DocumentSamples"
            const val DEFAULT_RESULT_DIRECTORY = ""
        }
    }
}
