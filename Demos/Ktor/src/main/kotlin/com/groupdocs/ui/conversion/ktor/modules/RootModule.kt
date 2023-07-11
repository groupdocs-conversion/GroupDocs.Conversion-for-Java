package com.groupdocs.ui.conversion.ktor.modules

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Routing.rootModule() {

    get("/") {
        call.respondRedirect("/conversion/")
    }
}