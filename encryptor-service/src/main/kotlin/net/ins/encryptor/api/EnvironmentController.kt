package net.ins.encryptor.api

import net.ins.encryptor.domain.dto.Environment
import net.ins.encryptor.service.EnvironmentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/envs")
class EnvironmentController(
    private val environmentService: EnvironmentService
) {

    @GetMapping
    fun list(): Set<Environment> = environmentService.list()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: String): Environment = environmentService.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@RequestBody environment: Environment): Environment {
        return environmentService.create(environment)
    }
}