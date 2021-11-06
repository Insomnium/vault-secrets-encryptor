rootProject.name = "vault-secret-encryptor"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

include("encryptor-api")
include("encryptor-service")
