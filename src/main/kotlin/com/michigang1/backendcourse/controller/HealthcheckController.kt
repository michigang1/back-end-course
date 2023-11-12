package com.michigang1.backendcourse.controller

import com.michigang1.backendcourse.models.DateResponse
import org.springframework.http.ResponseEntity

fun interface HealthcheckController {
    fun getHealthcheck(): ResponseEntity<DateResponse>
}