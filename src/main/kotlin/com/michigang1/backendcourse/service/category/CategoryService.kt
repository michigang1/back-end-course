package com.michigang1.backendcourse.service.category

import com.michigang1.backendcourse.models.Category
interface CategoryService {
    suspend fun getAllCategories(): List<Category>

    suspend fun addCategory(category: Category): Category

    suspend fun deleteCategoryById(id: Int): Boolean

}