package com.groupdocs.ui.conversion.ktor.model

data class ErrorResponse(
    val message: String,
    val exception: Exception? = null
)
