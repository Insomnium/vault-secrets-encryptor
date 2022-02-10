package net.ins.encryptor.persistence.internals.jpa

import net.ins.encryptor.conf.meta.RdbmsProfile
import net.ins.encryptor.domain.dto.Environment
import net.ins.encryptor.persistence.EnvironmentStore
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
@RdbmsProfile
class JpaEnvironmentStore(
    private val jpaEnvironmentRepo: JpaEnvironmentRepo
) : EnvironmentStore {

    override fun list(): List<Environment> = jpaEnvironmentRepo.fetchAll().map { it.toDTO() }

    override fun getById(id: String): Environment? = jpaEnvironmentRepo.fetchById(id)?.toDTO()

    override fun create(environment: Environment): Environment =
        jpaEnvironmentRepo.save(environment.toEntity()).toDTO()
}