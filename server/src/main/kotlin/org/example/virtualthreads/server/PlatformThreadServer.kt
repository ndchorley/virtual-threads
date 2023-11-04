package org.example.virtualthreads.server

import java.net.ServerSocket

class PlatformThreadServer(val port: Int) {
    private val socket = ServerSocket(port)

    fun start() {
        println("Listening on port: $port")

        val task = ClientHandlingTask(socket.accept())
        Thread.ofPlatform().start(task)
    }
}
