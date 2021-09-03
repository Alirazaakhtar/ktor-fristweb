package com.example

import io.ktor.application.*
import com.example.plugins.*
import freemarker.cache.ClassTemplateLoader
import freemarker.core.HTMLOutputFormat
import io.ktor.freemarker.*
import routes.registerCustomerRoutes

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {



    registerCustomerRoutes()
    configureTemplating()
    configureSerialization()
}
