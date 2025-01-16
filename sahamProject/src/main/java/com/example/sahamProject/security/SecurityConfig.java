package com.example.sahamProject.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll() // Izinkan akses ke halaman login
                .anyRequest().authenticated() // Semua permintaan lain memerlukan autentikasi
                .and()
                .formLogin()
                .loginPage("/login") // Tentukan halaman login kustom
                .defaultSuccessUrl("/dashboard", true) // Halaman setelah login berhasil
                .permitAll() // Izinkan semua untuk mengakses halaman login
                .and()
                .logout()
                .permitAll(); // Izinkan semua untuk logout

    }
}
