package net.ins.encryptor.service.impl

import net.ins.encryptor.domain.EnvironmentEntity
import net.ins.encryptor.exceptions.EntityNotFoundException
import net.ins.encryptor.persistence.EnvironmentRepo
import net.ins.encryptor.service.EnvironmentService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class EnvironmentServiceImpl(
    private val environmentRepo: EnvironmentRepo
) : EnvironmentService {

    override fun list(): Set<EnvironmentEntity> = environmentRepo.findAll().toSet()

    override fun getById(env: String): EnvironmentEntity = environmentRepo.findByIdOrNull(env)
        ?: throw EntityNotFoundException("Environment $env not found")
}