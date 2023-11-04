package org.example.virtualthreads.server

fun main() {
    MetricsServer(port = 8081).start()

    val clientHandlingTaskFactory = ClientHandlingTaskFactory()
    val server =
        PlatformThreadServer(
            clientHandlingTaskFactory = clientHandlingTaskFactory,
            port = 8080
        )

    server.start()
}
