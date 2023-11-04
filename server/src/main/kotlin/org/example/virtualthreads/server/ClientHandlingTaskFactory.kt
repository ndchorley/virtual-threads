package org.example.virtualthreads.server

import java.net.Socket

class ClientHandlingTaskFactory {
    fun create(socket: Socket): ClientHandlingTask = ClientHandlingTask(socket)
}
