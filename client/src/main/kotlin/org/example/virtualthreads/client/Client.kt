package org.example.virtualthreads.client

import java.io.PrintWriter
import java.net.Socket

class Client {
    fun sendMessageToServerAndDisplayResponse() {
        val socket = Socket("127.0.0.1", 8080)

        val writer = PrintWriter(socket.getOutputStream(), true)

        writer.println("Hello")
    }
}
