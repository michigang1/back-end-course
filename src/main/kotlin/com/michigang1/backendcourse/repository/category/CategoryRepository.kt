package com.michigang1.backendcourse.repository.category

import com.michigang1.backendcourse.models.Category

interface CategoryRepository {

    suspend fun getAllCategories(): List<Category>

    suspend fun addCategory(category: Category): Category

    suspend fun deleteCategoryById(id: Int): Boolean
}
