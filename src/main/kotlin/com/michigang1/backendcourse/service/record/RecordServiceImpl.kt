package com.michigang1.backendcourse.service.record

import com.michigang1.backendcourse.entity.RecordEntity
import com.michigang1.backendcourse.entity.RecordEntityRepository
import com.michigang1.backendcourse.models.Record
import com.michigang1.backendcourse.repository.record.RecordRepository
import com.michigang1.backendcourse.service.category.CategoryService
import com.michigang1.backendcourse.service.category.toCategoryEntity
import com.michigang1.backendcourse.service.user.UserService
import com.michigang1.backendcourse.service.user.toUserEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RecordServiceImpl(@Autowired private val repository: RecordEntityRepository): RecordService {

    @Autowired
    private lateinit var userService: UserService

    @Autowired

    private lateinit var categoryService: CategoryService
    override suspend fun getRecordById(id: Int): Record? {
        return repository.findById(id).orElse(null)?.toRecord() ?: throw Exception("Record not found")
    }

    override suspend fun getAllRecords(userId: Int?, categoryId: Int?): List<Record>? {
        val records = repository.findAll().map { it.toRecord() }
        return if (userId != null && categoryId != null) {
            records.filter { it.userId == userId && it.categoryId == categoryId }
        } else if (userId != null) {
            records.filter { it.userId == userId }
        } else if (categoryId != null) {
            records.filter { it.categoryId == categoryId }
        }
        else {
            emptyList()
        }
    }

    override suspend fun addRecord(record: Record): Record {
        return repository.save(record.toRecordEntity()).toRecord()
    }

    override suspend fun deleteRecordById(id: Int): Boolean {
        repository.deleteById(id)
        return repository.findById(id).isEmpty
    }

    suspend fun Record.toRecordEntity(): RecordEntity {
        return RecordEntity(
            id = this.id,
            user = userService.getUserById(this.userId)!!.toUserEntity(),
            category = categoryService.getAllCategories().find { it.id == this.categoryId }!!.toCategoryEntity(),
            dateTimeAtCreation = this.dateTimeAtCreation,
            generalExpenses = this.generalExpenses
        )
    }

    suspend fun RecordEntity.toRecord(): Record {
        return Record(
            id = this.id,
            userId = this.user.id,
            categoryId = this.category.id,
            dateTimeAtCreation = this.dateTimeAtCreation,
            generalExpenses = this.generalExpenses
        )
    }
}