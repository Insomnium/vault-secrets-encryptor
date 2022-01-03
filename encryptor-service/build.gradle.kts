plugins {
    kotlin("jvm")
    id("io.spring.dependency-management")
    id("org.springframework.boot")
    id("org.openapi.generator") version "5.3.0"
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
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
    // rdbms
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("com.h2database:h2:1.4.200")

    // mongo
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("com.github.cloudyrock.mongock:mongock-spring-v5:4.3.8")
    implementation("com.github.cloudyrock.mongock:mongodb-springdata-v3-driver:4.3.8")

    // the rest
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("javax.validation:validation-api:2.0.1.Final")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation(project(":encryptor-api"))
}