package com.groupdocs.ui.conversion.ktor.modules.home

import io.ktor.server.html.*
import kotlinx.html.*

class HomeTemplate : Template<HTML> {
    val pageTitle = Placeholder<TITLE>()
    override fun HTML.apply() {
        lang = "en"

        head {

            meta {
                charset = "utf-8"
            }
            title {
                insert(pageTitle)
            }
            base {
                href = "/"
            }
            meta {
                name = "viewport"
                content = "width=device-width, initial-scale=1"
            }
            link(rel = "icon", type = "image/x-icon", href = "static/favicon.ico")
        }
        body {
            HTMLTag(
                tagName = "client-root",
                consumer = consumer,
                inlineTag = false,
                emptyTag = false,
                initialAttributes = emptyMap()
            ).visit { }

            script { src = "/static/runtime.js" }
            script { src = "/static/polyfills.js" }
            script { src = "/static/styles.js" }
            script { src = "/static/vendor.js" }
            script { src = "/static/main.js" }
        }
    }
}