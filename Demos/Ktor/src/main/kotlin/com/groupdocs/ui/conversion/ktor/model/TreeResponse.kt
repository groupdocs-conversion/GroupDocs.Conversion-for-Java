package com.groupdocs.ui.conversion.ktor.model

data class FileDescriptionEntity(
    val guid: String? = null,
    val name: String? = null,
    val docType: String? = null,
    val directory: Boolean? = null,
    val size: Long? = null,
    val conversionTypes: List<String> = emptyList()
)