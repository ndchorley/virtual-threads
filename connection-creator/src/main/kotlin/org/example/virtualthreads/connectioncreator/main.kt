package org.example.virtualthreads.connectioncreator

fun main() {
    (1 .. 10).forEach {
        Client().sendMessageToServerAndDisplayResponse()
    }
}
