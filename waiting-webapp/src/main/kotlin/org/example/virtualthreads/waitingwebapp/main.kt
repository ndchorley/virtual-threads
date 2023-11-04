package org.example.virtualthreads.waitingwebapp

import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer

fun main() {
    val routes =
        routes(
            "/wait/{durationInMillis}" bind Method.GET to ::waitBeforeResponding
        )

    routes.asServer(Jetty(port = 8082)).start()
}

private fun waitBeforeResponding(request: Request): Response {
    val durationInMillis = request.path("durationInMillis")!!.toLong()
    Thread.sleep(durationInMillis)

    return Response(Status.OK)
}
