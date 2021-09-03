package routes

import Customer
import customerDB
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.getAllCustomerRoute(){
    route("/customer"){
        get {
            call.respond(FreeMarkerContent("index.ftl", mapOf("customers" to customerDB)))
        }
    }
}

fun Route.getCustomerById(){
    route("/customer/{id}"){
        get{
            val id = call.parameters["id"] ?: return@get call.respondText(
                "wrong id", status = HttpStatusCode.BadRequest
            )
            val customer = customerDB.find { it.id ==id }
            if(customer != null){
                call.respondTemplate("index2.ftl", mapOf("customer" to customer))
            }
        }
    }
}

fun Route.postCustomerRoute(){
    route("/create"){
        post {
            val params = call.receiveParameters()
            val customer = Customer(params["id"], params["name"])
            if (customer != null){
                customerDB.add(customer)
                call.respondRedirect("/customer")
            }
            else{
                call.respondText(
                    "Not createt",
                    status = HttpStatusCode.BadRequest
                )
            }
        }
    }
}



fun Application.registerCustomerRoutes(){
    routing {
        getAllCustomerRoute()
        postCustomerRoute()
        getCustomerById()
    }
}