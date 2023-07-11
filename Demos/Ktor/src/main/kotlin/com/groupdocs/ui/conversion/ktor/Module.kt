package com.groupdocs.ui.conversion.ktor

import com.groupdocs.ui.conversion.ktor.modules.config.configModule
import com.groupdocs.ui.conversion.ktor.modules.convert.convertModule
import com.groupdocs.ui.conversion.ktor.modules.download.downloadModule
import com.groupdocs.ui.conversion.ktor.modules.home.homeModule
import com.groupdocs.ui.conversion.ktor.modules.rootModule
import com.groupdocs.ui.conversion.ktor.modules.tree.treeModule
import com.groupdocs.ui.conversion.ktor.modules.upload.uploadModule
import com.groupdocs.ui.conversion.ktor.status.generalStatusPages
import com.groupdocs.ui.conversion.ktor.status.internalStatusPages
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import org.slf4j.event.Level

fun Application.module() {
    install(CallLogging) {
        level = Level.DEBUG
        filter { call -> call.request.path().startsWith("/conversion") }
    }
    install(ContentNegotiation) {
        gson {
            serializeNulls()
        }
    }
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }
    install(StatusPages) {
        generalStatusPages()
        internalStatusPages()
    }
    install(IgnoreTrailingSlash)

    install(Routing) {
        static("/static") {
            resources("static")
        }
        rootModule()
        route("/conversion") {
            homeModule()
            configModule()
            treeModule()
            convertModule()
            downloadModule()
            uploadModule()
        }
    }
}