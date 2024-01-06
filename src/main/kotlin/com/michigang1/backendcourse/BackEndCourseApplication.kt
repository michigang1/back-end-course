package com.michigang1.backendcourse

import com.michigang1.backendcourse.entity.UserEntityRepository
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
    suspend fun initializeCategories(@Autowired repository: CategoryRepository) = listOf(
        Category(name = "Food"),
        Category(name = "Transport"),
        Category(name = "Clothes"),
        Category(name = "Entertainment"),
        Category(name = "Other"),
    ).forEach { repository.addCategory(it) }


    @Bean
    suspend fun initializeRecords(@Autowired repository: RecordRepository) = listOf(
        Record(userId =  0, categoryId = 1, generalExpenses = 100.0),
        Record(userId = 0, categoryId = 2, generalExpenses = 200.0),
        Record(userId = 1, categoryId = 3, generalExpenses = 300.0),
        Record(userId = 1, categoryId = 4, generalExpenses = 400.0),
        Record(userId = 1, categoryId = 5, generalExpenses = 500.0),
    ).forEach { repository.addRecord(it) }

}

fun main(args: Array<String>) {
    runApplication<BackEndCourseApplication>(*args)
}
