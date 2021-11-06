plugins {
    kotlin("jvm")
    id("io.spring.dependency-management")
    id("org.springframework.boot")
    id("org.openapi.generator") version "5.3.0"
    kotlin("plugin.spring")
    kotlin("plugin.jpa") version "1.5.31"
}

group = "net.ins.encryptor"
version = "0.0.1-SNAPSHOT"

springBoot {
    mainClass.set("net.ins.encryptor.VaultSecretEncryptorApplication")
}

repositories {
    mavenCentral()
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.liquibase:liquibase-core")
    implementation("javax.validation:validation-api:2.0.1.Final")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation(project(":encryptor-api"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}