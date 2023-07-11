package com.groupdocs.ui.conversion.ktor.modules.home

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.homeModule() {
    route("/") {
        get {
            call.respondHtmlTemplate(HomeTemplate()) {
                pageTitle {
                    +"GroupDocs.Conversion for Java Ktor"
                }
            }
        }
    }

    get("/app-name") {
        call.respondText("conversion-ktor")
    }
}