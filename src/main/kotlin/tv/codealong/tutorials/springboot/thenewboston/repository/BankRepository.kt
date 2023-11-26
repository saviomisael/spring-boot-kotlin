package tv.codealong.tutorials.springboot.thenewboston.repository

import tv.codealong.tutorials.springboot.thenewboston.model.Bank

interface BankRepository {
    fun retrieveBanks(): Collection<Bank>
}