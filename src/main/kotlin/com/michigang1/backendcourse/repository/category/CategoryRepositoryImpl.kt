package com.michigang1.backendcourse.repository.category

import com.michigang1.backendcourse.exception.NoOneOfTwoParamsProvidedException
import com.michigang1.backendcourse.exception.ResourceByParamNotFound
import com.michigang1.backendcourse.models.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RequestBody

@Repository
class CategoryRepositoryImpl : CategoryRepository {
    private val categoriesStub = mutableListOf<Category>()
    override suspend fun getAllCategories(): List<Category> {
        return categoriesStub
    }

    override suspend fun addCategory(category: Category): Category {
        category.id = categoriesStub.count()
        categoriesStub.add(category)
        return categoriesStub.last()
    }

    override suspend fun deleteCategoryById(id: Int): Boolean {
        val category = categoriesStub.find { it.id == id }
        if (category == null) throw ResourceByParamNotFound()
        else {
            categoriesStub.removeAt(categoriesStub.indexOf(category))
            val isDeleted = categoriesStub.none { it.id == id }

            return isDeleted
        }
    }
}
