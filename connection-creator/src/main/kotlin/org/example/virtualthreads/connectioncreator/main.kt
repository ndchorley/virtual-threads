package org.example.virtualthreads.connectioncreator

fun main() {
    (1 .. 10).forEach {
        Thread.ofPlatform().start(::connectionCreatingTask)
    }
}

private fun connectionCreatingTask() =
    Client().sendMessageToServerAndDisplayResponse()
