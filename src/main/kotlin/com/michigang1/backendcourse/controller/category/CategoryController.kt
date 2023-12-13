package com.michigang1.backendcourse.controller.category

import com.michigang1.backendcourse.models.Category
import com.michigang1.backendcourse.models.DeleteEntityResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

interface CategoryController {
    suspend fun getAllCategories(): ResponseEntity<List<Category>>
    suspend fun addCategory(category: Category): ResponseEntity<Category>
    suspend fun deleteCategoryById(id: Int): ResponseEntity<DeleteEntityResponse>
}