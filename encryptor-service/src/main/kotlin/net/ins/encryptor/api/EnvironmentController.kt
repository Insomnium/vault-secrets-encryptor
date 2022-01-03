package net.ins.encryptor.api

import net.ins.encryptor.domain.dto.Environment
import net.ins.encryptor.service.EnvironmentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/envs")
class EnvironmentController(
    private val environmentService: EnvironmentService
) {

    @GetMapping
    fun list(): Set<Environment> = environmentService.list()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: String): Environment = environmentService.getById(id)
}