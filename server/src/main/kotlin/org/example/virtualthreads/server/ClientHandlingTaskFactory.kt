package org.example.virtualthreads.server

import io.micrometer.core.instrument.Timer
import java.net.Socket
import java.util.concurrent.atomic.AtomicInteger

class ClientHandlingTaskFactory(
    private val numberOfTasksGauge: AtomicInteger,
    private val taskTimer: Timer
) {
    fun create(socket: Socket): Runnable {
        val task = ClientHandlingTask(socket)

        return MetricsRecordingTask(
            delegate = task,
            numberOfTasksGauge = numberOfTasksGauge,
            taskTimer = taskTimer
        )
    }
}
