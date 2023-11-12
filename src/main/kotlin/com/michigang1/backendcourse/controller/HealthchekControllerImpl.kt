package com.michigang1.backendcourse.controller

import com.michigang1.backendcourse.models.DateResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HealthchekControllerImpl : HealthcheckController {
    @GetMapping("/healthcheck")
    override fun getHealthcheck() = ResponseEntity(DateResponse(status = HttpStatus.OK.value()), HttpStatus.OK)
}
