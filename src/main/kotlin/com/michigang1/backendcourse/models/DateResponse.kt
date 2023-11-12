package com.michigang1.backendcourse.models

import java.time.LocalDateTime
import java.util.*

data class DateResponse(
    val date: LocalDateTime = LocalDateTime.now(),
    val status: Int
)
