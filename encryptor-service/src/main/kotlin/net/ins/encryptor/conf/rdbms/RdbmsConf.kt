package net.ins.encryptor.conf.rdbms

import net.ins.encryptor.conf.meta.RdbmsProfile
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.context.annotation.Configuration

@Configuration
@RdbmsProfile
@EnableAutoConfiguration(
    exclude = [
        MongoAutoConfiguration::class,
        MongoDataAutoConfiguration::class
    ]
)
class RdbmsConf