package com.example.demo.services

import com.example.demo.models.UserModel
import com.example.demo.repositories.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
 class UserService (
    @Autowired
    private val userRepo: UserRepo
)  {


    fun addUser (user: UserModel): UserModel = userRepo.save(user)

    fun findByEmail (email: String) : UserModel? = userRepo.findByEmail(email)

    fun findById(id: Int): Optional<UserModel> = userRepo.findById(id)


}