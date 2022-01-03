package net.ins.encryptor.service.impl

import net.ins.encryptor.domain.dto.Environment
import net.ins.encryptor.exceptions.EntityNotFoundException
import net.ins.encryptor.persistence.EnvironmentStore
import net.ins.encryptor.service.EnvironmentService
import org.springframework.stereotype.Service

@Service
class EnvironmentServiceImpl(
    private val envStore: EnvironmentStore
) : EnvironmentService {

    override fun list(): Set<Environment> = envStore.list().toSet()

    override fun getById(env: String): Environment = envStore.getById(env)
        ?: throw EntityNotFoundException("Environment $env not found")

    override fun create(env: Environment): Environment = envStore.create(env)
}