package net.ins.encryptor.domain.dto

data class Variable(
    val key: String,
    val env: String,
    val value: String,
    val note: String?
)