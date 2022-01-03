package net.ins.encryptor.persistence

import net.ins.encryptor.domain.dto.Environment

interface EnvironmentStore {
    fun list(): List<Environment>
    fun getById(id: String): Environment?
}