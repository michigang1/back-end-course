package com.michigang1.backendcourse.repository.record

import com.michigang1.backendcourse.exception.NoOneOfTwoParamsProvidedException
import com.michigang1.backendcourse.exception.ResourceByParamNotFound
import com.michigang1.backendcourse.models.Record
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository

@Repository
class RecordRepositoryImpl : RecordRepository {
    @Autowired
    @Qualifier("initializeRecords")
    private val recordStub = mutableListOf<Record>()
    override suspend fun getRecordById(id: Int): Record? {
        return recordStub[id]
    }

    override suspend fun getAllRecords(): List<Record> {
        return recordStub
    }
    override suspend fun addRecord(record: Record): Record {
        recordStub.add(record)
        return recordStub.last()
    }

    override suspend fun deleteRecordById(id: Int): Boolean {
        val record = recordStub.find { it.id == id }
        if (record == null) throw ResourceByParamNotFound()
        else {
            recordStub.removeAt(id)
            val isDeleted = recordStub.none { it.id == id }

            return isDeleted
        }
    }
}
