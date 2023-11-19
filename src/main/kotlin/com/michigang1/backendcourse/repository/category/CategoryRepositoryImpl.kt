package com.michigang1.backendcourse.repository.category

import com.michigang1.backendcourse.models.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryImpl : CategoryRepository {
    @Autowired
    private val categoriesStub = mutableListOf<Category>()
    override suspend fun getAllCategories(): List<Category> {
        return categoriesStub
    }

    override suspend fun addCategory(category: Category): Category {
        categoriesStub.add(category)
        return categoriesStub.last()
    }

    override suspend fun deleteCategoryById(id: Int): Boolean {
        val category = categoriesStub.find { it.id == id } ?: return false
        categoriesStub.remove(category)
        return true
    }
}
