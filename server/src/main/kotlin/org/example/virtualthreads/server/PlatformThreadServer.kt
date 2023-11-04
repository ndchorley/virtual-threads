package org.example.virtualthreads.server

import org.example.virtualthreads.sockets.readMessage
import org.example.virtualthreads.sockets.sendMessage
import java.net.ServerSocket

class PlatformThreadServer(val port: Int) {
    private val socket = ServerSocket(port)

    fun start() {
        println("Listening on port: $port")

        val clientSocket = socket.accept()

        val message = clientSocket.readMessage()
        println("Received: $message")

        clientSocket.sendMessage("Bye!")

        clientSocket.close()
        socket.close()
    }
}
