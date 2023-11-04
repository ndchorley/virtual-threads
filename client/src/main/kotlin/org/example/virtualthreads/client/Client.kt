package org.example.virtualthreads.client

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Client {
    fun sendMessageToServerAndDisplayResponse() {
        val socket = Socket("127.0.0.1", 8080)

        val writer = PrintWriter(socket.getOutputStream(), true)
        val reader = BufferedReader(InputStreamReader(socket.getInputStream()))

        writer.println("Hello")

        println("Received: ${reader.readLine()}")
    }
}
