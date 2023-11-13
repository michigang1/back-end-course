package com.michigang1.backendcourse.models

import java.time.LocalDate
import java.util.*

data class DateResponse(
    val date: LocalDate = LocalDate.now(),
    val status: Int
)
