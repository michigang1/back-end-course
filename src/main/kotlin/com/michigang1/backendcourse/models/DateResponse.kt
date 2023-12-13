package com.michigang1.backendcourse.models

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

data class DateResponse(
    val date: String = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE),
    val status: Int
)
