package org.example.virtualthreads.server

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.ServerSocket

class PlatformThreadServer(val port: Int) {
    private val socket = ServerSocket(port)
    fun start() {
        println("Listening on port: $port")

        val clientSocket = socket.accept()

       val reader = InputStreamReader(clientSocket.getInputStream())

        println("Received: ${reader.readText()}")

        val writer = OutputStreamWriter(clientSocket.getOutputStream())

        writer.write("Bye!")

        clientSocket.close()
        socket.close()
    }
}