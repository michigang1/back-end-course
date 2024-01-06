package com.michigang1.backendcourse.service.category

import com.michigang1.backendcourse.entity.CategoryEntity
import com.michigang1.backendcourse.entity.CategoryEntityRepository
import com.michigang1.backendcourse.models.Category
import com.michigang1.backendcourse.repository.category.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(@Autowired private val repository: CategoryEntityRepository) : CategoryService {
    override suspend fun getAllCategories(): List<Category> {
        return repository.findAll().map { it.toCategory() }
    }


    override suspend fun addCategory(category: Category): Category {
        return repository.save(category.toCategoryEntity()).toCategory()
    }

    override suspend fun deleteCategoryById(id: Int): Boolean {
        repository.deleteById(id)
        return repository.findById(id).isEmpty
    }
}

fun Category.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        id = this.id,
        name = this.name
    )
}

fun CategoryEntity.toCategory(): Category {
    return Category(
        id = this.id,
        name = this.name
    )
}
