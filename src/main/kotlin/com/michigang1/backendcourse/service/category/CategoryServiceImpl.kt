package com.michigang1.backendcourse.service.category

import com.michigang1.backendcourse.models.Category
import com.michigang1.backendcourse.repository.category.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(@Autowired private val repository: CategoryRepository) : CategoryService {
    override suspend fun getAllCategories(): List<Category> {
        return repository.getAllCategories()
    }

    override suspend fun addCategory(category: Category): Category {
        return repository.addCategory(category)
    }

    override suspend fun deleteCategoryById(id: Int): Boolean {
        return repository.deleteCategoryById(id)
    }
}
