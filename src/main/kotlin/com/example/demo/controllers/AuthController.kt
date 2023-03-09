package com.example.demo.controllers

import com.example.demo.dtos.SignInDTO
import com.example.demo.dtos.SignupDTO
import com.example.demo.models.UserModel
import com.example.demo.services.UserService
import com.example.demo.utilities.Message
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.crypto.SecretKey

@RestController
@RequestMapping("api/v1")
class AuthController (
    private val userService: UserService
) {
    private val key: SecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256)

    @PostMapping("signup")
    fun register(@RequestBody payload: SignupDTO): ResponseEntity<UserModel> {
        var user = UserModel()
        user.name = payload.name
        user.email = payload.email
        user.password = payload.password

        return ResponseEntity.ok(userService.addUser(user))
    }

    @PostMapping("signin")
    fun login(@RequestBody payload: SignInDTO, response: HttpServletResponse): ResponseEntity<Any>{
        val user = userService.findByEmail(payload.email)
            ?: return ResponseEntity.badRequest().body(Message("User with email ${payload.email} not found"))

        if (!user.comparePassword(payload.password)){
            return ResponseEntity.badRequest().body(Message("Please Enter Correct Password"))
        }

        val issuer = user.id.toString()
        val jwt = Jwts.builder().setIssuer(issuer).signWith(key).compact()

        val cookie = Cookie("token", jwt)
        cookie.isHttpOnly = true
        response.addCookie(cookie)

        return ResponseEntity.ok(Message("Success"))
    }

    @GetMapping("user")
    @Bean
    fun getUser(@CookieValue("token") jwt: String?): ResponseEntity<Any>{
        try {
            if (jwt == null){
                return ResponseEntity.status(401).body(Message("User cannot be authenticated"))
            }
            val body = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).body

            return ResponseEntity.ok(userService.findById(body.issuer.toInt()))
        }catch (e: Exception){
            return ResponseEntity.status(401).body(Message("User cannot be authenticated"))
        }
    }

    @PostMapping("logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any>{
        var cookie = Cookie("token", "")
        cookie.maxAge =0
        response.addCookie(cookie)
        return ResponseEntity.ok(Message("Logout Successfully"))
    }
}