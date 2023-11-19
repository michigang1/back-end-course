package com.michigang1.backendcourse

import com.michigang1.backendcourse.models.Category
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BackEndCourseApplication {

    @Bean
    fun initializeCategories() = listOf(
        Category(1, "Fruits"),
        Category(2, "Vegetables"),
        Category(3, "Meat"),
    )
}

fun main(args: Array<String>) {
    runApplication<BackEndCourseApplication>(*args)
}
