package com.groupdocs.ui.conversion.ktor.model

data class ConvertRequest(
    val path: String?,
    val guid: String?,
    val password: String? = null,
    val url: String?,
    val destinationType: String?
)