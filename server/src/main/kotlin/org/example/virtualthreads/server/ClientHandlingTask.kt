package org.example.virtualthreads.server

import org.example.virtualthreads.sockets.readMessage
import org.example.virtualthreads.sockets.sendMessage
import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import java.net.Socket
import kotlin.random.Random
import kotlin.random.nextLong

class ClientHandlingTask(private val clientSocket: Socket) : Runnable {
    private val httpClient = ApacheClient()

    override fun run() {
        val message = clientSocket.readMessage()
        println("Received: $message")

        val durationInMillis = Random.Default.nextLong(LongRange(0, 10000))
        sendRequestToWebAppWaitingFor(durationInMillis)

        clientSocket.sendMessage("Bye!")

        clientSocket.close()
    }

    private fun sendRequestToWebAppWaitingFor(durationInMillis: Long) =
        httpClient(Request(Method.GET, "http://localhost:8082/wait/$durationInMillis"))

}

