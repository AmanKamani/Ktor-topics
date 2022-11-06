package com.learning

import com.learning.plugins.bookRouting
import com.learning.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main(args: Array<String>) {
    EngineMain.main(args)
}

@Suppress("unused")
fun Application.module() {
    // This module is specified in "application.conf"
    configureRouting()
}

@Suppress("unused")
fun Application.moduleBook() {
    // This module is specified in "application.conf"
    bookRouting()
}
