package net.ins.encryptor.domain.dto

data class Environment(
    val id: String,
    val name: String,
    val description: String?,
    val variables: Set<Variable> = emptySet()
)