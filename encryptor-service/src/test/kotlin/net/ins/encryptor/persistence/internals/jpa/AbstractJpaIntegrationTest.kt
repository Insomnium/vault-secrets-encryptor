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

        const val POSTGRES_IMAGE: String = "postgres:12"
        const val POSTGRES_DATABASE: String = "testy"
        const val POSTGRES_USER: String = "user"
        const val POSTGRES_PASSWORD: String = "password"

        @Container
        @JvmStatic
        val postgresqlContainer = PostgreSQLContainer<Nothing>(POSTGRES_IMAGE).apply {
            withDatabaseName(POSTGRES_DATABASE)
            withUsername(POSTGRES_USER)
            withPassword(POSTGRES_PASSWORD)
        }

        @DynamicPropertySource
        @JvmStatic
        fun postgresProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url") { "jdbc:postgresql://localhost:${postgresqlContainer.firstMappedPort}/$POSTGRES_DATABASE" }
            registry.add("spring.datasource.username") { POSTGRES_USER }
            registry.add("spring.datasource.password") { POSTGRES_PASSWORD }
        }
    }
}