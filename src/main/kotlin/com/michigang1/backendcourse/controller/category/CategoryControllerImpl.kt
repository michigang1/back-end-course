package com.michigang1.backendcourse.controller.category

import com.michigang1.backendcourse.models.Category
import com.michigang1.backendcourse.service.category.CategoryService
import com.michigang1.backendcourse.service.category.CategoryServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryControllerImpl(@Autowired private val service: CategoryService) : CategoryController {
    @GetMapping(produces = [ APPLICATION_JSON_VALUE])
    override suspend fun getAllCategories(): ResponseEntity<List<Category>> {
        val list = service.getAllCategories()
        return ResponseEntity.ok(list)
    }

    @PostMapping(produces = [ APPLICATION_JSON_VALUE], consumes = [ APPLICATION_JSON_VALUE])
    override suspend fun addCategory(category: Category): ResponseEntity<Category> {
        val newCategory = service.addCategory(category)
        return ResponseEntity.ok(newCategory)
    }

    @DeleteMapping(produces = [ APPLICATION_JSON_VALUE])
    override suspend fun deleteCategoryById(@RequestParam("id")id: Int): ResponseEntity<Boolean> {
        val result = service.deleteCategoryById(id)
        return ResponseEntity.ok(result)
    }
}
