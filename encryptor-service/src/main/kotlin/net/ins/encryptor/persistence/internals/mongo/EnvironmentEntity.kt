package net.ins.encryptor.persistence.internals.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("environments")
data class EnvironmentEntity(
    @Id
    val id: String,
    val name: String,
    val description: String? = null,
    val variables: Set<VariableEntity> = setOf()
)

data class VariableEntity(
    val key: String,
    val value: String,
    val note: String? = null
)

