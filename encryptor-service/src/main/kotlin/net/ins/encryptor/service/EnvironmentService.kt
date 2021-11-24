package net.ins.encryptor.service

import net.ins.encryptor.domain.EnvironmentEntity

interface EnvironmentService {

    fun list(): Set<EnvironmentEntity>

    fun getById(env: String): EnvironmentEntity
}