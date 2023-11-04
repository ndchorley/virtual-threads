package org.example.virtualthreads.server

import org.example.virtualthreads.sockets.readMessage
import org.example.virtualthreads.sockets.sendMessage
import java.net.Socket

class ClientHandlingTask(private val clientSocket: Socket) : Runnable {
    override fun run() {
        val message = clientSocket.readMessage()
        println("Received: $message")

        clientSocket.sendMessage("Bye!")

        clientSocket.close()
    }
}
