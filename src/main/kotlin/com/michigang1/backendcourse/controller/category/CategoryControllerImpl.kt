package com.michigang1.backendcourse.controller.category

import com.michigang1.backendcourse.models.Category
import com.michigang1.backendcourse.service.category.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/category")
class CategoryControllerImpl(@Autowired private val service: CategoryService) : CategoryController {
    @GetMapping
    override suspend fun getAllCategories(): ResponseEntity<List<Category>> {
        val list = service.getAllCategories()
        return ResponseEntity.ok(list)
    }

    @PostMapping
    override suspend fun addCategory(category: Category): ResponseEntity<Category> {
        val newCategory = service.addCategory(category)
        return ResponseEntity.ok(newCategory)
    }

    @DeleteMapping
    override suspend fun deleteCategoryById(id: Int): ResponseEntity<Boolean> {
        val result = service.deleteCategoryById(id)
        return ResponseEntity.ok(result)
    }
}
