package net.ins.encryptor.persistence.internals.jpa

import net.ins.encryptor.conf.meta.RdbmsProfile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

@RdbmsProfile
interface JpaEnvironmentRepo : JpaRepository<EnvironmentEntity, String> {

    @Query("select distinct env from EnvironmentEntity env left join fetch env.variables")
    fun fetchAll(): List<EnvironmentEntity>

    @Query("select distinct env from EnvironmentEntity env left join fetch env.variables where env.id = ?1")
    fun fetchById(id: String): EnvironmentEntity?
}