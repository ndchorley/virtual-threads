plugins {
    id("application")
}

tasks.jar {
    manifest.attributes("Main-Class" to  "org.example.virtualthreads.client.MainKt")
}