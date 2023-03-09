package com.example.demo.repositories

import com.example.demo.models.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface UserRepo: JpaRepository<UserModel, Int> {
    fun findByEmail(email:String): UserModel?

    fun findUserByName(name: String): UserModel?

    override fun findById(id: Int): Optional<UserModel>
}