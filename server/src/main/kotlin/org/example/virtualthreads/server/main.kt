package org.example.virtualthreads.server

import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val metricsRegistry =
        PrometheusMeterRegistry(PrometheusConfig.DEFAULT)

    MetricsServer(
        metricsRegistry = metricsRegistry,
        port = 8081
    ).start()

    val numberOfTasksGauge = metricsRegistry.gauge("tasks", AtomicInteger(0))!!
    val clientHandlingTaskFactory = ClientHandlingTaskFactory(numberOfTasksGauge)

    val server =
        PlatformThreadServer(
            clientHandlingTaskFactory = clientHandlingTaskFactory,
            port = 8080
        )

    server.start()
}
