package com.groupdocs.ui.conversion.ktor.modules.convert

import com.groupdocs.conversion.Converter
import com.groupdocs.ui.conversion.ktor.manager.PathManager
import com.groupdocs.ui.conversion.ktor.model.ConvertRequest
import com.groupdocs.ui.conversion.ktor.modules.BaseController
import org.apache.commons.io.FilenameUtils
import org.koin.core.component.KoinComponent

class ConvertControllerImpl(
    private val pathManager: PathManager
) : BaseController(), ConvertController, KoinComponent {
    override suspend fun convert(request: ConvertRequest) {
        val destinationType: String? = request.destinationType
        val destinationFile =
            FilenameUtils.removeExtension(FilenameUtils.getName(request.guid)) + "." + destinationType
        val resultFileName =
            FilenameUtils.concat(pathManager.resultDirectory.toString(), destinationFile)

        val converter =
            Converter(FilenameUtils.concat(converterConfig.local.filesDirectoryOrDefault.toString(), request.guid))
        val convertOptions = converter.possibleConversions.getTargetConversion(destinationType).convertOptions
        converter.convert(resultFileName, convertOptions)
    }
}

interface ConvertController {
    suspend fun convert(request: ConvertRequest)
}