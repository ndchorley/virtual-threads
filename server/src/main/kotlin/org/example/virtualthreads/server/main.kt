package org.example.virtualthreads.server

import io.micrometer.core.instrument.Timer
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

    val numberOfTasksGauge =
        metricsRegistry.gauge("tasks", AtomicInteger(0))!!
    val taskTimer =
        Timer
            .builder("tasks.timer")
            .publishPercentileHistogram()
            .register(metricsRegistry)

    val clientHandlingTaskFactory = ClientHandlingTaskFactory(numberOfTasksGauge, taskTimer)

    val server =
        PlatformThreadServer(
            clientHandlingTaskFactory = clientHandlingTaskFactory,
            port = 8080
        )

    server.start()
}
