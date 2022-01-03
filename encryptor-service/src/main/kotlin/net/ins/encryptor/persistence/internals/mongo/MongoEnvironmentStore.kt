package net.ins.encryptor.persistence.internals.mongo

import net.ins.encryptor.conf.meta.MongoProfile
import net.ins.encryptor.domain.dto.Environment
import net.ins.encryptor.persistence.EnvironmentStore
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
@MongoProfile
class MongoEnvironmentStore(
    private val mongoEnvironmentRepo: MongoEnvironmentRepo
) : EnvironmentStore {
    override fun list(): List<Environment> = mongoEnvironmentRepo.findAll().map { it.toDTO() }

    override fun getById(id: String): Environment? = mongoEnvironmentRepo.findByIdOrNull(id)?.toDTO()
}