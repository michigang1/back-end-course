package com.michigang1.backendcourse.controller.record

import com.michigang1.backendcourse.models.Record
import org.springframework.http.ResponseEntity

interface RecordController {
    suspend fun getRecordById(id: Int): ResponseEntity<Record?>

    suspend fun getAllRecords(userId: Int?, categoryId: Int?): ResponseEntity<List<Record>>

    suspend fun addRecord(record: Record): ResponseEntity<Record>

    suspend fun deleteRecordById(id: Int): ResponseEntity<Boolean>
}