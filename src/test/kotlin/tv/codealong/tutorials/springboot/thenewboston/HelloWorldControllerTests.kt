package tv.codealong.tutorials.springboot.thenewboston

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldControllerTests @Autowired constructor(val mockMvc: MockMvc, val objectMapper: ObjectMapper) {
    @Test
    fun `should return successful response`() {
        val performGet = mockMvc.get("/api/hello")

        performGet.andDo { print() }
            .andExpect {
                status { isOk() }
                content {
                    contentTypeCompatibleWith(MediaType.TEXT_PLAIN)
                    string("Hello, this is a REST endpoint!")
                }
            }
    }
}