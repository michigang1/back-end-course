package com.michigang1.backendcourse.models

import jakarta.persistence.*



data class Category(
    var id: Int = 0,
    val name: String = "No name provided",
)
