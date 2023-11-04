plugins {
    kotlin("jvm") version "1.9.20"
    id("com.github.johnrengelman.shadow").version("8.1.1")
}

group = "org.example"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.20")
}

tasks.test {
    useJUnitPlatform()
}

val jdkVersion = "21"

kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(jdkVersion)
    }
}

subprojects {
    apply {
        plugin("kotlin")
        plugin("com.github.johnrengelman.shadow")
    }

    tasks.compileJava {
        sourceCompatibility = jdkVersion
        targetCompatibility = jdkVersion
    }

    tasks.compileKotlin {
        kotlinOptions.jvmTarget = jdkVersion
    }
}
