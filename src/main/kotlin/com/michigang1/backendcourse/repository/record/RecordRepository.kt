package com.michigang1.backendcourse.repository.record

import com.michigang1.backendcourse.models.Record

interface RecordRepository {

    suspend fun getRecordById(id: Int): Record?

    suspend fun getAllRecords(): List<Record>

    suspend fun addRecord(record: Record): Record

    suspend fun deleteRecordById(id: Int): Boolean
}
