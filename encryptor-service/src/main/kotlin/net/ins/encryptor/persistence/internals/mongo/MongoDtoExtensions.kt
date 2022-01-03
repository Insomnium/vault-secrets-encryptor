package net.ins.encryptor.persistence.internals.mongo

import net.ins.encryptor.domain.dto.Environment
import net.ins.encryptor.domain.dto.Variable

fun EnvironmentEntity.toDTO(): Environment = Environment(
    id = this.id,
    name = this.name,
    description = this.description,
    variables = this.variables.map { it.toDTO(this.id) }.toSet()
)

fun VariableEntity.toDTO(env: String): Variable = Variable(
    key = this.key,
    env = env,
    value = this.value,
    note = this.note
)

fun Environment.toEntity(): EnvironmentEntity = EnvironmentEntity(
    id = this.id,
    name = this.name,
    description = this.description,
    variables = this.variables.map { it.toEntity() }.toSet()
)

fun Variable.toEntity(): VariableEntity = VariableEntity(
    key = this.key,
    value = this.value,
    note = this.note
)