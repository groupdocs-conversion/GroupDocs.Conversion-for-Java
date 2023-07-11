package com.groupdocs.ui.conversion.ktor.modules.config

import com.groupdocs.ui.conversion.ktor.model.ConfigResponse
import com.groupdocs.ui.conversion.ktor.modules.BaseController
import org.koin.core.component.KoinComponent

class ConfigControllerImpl : BaseController(), ConfigController, KoinComponent {

    override suspend fun config(): ConfigResponse {
        return ConfigResponse(
            download = converterConfig.common.download,
            upload = converterConfig.common.upload,
            browse = converterConfig.common.browse,
            rewrite = converterConfig.common.rewrite,
            defaultResultDirectory = "DocumentSamples/Conversion/Converted",
            filesDirectory = converterConfig.local.filesDirectoryOrDefault.toString(),
            resultDirectory = converterConfig.local.resultDirectoryOrDefault.toString()
        )
    }

}

interface ConfigController {
    suspend fun config(): ConfigResponse
}