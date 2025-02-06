// package com.example.sahamProject.config;

// import java.io.IOException;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import
// org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// Exception {
// http
// // .addFilterBefore(new JWTAuthenticationFilter(),
// // UsernamePasswordAuthenticationFilter.class)
// .csrf(csrf -> csrf.disable()) // Matikan CSRF jika perlu
// .authorizeHttpRequests(auth -> auth
// .requestMatchers("/api/auth/login-user").permitAll()
// .requestMatchers("/public/**").permitAll()
// .anyRequest().authenticated() // Selain itu harus login
// )
// .sessionManagement(session -> session
// .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// .formLogin(form -> form
// .loginPage("/login")
// .successHandler((request, response, authentication) -> {
// response.sendRedirect("/home");
// })
// .permitAll())
// .logout(logout -> logout
// .logoutUrl("/logout")
// .logoutSuccessUrl("/login?logout")
// .permitAll());

// return http.build();
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }

// // @Component
// // public class JWTAuthenticationFilter extends OncePerRequestFilter {

// // @Override
// // protected void doFilterInternal(HttpServletRequest request,
// // HttpServletResponse response,
// // FilterChain filterChain) throws ServletException, IOException {
// // String token = request.getHeader("Authorization");

// // if (token == null || !token.startsWith("Bearer ")) {
// // response.sendRedirect("/login"); // Jika tidak ada token, redirect ke
// login
// // return;
// // }

// // String extractedToken = token.substring(7);
// // Authentication auth = tokenService.parseToken(extractedToken);

// // if (auth != null) {
// // SecurityContextHolder.getContext().setAuthentication(auth);
// // } else {
// // response.sendRedirect("/login"); // Jika token tidak valid, redirect ke
// login
// // }

// // filterChain.doFilter(request, response);
// // }

// // }

// }
