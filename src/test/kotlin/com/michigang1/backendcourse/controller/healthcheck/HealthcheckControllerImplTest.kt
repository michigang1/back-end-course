package com.michigang1.backendcourse.controller.healthcheck

import com.fasterxml.jackson.databind.ObjectMapper
import com.michigang1.backendcourse.models.DateResponse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@WebMvcTest(HealthchekControllerImpl::class)
class HealthcheckControllerImplTest {

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun testHealthcheckEndpoint() {
        val expectedStatus = HttpStatus.OK.value()
        val expectedDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
        val expectedJsonObject = DateResponse(
            date = expectedDate,
            status = expectedStatus,
        )

        mockMvc.perform(get("/api/healthcheck").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(
                content().json(
                    objectMapper.writeValueAsString(expectedJsonObject),
                ),
            )
    }
}
