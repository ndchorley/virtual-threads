package org.example.virtualthreads.server

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class PlatformThreadServer(val port: Int) {
    private val socket = ServerSocket(port)
    fun start() {
        println("Listening on port: $port")

        val clientSocket = socket.accept()

        val message = clientSocket.readMessage()
        println("Received: $message")

        val writer = PrintWriter(clientSocket.getOutputStream(), true)

        writer.println("Bye!")

        clientSocket.close()
        socket.close()
    }

    private fun Socket.readMessage(): String? {
        val reader = BufferedReader(InputStreamReader(getInputStream()))

        return reader.readLine()
    }
}
