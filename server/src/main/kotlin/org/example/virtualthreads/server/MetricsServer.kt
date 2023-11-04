package org.example.virtualthreads.server

import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer

class MetricsServer(val port: Int) {
    private fun serveMetrics(request: Request): Response =
        Response(Status.OK).body("Hello")

    fun start() {
        routes("/metrics" bind Method.GET to ::serveMetrics)
            .asServer(Jetty(port = port))
            .start()
    }
}
