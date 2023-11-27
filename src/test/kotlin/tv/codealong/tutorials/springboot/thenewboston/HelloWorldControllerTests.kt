package tv.codealong.tutorials.springboot.thenewboston

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldControllerTests @Autowired constructor(val mockMvc: MockMvc) {
    @Test
    fun `should return successful response`() {
        val result = mockMvc.get("/api/hello")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content {
                    contentTypeCompatibleWith(MediaType.TEXT_PLAIN)
                }
            }
            .andReturn()

        val response = result.response.contentAsString
        println("actual response $response")

        assertThat(response).isEqualTo("Hello, this is a REST endpoint!")
    }
}