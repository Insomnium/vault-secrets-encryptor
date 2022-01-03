package net.ins.encryptor.persistence.internals.mongo

import net.ins.encryptor.conf.meta.MongoProfile
import org.springframework.data.mongodb.repository.MongoRepository

@MongoProfile
interface MongoEnvironmentRepo : MongoRepository<EnvironmentEntity, String>