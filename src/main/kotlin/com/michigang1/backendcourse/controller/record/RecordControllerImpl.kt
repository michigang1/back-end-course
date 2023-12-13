package com.michigang1.backendcourse.controller.record

import com.michigang1.backendcourse.exception.NoOneOfTwoParamsProvidedException
import com.michigang1.backendcourse.models.DeleteEntityResponse
import com.michigang1.backendcourse.models.Record
import com.michigang1.backendcourse.service.record.RecordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/record")
class RecordControllerImpl(@Autowired private val service: RecordService) : RecordController {

    @GetMapping(value = ["/{id}"], produces = [ APPLICATION_JSON_VALUE])
    override suspend fun getRecordById(@PathVariable("id")id: Int): ResponseEntity<Record?> {
        val record = service.getRecordById(id)
        return ResponseEntity.ok(record)
    }

    @GetMapping(produces = [ APPLICATION_JSON_VALUE])
    override suspend fun getAllRecords(@RequestParam("userId", required = false) userId: Int?,
                                       @RequestParam("categoryId", required = false) categoryId: Int?): ResponseEntity<List<Record>> {
        val list = service.getAllRecords(userId, categoryId)
        val result =  if (list.isNullOrEmpty()) throw NoOneOfTwoParamsProvidedException() else ResponseEntity.ok(list)
        return result
    }

    @PostMapping(produces = [ APPLICATION_JSON_VALUE], consumes = [ APPLICATION_JSON_VALUE])
    override suspend fun addRecord(@RequestBody record: Record): ResponseEntity<Record> {
        val newRecord = service.addRecord(record)
        return ResponseEntity.ok(newRecord)
    }

    @DeleteMapping(value = ["/{id}"], produces = [ APPLICATION_JSON_VALUE])
    override suspend fun deleteRecordById(@PathVariable("id")id: Int): ResponseEntity<DeleteEntityResponse> {
        val result = DeleteEntityResponse(service.deleteRecordById(id))
        return ResponseEntity.ok(result)
    }
}
