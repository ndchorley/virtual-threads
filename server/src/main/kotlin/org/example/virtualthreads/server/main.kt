package org.example.virtualthreads.server

fun main() {
    MetricsServer(port = 8081).start()

    PlatformThreadServer(port = 8080).start()
}
