package net.ins.encryptor.conf.meta

import org.springframework.context.annotation.Profile

const val RDBMS = "rdbms"
const val MONGO = "mongo"

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Profile(RDBMS)
annotation class RdbmsProfile

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Profile(MONGO)
annotation class MongoProfile