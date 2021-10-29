package net.ins.encryptor.service.impl

import net.ins.encryptor.domain.EnvironmentEntity
import net.ins.encryptor.persistence.EnvironmentRepo
import net.ins.encryptor.service.EnvironmentService
import org.springframework.stereotype.Service

@Service
class EnvironmentServiceImpl(
    private val environmentRepo: EnvironmentRepo
) : EnvironmentService {

    override fun list(): Set<EnvironmentEntity> = environmentRepo.findAll().toSet()
}