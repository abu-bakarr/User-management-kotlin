package com.example.demo.repositories

import com.example.demo.models.Bank
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BankRepo: JpaRepository<Bank, Long> {
    fun findByAccountNumber(accountNumber: String): Collection<Bank>

}