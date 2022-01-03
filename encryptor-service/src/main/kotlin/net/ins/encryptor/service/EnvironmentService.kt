package net.ins.encryptor.service

import net.ins.encryptor.domain.dto.Environment

interface EnvironmentService {

    fun list(): Set<Environment>

    fun getById(env: String): Environment
}