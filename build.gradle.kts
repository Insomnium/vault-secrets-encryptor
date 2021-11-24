import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31" apply false
    kotlin("plugin.spring") version "1.5.31"
    kotlin("plugin.jpa") version "1.5.31"
    id("org.springframework.boot") version "2.5.6" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

subprojects {
    repositories {
        mavenCentral()
    }
}

allprojects {
    group = "net.ins.encryptor"
    version = "0.0.1-SNAPSHOT"

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "16"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
