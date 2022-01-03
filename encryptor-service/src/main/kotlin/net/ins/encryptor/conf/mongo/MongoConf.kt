package net.ins.encryptor.conf.mongo

import com.github.cloudyrock.spring.v5.EnableMongock
import com.mongodb.client.MongoClient
import net.ins.encryptor.conf.meta.MongoProfile
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
@MongoProfile
@EnableAutoConfiguration(
    exclude = [
        DataSourceAutoConfiguration::class,
        DataSourceTransactionManagerAutoConfiguration::class,
        HibernateJpaAutoConfiguration::class
    ]
)
@EnableMongock
class MongoConf {

    @Bean
    fun mongoTemplate(
        mongoClient: MongoClient,
        writeConcernResolver: MongoWriteConcernResolver
    ): MongoTemplate = MongoTemplate(mongoClient, "environments")
        .apply {
            setWriteConcernResolver(writeConcernResolver)
        }
}