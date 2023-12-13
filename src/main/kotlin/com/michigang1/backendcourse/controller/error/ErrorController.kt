package com.michigang1.backendcourse.controller.error

import com.michigang1.backendcourse.exception.NoOneOfTwoParamsProvidedException
import com.michigang1.backendcourse.exception.ResourceByParamNotFound
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ErrorController: ResponseEntityExceptionHandler() {
    private fun prepareResponse(ex: RuntimeException, request: WebRequest, bodyOfResponse: String, status: HttpStatus): ResponseEntity<Any>? {
        logger.error("Request: ${request.contextPath} raised " + ex)
        return handleExceptionInternal(
            ex,
            bodyOfResponse,
            HttpHeaders(),
            status,
            request,
        )
    }

    @ExceptionHandler(value = [IllegalArgumentException::class, IllegalStateException::class])
    fun handleIllegalArgumentException(ex: RuntimeException, request: WebRequest): ResponseEntity<Any>? {
        return prepareResponse(ex, request, "This should be application specific", HttpStatus.CONFLICT)
    }

    @ExceptionHandler(value = [NoOneOfTwoParamsProvidedException::class])
    fun handleNoOneOfTwoParamsProvidedException(ex: RuntimeException, request: WebRequest): ResponseEntity<Any>? {
        return prepareResponse(ex, request, "You should provide valid one of two params: userId or categoryId", HttpStatus.METHOD_NOT_ALLOWED)
    }
    @ExceptionHandler(value = [ResourceByParamNotFound::class])
    fun handleResourceByParamNotFound(ex: RuntimeException, request: WebRequest): ResponseEntity<Any>? {
        return prepareResponse(ex, request, "Resource by param not found", HttpStatus.NOT_FOUND)
    }
}