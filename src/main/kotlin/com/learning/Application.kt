package com.learning

import com.learning.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main(args: Array<String>) {
    EngineMain.main(args)

//    embeddedServer(Netty, port = 8081, host = "0.0.0.0", module = Application::module)
//        .start(wait = true)
}

@Suppress("unused") // This will indicate that module is used in the project.
fun Application.module() {
    // This module is specified in "application.conf"
    configureRouting()
}
