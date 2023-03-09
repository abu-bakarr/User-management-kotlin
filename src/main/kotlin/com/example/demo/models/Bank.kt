package com.example.demo.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name="bank_tbl")
data class Bank(
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     val id: Long?,
     val accountNumber: String,
     val trust: Double,
     val fullName: String,
     val transactionFee: Int,

)
