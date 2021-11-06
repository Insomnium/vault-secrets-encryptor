plugins {
    kotlin("jvm")
    id("io.spring.dependency-management")
    id("org.openapi.generator") version "5.3.0"
}

dependencies {
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.springframework.boot:spring-boot-starter-web")
}

dependencyManagement {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

val openApiGeneratedSourcesDir = "$buildDir/generated/openapi"

openApiGenerate {
    inputSpec.set("$projectDir/src/main/resources/openapi/vault-secret-encryptor-api.yaml")
    outputDir.set(openApiGeneratedSourcesDir)
    apiPackage.set("net.ins.encryptor.api")
    modelPackage.set("net.ins.encryptor.domain")
    modelNameSuffix.set("DTO")
    generatorName.set("kotlin-spring")
    groupId.set("net.ins.encryptor")
    id.set("encryptor-api")
    configOptions.putAll(
        mapOf(
            "interfaceOnly" to "true"
        )
    )
}

tasks.named("compileKotlin") {
    dependsOn("openApiGenerate")
}

kotlin {
    sourceSets {
        main {
            kotlin.srcDir("$openApiGeneratedSourcesDir/src/main/kotlin")
        }
    }
}