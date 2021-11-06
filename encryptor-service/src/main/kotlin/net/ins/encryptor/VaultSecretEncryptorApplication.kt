package net.ins.encryptor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VaultSecretEncryptorApplication

fun main(args: Array<String>) {
    runApplication<VaultSecretEncryptorApplication>(*args)
}
