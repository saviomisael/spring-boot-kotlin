package tv.codealong.tutorials.springboot.thenewboston.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import tv.codealong.tutorials.springboot.thenewboston.repository.BankRepository

class BankServiceTests {
    private val repository: BankRepository = mockk<BankRepository>()
    private val bankService = BankService(repository)
    @Test
    fun `should call its data source to retrieve banks`() {
        every { repository.retrieveBanks() } returns emptyList()

        val banks = bankService.getBanks()

        // mockk will check if this method was called
        verify(exactly = 1) {
            repository.retrieveBanks()
        }
    }
}