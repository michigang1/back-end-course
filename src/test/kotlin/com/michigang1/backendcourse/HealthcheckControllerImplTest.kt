package com.michigang1.backendcourse

import com.michigang1.backendcourse.controller.HealthchekControllerImpl
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

@WebMvcTest(HealthchekControllerImpl::class)
class HealthcheckControllerImplTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun testHealthcheckEndpoint() {
        val expectedStatus = 200
        val expectedDate = LocalDate.now()

        mockMvc.perform(get("/api/healthcheck").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(
                content().json(
                    """
                    {
                        "date": "$expectedDate",
                        "status": $expectedStatus
                    }
                    """.trimIndent(),
                ),
            )
    }
}
