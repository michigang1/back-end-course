package com.michigang1.backendcourse

import com.michigang1.backendcourse.models.Category
import com.michigang1.backendcourse.models.Record
import com.michigang1.backendcourse.models.User
import com.michigang1.backendcourse.repository.category.CategoryRepository
import com.michigang1.backendcourse.repository.category.CategoryRepositoryImpl
import com.michigang1.backendcourse.repository.record.RecordRepository
import com.michigang1.backendcourse.repository.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
class BackEndCourseApplication {

    @Bean
    fun initializeCategories() = listOf(
        Category(1, "Food"),
        Category(2, "Transportation"),
        Category(3, "Entertainment"),
        Category(4, "Education"),
        Category(5, "Health"),
    )


    @Bean
    fun initializeRecords() = listOf(
        Record(1,1,1, generalExpenses = 100.0),
        Record(2,1,2, generalExpenses = 200.0),
        Record(3,1,3, generalExpenses = 300.0),
        Record(4,1,4, generalExpenses = 400.0),
        Record(5,1,5, generalExpenses = 500.0),
    )

    @Bean
    fun initializeUsers() = listOf(
        User(1, "admin"),
        User(2, "user"),
    )

}

fun main(args: Array<String>) {
    runApplication<BackEndCourseApplication>(*args)
}
