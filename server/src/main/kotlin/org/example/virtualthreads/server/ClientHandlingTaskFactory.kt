package org.example.virtualthreads.server

import java.net.Socket
import java.util.concurrent.atomic.AtomicInteger

class ClientHandlingTaskFactory(private val numberOfTasksGauge: AtomicInteger) {
    fun create(socket: Socket): ClientHandlingTask =
        ClientHandlingTask(socket, numberOfTasksGauge)
}
