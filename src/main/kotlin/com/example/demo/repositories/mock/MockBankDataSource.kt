/**
package com.example.demo.datasource.mock

import com.example.demo.datasource.BankDataSource
import com.example.demo.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource: BankDataSource {
    val banks =  listOf(
        Bank("246", 0.0,  3),
        Bank("123", 3.6,  2),
        Bank("987", 9.0,  1),

    )

    override fun getBanks(): Collection<Bank> = banks

    override fun getBank(accountNumber: String): Bank = banks.first{it.accountNumber == accountNumber
    }

}
 **/
