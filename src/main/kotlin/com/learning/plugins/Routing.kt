package com.learning.plugins

import com.fasterxml.jackson.databind.SerializationFeature
import com.learning.data.users
import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {

        static("assets") {
//            resource("static/root.html") // add single file in resource
            resources("static")
        }

        // get(""){}: can also be written as
        route(path = "/", method = HttpMethod.Get) {
            handle {
                call.respondRedirect("/assets/root.html", permanent = true)
            }
        }

        get("/users") {
            if (call.request.queryParameters.isEmpty())
                call.respond(users)
            else {
                val isAdmin = call.request.queryParameters["isAdmin"]?.toBoolean()
                val filteredUsers = users.filter { it.isAdmin == isAdmin }
                call.respond(filteredUsers)
            }
        }
        get("/users/{userId}") {
            try {
                val userId = call.parameters["userId"]?.toInt()
                val user = users.firstOrNull { it.id == userId }
                if (user != null) {
                    if (user.isAdmin)
                        call.response.headers.append("token", "All Access")
                    call.respond(user)
                } else {
                    throw Exception("User Not Found")
                }
            } catch (error: Exception) {
                call.respondText(error.message!!, status = HttpStatusCode.BadRequest)
            }
        }

        get("/admins") {
            call.respondRedirect("/users?isAdmin=true", permanent = true)
        }
    }
}
