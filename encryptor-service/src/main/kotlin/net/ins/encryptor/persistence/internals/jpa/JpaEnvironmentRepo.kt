package net.ins.encryptor.persistence.internals.jpa

import net.ins.encryptor.conf.meta.RdbmsProfile
import org.springframework.data.jpa.repository.JpaRepository

@RdbmsProfile
interface JpaEnvironmentRepo : JpaRepository<EnvironmentEntity, String>