package com.groupdocs.ui.conversion.ktor.modules

import com.groupdocs.ui.conversion.ktor.config.ConverterConfig
import org.koin.java.KoinJavaComponent.inject

open class BaseController {

    protected val converterConfig by inject<ConverterConfig>(ConverterConfig::class.java)
}