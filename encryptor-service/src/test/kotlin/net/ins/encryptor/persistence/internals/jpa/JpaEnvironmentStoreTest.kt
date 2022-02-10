package net.ins.encryptor.persistence.internals.jpa

import net.ins.encryptor.conf.meta.RDBMS
import net.ins.encryptor.persistence.EnvironmentStore
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles(RDBMS, "test")
internal class JpaEnvironmentStoreTest : AbstractJpaIntegrationTest() {

    override val storeClass: Class<*>
        get() = JpaEnvironmentStore::class.java

    override val store: EnvironmentStore
        get() = envStore

    @AfterEach
    fun cleanup() {
        envRepo.deleteAll()
    }

    @Autowired
    private lateinit var envStore: EnvironmentStore

    @Autowired
    private lateinit var envRepo: JpaEnvironmentRepo

    @Test
    fun `Should list environments`() {
        // given: few envs with variables
        val originEntities = listOf(
            EnvironmentEntity("0", "envName0", "env #0 description").apply {
                variables = setOf(
                    VariableEntity(VariableId("0", "0"), "variable#0", "variable#0 note")
                )
            },
            EnvironmentEntity("1", "envName1", "env #1 description").apply {
                variables = setOf(
                    VariableEntity(VariableId("1", "1"), "variable#1", "variable#1 note"),
                    VariableEntity(VariableId("2", "1"), "variable#2", "variable#2 note"),
                )
            }
        )
        envRepo.saveAll(originEntities)
        // when: env list requested via service
        val envs = store.list()
        // then: envs fetched correctly
        assertThat(originEntities.map { it.toDTO() }, containsInAnyOrder(*envs.toTypedArray()))
    }
}