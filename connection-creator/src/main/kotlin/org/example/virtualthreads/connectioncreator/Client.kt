package org.example.virtualthreads.connectioncreator

import org.example.virtualthreads.sockets.readMessage
import org.example.virtualthreads.sockets.sendMessage
import java.net.Socket

class Client {
    fun sendMessageToServerAndDisplayResponse() {
        val socket = Socket("127.0.0.1", 8080)

        socket.sendMessage("Hello")

        val response = socket.readMessage()
        println("Received: $response")
    }
}
