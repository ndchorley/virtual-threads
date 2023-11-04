plugins {
    id("application")
}
dependencies {
    implementation(project(mapOf("path" to ":shared")))
}

application {
    mainClass = "org.example.virtualthreads.client.MainKt"
}
