package net.ins.encryptor.persistence.internals.mongo

import net.ins.encryptor.conf.meta.MongoProfile
import net.ins.encryptor.domain.dto.Environment
import net.ins.encryptor.persistence.EnvironmentStore
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
@MongoProfile
class MongoEnvironmentStore(
    private val mongoTemplate: MongoOperations
) : EnvironmentStore {
    override fun list(): List<Environment> = mongoTemplate.findAll<EnvironmentEntity>(EnvironmentEntity::class.java).map { it.toDTO() }

    override fun getById(id: String): Environment? = mongoTemplate.findById(id, EnvironmentEntity::class.java)?.toDTO()

    override fun create(environment: Environment): Environment = mongoTemplate.insert(environment.toEntity()).toDTO()
}