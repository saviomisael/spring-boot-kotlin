package tv.codealong.tutorials.springboot.thenewboston.repository.mock

import org.springframework.stereotype.Repository
import tv.codealong.tutorials.springboot.thenewboston.model.Bank
import tv.codealong.tutorials.springboot.thenewboston.repository.BankRepository

@Repository
class MockBankRepository : BankRepository {
    private val banks = listOf(
        Bank("1234", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("5678", 0.0, 100),
    )

    override fun retrieveBanks(): Collection<Bank> = banks
}