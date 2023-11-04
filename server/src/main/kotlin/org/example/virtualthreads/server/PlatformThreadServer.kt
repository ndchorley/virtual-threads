package org.example.virtualthreads.server

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

class PlatformThreadServer(val port: Int) {
    private val socket = ServerSocket(port)
    fun start() {
        println("Listening on port: $port")

        val clientSocket = socket.accept()

        val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))

        println("Received: ${reader.readLine()}")

        val writer = PrintWriter(clientSocket.getOutputStream(), true)

        writer.println("Bye!")

        clientSocket.close()
        socket.close()
    }
}
