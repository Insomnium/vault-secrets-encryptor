package net.ins.encryptor.persistence.internals.mongo

import net.ins.encryptor.persistence.AbstractEnvironmentStoreTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
abstract class AbstractMongoIntegrationTest : AbstractEnvironmentStoreTest() {

    companion object {

        @Container
        @JvmStatic
        val mongoContainer = MongoDBContainer("mongo:4.4.12")

        @DynamicPropertySource
        @JvmStatic
        fun postgresProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.data.mongodb.uri") { mongoContainer.replicaSetUrl }
        }
    }
}