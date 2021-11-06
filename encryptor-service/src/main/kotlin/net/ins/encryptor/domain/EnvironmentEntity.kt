package net.ins.encryptor.domain

import javax.persistence.*

@Entity
@Table(name = "environment")
data class EnvironmentEntity(
    @Id
    val id: String,
    val name: String,
    val description: String?
) {

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE],
        orphanRemoval = true,
        mappedBy = "env"
    )
    lateinit var variables: Set<VariableEntity>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EnvironmentEntity

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }


}