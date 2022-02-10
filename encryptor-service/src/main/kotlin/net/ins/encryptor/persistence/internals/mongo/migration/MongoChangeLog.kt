package net.ins.encryptor.persistence.internals.mongo.migration

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate
import net.ins.encryptor.conf.meta.MongoProfile
import net.ins.encryptor.persistence.internals.mongo.EnvironmentEntity
import net.ins.encryptor.persistence.internals.mongo.VariableEntity
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@MongoProfile
@Profile("!test")
@ChangeLog
@Component
class MongoChangeLog {

    @ChangeSet(order = "1", id = "init-envs", author = "ins137@gmail.com")
    fun initEnvs(mongoTemplate: MongockTemplate) {
        mongoTemplate.insertAll(
            listOf(
                EnvironmentEntity(id = "DSO", name = "DSO", variables = setOf(
                    VariableEntity(key = "DB_URL", value = "postgresql://localhost:5432/postgres"),
                    VariableEntity(key = "POSTGRES_USER", value = "postgres"),
                    VariableEntity(key = "POSTGRES_PASSWORD", value = "postgres"),
                ))
            )
        )
    }
}