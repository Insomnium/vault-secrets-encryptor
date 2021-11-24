package net.ins.encryptor.api.handlers

import net.ins.encryptor.exceptions.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver

@ControllerAdvice
class ApiExceptionHandler : DefaultHandlerExceptionResolver() {

    @ExceptionHandler(EntityNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(ex: EntityNotFoundException) { }
}