package com.learning.plugins

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Application.configureRouting() {
    routing {
        get("/") {
            val name = call.request.queryParameters["name"]
            val image = call.request.queryParameters["image"]
            call.respondHtml {
                head {
                    title { +"Templating" }
                }
                body {
                    val message = "See the Custom Title"
                    p {
                        if (name?.isNotBlank() == true) {
                            +"Welcome "
                            strong { +name }
                            br { }
                        }
                        +message
                        br {}
                        +"Current Directory: ${System.getProperty("user.dir")}"
                    }
                    if (image != null) {
                        p {
                            +"Your image: $image"
                            img(src = image)
                        }
                    }

                    br { }
                    p {
                        +"Add query params like: "
                        strong { +"name" }
                        strong { +", image" }
                        +" For personalized message"
                    }
                }
            }
        }
    }
}
