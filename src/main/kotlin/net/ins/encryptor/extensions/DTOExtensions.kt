package net.ins.encryptor.extensions

import net.ins.encryptor.domain.EnvironmentEntity
import net.ins.encryptor.domain.VariableEntity
import net.ins.encryptor.domain.dto.Environment
import net.ins.encryptor.domain.dto.Variable

fun EnvironmentEntity.toDTO(): Environment = Environment(
    id = this@toDTO.id,
    name = this@toDTO.name,
    description = this@toDTO.description,
    variables = this@toDTO.variables.map { it.toDTO() }.toSet()
)

fun VariableEntity.toDTO(): Variable = Variable(
    key = this@toDTO.id.key,
    env = this@toDTO.id.env,
    value = this@toDTO.value,
    note = this@toDTO.note
)