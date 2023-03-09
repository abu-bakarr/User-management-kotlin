//package com.example.demo.utilities
//
//import com.example.demo.models.UserModel
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import org.springframework.security.core.userdetails.UserDetails
//
//
//class UserPrincipalDetails(private var user: UserModel): UserDetails {
//
//
//
//    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
//       val authorities  = arrayListOf<String>()
//        // Extract permissions
//        this.user.getPermissionList().forEach {
//            val authority: GrantedAuthority = SimpleGrantedAuthority(it.toString())
//            authorities.add(authority.toString())
//        }
//        // Extract roles
//        this.user.getRolesList().forEach {
//                val authority: GrantedAuthority = SimpleGrantedAuthority(it.toString())
//                authorities.add(authority.toString())
//
//        }
//        return this.authorities
//    }
//
//
//
//    override fun getPassword(): String {
//       return this.user.password
//    }
//
//    override fun getUsername(): String {
//        return this.user.name
//    }
//
//    override fun isAccountNonExpired(): Boolean {
//        return true
//    }
//
//    override fun isAccountNonLocked(): Boolean {
//        return false
//    }
//
//    override fun isCredentialsNonExpired(): Boolean {
//        return  true
//    }
//
//    override fun isEnabled(): Boolean {
//      return true
//    }
//
//}