package com.michigang1.backendcourse.service.record

import com.michigang1.backendcourse.models.Record

interface RecordService {
    suspend fun getRecordById(id: Int): Record?

    suspend fun getAllRecords(userId: Int?, categoryId: Int?): List<Record>?

    suspend fun addRecord(record: Record): Record

    suspend fun deleteRecordById(id: Int): Boolean
}