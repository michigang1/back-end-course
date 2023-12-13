package com.michigang1.backendcourse.service.record

import com.michigang1.backendcourse.models.Record
import com.michigang1.backendcourse.repository.record.RecordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RecordServiceImpl(@Autowired private val repository: RecordRepository): RecordService {
    override suspend fun getRecordById(id: Int): Record? {
        return repository.getRecordById(id)
    }

    override suspend fun getAllRecords(userId: Int?, categoryId: Int?): List<Record>? {
        val records = repository.getAllRecords()
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
        return repository.addRecord(record)
    }

    override suspend fun deleteRecordById(id: Int): Boolean {
        return repository.deleteRecordById(id)
    }
}