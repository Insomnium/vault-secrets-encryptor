package net.ins.encryptor.conf.mongo

import com.mongodb.WriteConcern
import net.ins.encryptor.conf.meta.MongoProfile
import net.ins.encryptor.persistence.internals.mongo.EnvironmentEntity
import org.springframework.data.mongodb.core.MongoAction
import org.springframework.data.mongodb.core.WriteConcernResolver
import org.springframework.stereotype.Component

@Component
@MongoProfile
class MongoWriteConcernResolver : WriteConcernResolver {

    private val defaultWriteConcern: WriteConcern = WriteConcern.JOURNALED.withW(1)

    override fun resolve(action: MongoAction): WriteConcern = with(action) {
        when {
            this.entityType == null -> this@MongoWriteConcernResolver.defaultWriteConcern
            this.entityType!!.name == EnvironmentEntity::class.java.name -> WriteConcern.JOURNALED.withW(1) // TODO: set higher value for clustered test
            else -> action.defaultWriteConcern ?: this@MongoWriteConcernResolver.defaultWriteConcern
        }
    }
}