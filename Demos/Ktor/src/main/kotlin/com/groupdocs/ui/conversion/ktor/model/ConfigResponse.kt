package com.groupdocs.ui.conversion.ktor.model

data class ConfigResponse(
    val download: Boolean = true,
    val upload: Boolean = true,
    val browse: Boolean = true,
    val rewrite: Boolean = true,
    val defaultResultDirectory: String,
    val filesDirectory: String,
    val resultDirectory: String,
)