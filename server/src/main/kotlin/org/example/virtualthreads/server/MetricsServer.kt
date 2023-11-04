package org.example.virtualthreads.server

import io.micrometer.prometheus.PrometheusMeterRegistry
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer

class MetricsServer(
    val port: Int,
    val metricsRegistry: PrometheusMeterRegistry
) {
    private fun serveMetrics(request: Request): Response =
        Response(Status.OK).body(metricsRegistry.scrape())

    fun start() {
        routes("/metrics" bind Method.GET to ::serveMetrics)
            .asServer(Jetty(port = port))
            .start()
    }
}
