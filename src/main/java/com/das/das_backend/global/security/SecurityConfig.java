package com.das.das_backend.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .formLogin().disable()
                .cors()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()


                // user
                .antMatchers(HttpMethod.POST, "/user/signup").permitAll()
                .antMatchers("/user/token").permitAll()
                .antMatchers(HttpMethod.DELETE, "/user/logout").authenticated()
                .antMatchers(HttpMethod.DELETE, "/user").authenticated()

                // notice
                .antMatchers(HttpMethod.POST, "/notice").hasAuthority("TEACHER, MANAGER")
                .antMatchers(HttpMethod.DELETE, "/notice/{notice-id}").hasAuthority("TEACHER, MANAGER")
                .antMatchers(HttpMethod.PATCH, "notice/{notice-id}").hasAuthority("TEACHER, MANAGER")
                .anyRequest().denyAll()
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
