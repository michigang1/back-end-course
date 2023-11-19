package com.michigang1.backendcourse.controller.category

import com.michigang1.backendcourse.models.Category
import org.springframework.http.ResponseEntity

interface CategoryController {
    suspend fun getAllCategories(): ResponseEntity<List<Category>>
    suspend fun addCategory(category: Category): ResponseEntity<Category>
    suspend fun deleteCategoryById(id: Int): ResponseEntity<Boolean>
}