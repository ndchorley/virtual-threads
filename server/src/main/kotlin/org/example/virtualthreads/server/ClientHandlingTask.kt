package org.example.virtualthreads.server

import org.example.virtualthreads.sockets.readMessage
import org.example.virtualthreads.sockets.sendMessage
import java.net.Socket
import java.util.concurrent.atomic.AtomicInteger

class ClientHandlingTask(
    private val clientSocket: Socket,
    private val numberOfTasksGauge: AtomicInteger
) : Runnable {
    override fun run() {
        numberOfTasksGauge.incrementThenDecrementWhenFinished {
            val message = clientSocket.readMessage()
            println("Received: $message")

            clientSocket.sendMessage("Bye!")

            clientSocket.close()
        }
    }

}

private fun AtomicInteger.incrementThenDecrementWhenFinished(block: () -> Unit) {
    incrementAndGet()

    block()

    decrementAndGet()
}
