package org.example.virtualthreads.server

import java.net.ServerSocket

class PlatformThreadServer(val port: Int) {
    private val socket = ServerSocket(port)

    fun start() {
        println("Listening on port: $port")
        println()

        while (true) {
            val clientSocket = socket.accept()
            println("Connected to client on port ${clientSocket.port}")

            val task = ClientHandlingTask(clientSocket)
            Thread.ofPlatform().start(task)
        }
    }
}
