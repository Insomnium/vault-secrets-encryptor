package net.ins.encryptor.domain

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "variable")
data class VariableEntity(
    @EmbeddedId
    val id: VariableId,
    val value: String,
    val note: String?,
) {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "env", insertable = false, updatable = false)
    lateinit var env: EnvironmentEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VariableEntity

        if (id != other.id) return false
        if (value != other.value) return false
        if (note != other.note) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + value.hashCode()
        result = 31 * result + (note?.hashCode() ?: 0)
        return result
    }


}

@Embeddable
data class VariableId(
    val key: String,
    val env: String
) : Serializable