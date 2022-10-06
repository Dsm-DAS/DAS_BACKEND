package com.das.das_backend.global.security;

import com.das.das_backend.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

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
                .antMatchers(HttpMethod.POST, "/user/email").permitAll()
                .antMatchers(HttpMethod.POST, "/user/signup").permitAll()
                .antMatchers(HttpMethod.POST,"/user/token").permitAll()
                .antMatchers(HttpMethod.PUT, "/user/email").permitAll()
                .antMatchers(HttpMethod.GET, "/user/my-page").authenticated()
                .antMatchers(HttpMethod.PATCH, "/user/token").authenticated()
                .antMatchers(HttpMethod.PATCH,"/user/password").authenticated()
                .antMatchers(HttpMethod.PATCH, "/user/my-page").authenticated()
                .antMatchers(HttpMethod.DELETE, "/user/logout").authenticated()
                .antMatchers(HttpMethod.DELETE, "/user").authenticated()

                // feed
                .antMatchers(HttpMethod.GET, "/feed").authenticated()
                .antMatchers(HttpMethod.GET,"/feed/lists").authenticated()
                .antMatchers(HttpMethod.GET,"/feed/{feed-id}").authenticated()
                .antMatchers(HttpMethod.POST, "/feed").authenticated()
                .antMatchers(HttpMethod.PATCH, "/feed/{feed-id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/feed/{feed-id}").authenticated()

                // comment
                .antMatchers(HttpMethod.POST, "/comment/{feed-id}").authenticated()
                .antMatchers(HttpMethod.PATCH, "/comment/{comment-id}").authenticated()
                .antMatchers(HttpMethod.DELETE,"/comment/{comment-id}").authenticated()

                // notice
                .antMatchers(HttpMethod.POST, "/notice").hasAuthority("TEACHER, MANAGER")
                .antMatchers(HttpMethod.PATCH, "/notice/{notice-id}").hasAuthority("TEACHER, MANAGER")
                .antMatchers(HttpMethod.DELETE, "/notice/{notice-id}").hasAuthority("TEACHER, MANAGER")

                // teacher
                .antMatchers(HttpMethod.PUT, "/teacher").hasAuthority("TEACHER, MANAGER")
                .anyRequest().denyAll()

                .and()
                .apply(new FilterConfig(jwtTokenProvider, objectMapper))

                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
