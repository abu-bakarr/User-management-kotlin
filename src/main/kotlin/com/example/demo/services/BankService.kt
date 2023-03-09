package com.example.demo.services

import com.example.demo.repositories.BankRepo
import com.example.demo.models.Bank
import jakarta.persistence.Transient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class BankService (
    @Autowired
    private val bankRepo: BankRepo
){


    @Transient
    fun getBanks(): Collection<Bank> = bankRepo.findAll()


    @Transient
    fun getBank(id: Long): Bank = bankRepo.findById(id)
        .orElseThrow{
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "Bank with $id not found"
            )
        }

    @Transient
    fun createBank (bank: Bank): Bank = bankRepo.save(bank)

    @Transient
    fun updateBankByID(id: Long, bank: Bank): Bank {
        return if (bankRepo.existsById(id)){
            bankRepo.save(
                Bank(
                    id = bank.id,
                    fullName = bank.fullName,
                    accountNumber = bank.accountNumber,
                    transactionFee = bank.transactionFee,
                    trust = bank.trust)
                )
        }else   {
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bank with $id not found"
                )
            }
    }

    @Transient
    fun findAccountNumber(accountNumber: String) : Collection<Bank> = bankRepo.findByAccountNumber(accountNumber)

    @Transient
    fun deleteBankId(id: Long): Unit = bankRepo.deleteById(id)

}
