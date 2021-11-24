package net.ins.encryptor.api

import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpHeaders
import org.yaml.snakeyaml.Yaml

@RestController
class SecretApiController : EncryptApi {

    override fun encryptSecret(serviceName: String, fileName: Resource): ResponseEntity<Resource> {
        return with(ClassPathResource("templates/index.html")) {
            ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=${fileName.filename}")
                .header(HttpHeaders.CONTENT_LENGTH, contentLength().toString())
                .body(this as Resource)
        }
    }
}