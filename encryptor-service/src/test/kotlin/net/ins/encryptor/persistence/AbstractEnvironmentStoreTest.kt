package net.ins.encryptor.persistence

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
abstract class AbstractEnvironmentStoreTest {

    protected abstract val store: EnvironmentStore

    protected abstract val storeClass: Class<*>

    @Test
    fun `store should be of proper type`() {
        assertTrue(storeClass.isInstance(store), "Store has to be of ${storeClass.simpleName}")
    }
}