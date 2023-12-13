package com.michigang1.backendcourse.models

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class Record(
    val id: Int = 0,
    val userId: Int = 0,
    val categoryId: Int = 0,
    val dateTimeAtCreation: String? =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
    val generalExpenses: Double = 0.0,
)
