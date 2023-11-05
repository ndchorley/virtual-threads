package org.example.virtualthreads.server

import java.net.Socket
import java.util.concurrent.atomic.AtomicInteger

class ClientHandlingTaskFactory(private val numberOfTasksGauge: AtomicInteger) {
    fun create(socket: Socket): Runnable {
        val task = ClientHandlingTask(socket)

        return MetricsRecordingTask(
            delegate = task,
            numberOfTasksGauge = numberOfTasksGauge
        )
    }
}
