//package com.example.demo.utilities
//
//import com.example.demo.services.UserService
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.web.servlet.config.annotation.CorsRegistry
//import org.springframework.web.servlet.config.annotation.EnableWebMvc
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
//
//@Configuration
//@EnableWebMvc
//class WebConfig : WebMvcConfigurer  {
//
//
//    override fun addCorsMappings(registry: CorsRegistry) {
//        registry.addMapping("/**")
//            .allowedOrigins("http://localhost:3000" )
//            .allowCredentials(true)
//    }
//    @Override
//     fun configureViewResolvers(http: HttpSecurity) {
//        http
//            .authorizeHttpRequests()
//            .requestMatchers("api/v1/banks").hasRole("ADMIN")
//            .requestMatchers("api/v1/user").authenticated()
//            .and()
//            .formLogin()
//            .loginPage("signin")
//
//    }
////    @Override
////    fun configure(auth: AuthenticationManagerBuilder){
////        auth.authenticationProvider(authProvider())
////    }
////
////    @Bean
////    fun authProvider() : DaoAuthenticationProvider{
////        var me = DaoAuthenticationProvider()
////       me.setUserDetailsService(this.securityConfiguration)
////        return me
////    }
//}