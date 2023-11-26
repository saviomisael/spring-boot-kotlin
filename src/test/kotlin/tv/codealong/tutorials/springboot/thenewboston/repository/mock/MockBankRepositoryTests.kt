package tv.codealong.tutorials.springboot.thenewboston.repository.mock

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class MockBankRepositoryTests {
    private val mockBankRepository = MockBankRepository()

    @Test
    fun `should provide a collection of banks`() {
        val banks = mockBankRepository.retrieveBanks()

        assertThat(banks).isNotEmpty()
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data`() {
        val banks = mockBankRepository.retrieveBanks()

        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        assertThat(banks).anyMatch { it.trust != 0.0 }
        assertThat(banks).anyMatch { it.transactionFee != 0 }
    }
}