package org.example.virtualthreads.server

import java.util.concurrent.atomic.AtomicInteger

class MetricsRecordingTask(
    private val delegate: Runnable,
    private val numberOfTasksGauge: AtomicInteger
) : Runnable {

    override fun run() {
        numberOfTasksGauge.incrementThenDecrementWhenFinished {
            delegate.run()
        }
    }
}

private fun AtomicInteger.incrementThenDecrementWhenFinished(block: () -> Unit) {
    incrementAndGet()

    block()

    decrementAndGet()
}
