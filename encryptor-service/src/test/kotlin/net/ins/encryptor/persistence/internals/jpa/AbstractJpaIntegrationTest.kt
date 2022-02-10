package net.ins.encryptor.persistence.internals.jpa

import net.ins.encryptor.persistence.AbstractEnvironmentStoreTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
abstract class AbstractJpaIntegrationTest : AbstractEnvironmentStoreTest() {

    companion object {

        @Container
        @JvmStatic
        val postgresqlContainer = PostgreSQLContainer<Nothing>("postgres:12").apply {
            withDatabaseName("testy")
            withUsername("user")
            withPassword("password")
        }

        @DynamicPropertySource
        @JvmStatic
        fun postgresProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url") { "jdbc:postgresql://localhost:${postgresqlContainer.firstMappedPort}/${postgresqlContainer.databaseName}" }
            registry.add("spring.datasource.username") { postgresqlContainer.username }
            registry.add("spring.datasource.password") { postgresqlContainer.password }
        }
    }
}