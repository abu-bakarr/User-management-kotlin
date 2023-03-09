package com.example.demo.controllers
import com.example.demo.models.Bank
import com.example.demo.services.BankService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/banks")
class BankController(private val service: BankService) {

    @GetMapping
    fun getBanks (): Collection<Bank> = service.getBanks()

    @GetMapping("/{id}")
    fun getBank(@PathVariable  id: Long):
            Bank = service.getBank(id)

    @PostMapping("")
    fun creatBank(@RequestBody payload: Bank): Bank = service.createBank(payload)

    @GetMapping("/account/{accountNumber}")
    fun findAccountNumber(@PathVariable accountNumber: String): Collection<Bank> = service.findAccountNumber(accountNumber)

    @PatchMapping("/{id}")
    fun updateBank(@PathVariable  id: Long, @RequestBody payload: Bank) = service.updateBankByID(id, payload)

    @DeleteMapping("/{id}")
    fun deleteBank (@PathVariable id: Long) = service.deleteBankId(id)
}

