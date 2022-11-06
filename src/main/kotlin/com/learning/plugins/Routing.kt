package com.learning.plugins

import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.event.Level

fun Application.configureRouting() {

    install(CallLogging) {
        level = Level.INFO
    }
    install(ContentNegotiation) {
        gson {
        }
    }

    // This installs the routing plugin with
    // install(Routing)
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/person") {
            val person = Person("ABC", 20)
            call.respond(person)
        }
    }
}

data class Person(
    val name: String,
    val age: Int
)