package net.ins.encryptor.persistence.internals.jpa

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

fun Environment.toEntity(): EnvironmentEntity = EnvironmentEntity(
    id = this@toEntity.id,
    name = this@toEntity.name,
    description = this@toEntity.description
).apply {
    variables = this@toEntity.variables.map { it.toEntity() }.toSet()
}

fun Variable.toEntity(): VariableEntity = VariableEntity(
    id = VariableId(
        key = this@toEntity.key,
        env = this@toEntity.env
    ),
    value = this@toEntity.value,
    note = this@toEntity.note
)