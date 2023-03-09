package com.example.demo.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Entity
@Table(name = "user_tbl")
class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    @Column
    var name = ""

    @Column(name="user_role")
    var role = ""
//
//    @Column(name="user_active")
//    var active: Int =0
//
//    @Column(name="permission")
//    var permission =""

    @Column(unique = true)
    var email = ""

    @Column
    var password = ""
        @JsonIgnore
        get() = field
        set(value) {
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    fun comparePassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.password)
    }
// Added fun for User Management
//    fun getId(): Int = id
//    fun getUserName(): String = name
//    fun getPassword(): String = password
//
//    fun getRoles():String = role
//    fun getPermissions(): String = permission
//    fun getActive(): Int = active
//
//    fun getPermissionList(): List<Any> {
//        if (this.permission.isNotEmpty()){
//            return listOf(this.permission.split(","))
//        }
//        return arrayListOf<String>()
//    }
//
//    fun getRolesList(): List<Any> {
//        if (this.role.isNotEmpty()){
//            return listOf(this.role.split(","))
//        }
//        return arrayListOf<String>()
//    }

}