package com.groupdocs.ui.conversion.ktor.modules.config

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.configModule() {
    val configController by inject<ConfigController>()

    get("/loadConfig") {
        val response = configController.config()
        call.respond(HttpStatusCode.OK, response)
    }
}