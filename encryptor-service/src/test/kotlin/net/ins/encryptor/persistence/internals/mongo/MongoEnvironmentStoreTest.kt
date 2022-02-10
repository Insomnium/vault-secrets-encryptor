package net.ins.encryptor.persistence.internals.mongo

import net.ins.encryptor.conf.meta.MONGO
import net.ins.encryptor.persistence.EnvironmentStore
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles(MONGO, "test")
internal class MongoEnvironmentStoreTest : AbstractMongoIntegrationTest() {

    override val store: EnvironmentStore
        get() = envStore

    override val storeClass: Class<*>
        get() = MongoEnvironmentStore::class.java

    @Autowired
    private lateinit var envStore: EnvironmentStore

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    @Test
    fun `Should list environments`() {
        // given: few envs with variables
        val originEntities = listOf(
            EnvironmentEntity(
                "0", "envName0", "env #0 description", setOf(
                    VariableEntity("0", "0", "variable#0 note")
                )
            ),
            EnvironmentEntity(
                "1", "envName1", "env #1 description", setOf(
                    VariableEntity("1", "variable#1", "variable#1 note"),
                    VariableEntity("2", "variable#2", "variable#2 note"),
                )
            )
        )
        mongoTemplate.insertAll(originEntities)
        // when: env list requested via service
        val envs = store.list()
        // then: envs fetched correctly
        assertThat(originEntities.map { it.toDTO() }, containsInAnyOrder(*envs.toTypedArray()))
    }
}