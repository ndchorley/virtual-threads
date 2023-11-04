package org.example.virtualthreads.sockets

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

fun Socket.sendMessage(message: String) {
    val writer = PrintWriter(getOutputStream(), true)

    writer.println(message)
}

fun Socket.readMessage(): String? {
    val reader = BufferedReader(InputStreamReader(getInputStream()))

    return reader.readLine()
}