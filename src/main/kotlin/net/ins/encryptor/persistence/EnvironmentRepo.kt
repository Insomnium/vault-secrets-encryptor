package net.ins.encryptor.persistence

import net.ins.encryptor.domain.EnvironmentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EnvironmentRepo : JpaRepository<EnvironmentEntity, String>