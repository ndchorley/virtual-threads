package org.example.virtualthreads.server

import io.micrometer.core.instrument.Timer
import java.util.concurrent.atomic.AtomicInteger

class MetricsRecordingTask(
    private val delegate: Runnable,
    private val numberOfTasksGauge: AtomicInteger,
    val taskTimer: Timer
) : Runnable {

    override fun run() {
        val timedTask = taskTimer.wrap(delegate)

        numberOfTasksGauge.incrementThenDecrementWhenFinished {
            timedTask.run()
        }
    }
}

private fun AtomicInteger.incrementThenDecrementWhenFinished(block: () -> Unit) {
    incrementAndGet()

    block()

    decrementAndGet()
}
