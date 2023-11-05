package org.example.virtualthreads.connectioncreator

fun main(args: Array<String>) {
    val numberOfConnections = args.first().toInt()

    (1 .. numberOfConnections).forEach {
        Thread.ofPlatform().start(::connectionCreatingTask)
    }
}

private fun connectionCreatingTask() =
    Client().sendMessageToServerAndDisplayResponse()
