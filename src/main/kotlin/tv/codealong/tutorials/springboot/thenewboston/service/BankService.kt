package tv.codealong.tutorials.springboot.thenewboston.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import tv.codealong.tutorials.springboot.thenewboston.model.Bank
import tv.codealong.tutorials.springboot.thenewboston.repository.BankRepository

@Service
class BankService @Autowired constructor(private val repository: BankRepository) {
    fun getBanks(): Collection<Bank> = repository.retrieveBanks()
}