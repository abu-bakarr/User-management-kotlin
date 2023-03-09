//package com.example.demo.utilities
//
//import com.example.demo.models.UserModel
//import com.example.demo.repositories.UserRepo
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.stereotype.Service
//
//@Service
//class SecurityConfiguration(private  val userRepo: UserRepo): UserDetailsService {
//
//
//    @Override
//    override fun loadUserByUsername(s: String): UserDetails? {
//        var user: UserModel? = this.userRepo.findUserByName(s)
//        return user?.let { UserPrincipalDetails(it) }
//    }
//
//}