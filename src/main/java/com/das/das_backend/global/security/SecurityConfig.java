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
                .antMatchers(HttpMethod.GET, "/user/my-page").authenticated()
                .antMatchers(HttpMethod.GET, "/user/{user-id}").authenticated()
                .antMatchers(HttpMethod.GET, "/user").authenticated()
                .antMatchers(HttpMethod.POST, "/user/email").permitAll()
                .antMatchers(HttpMethod.POST, "/user/signup").permitAll()
                .antMatchers(HttpMethod.POST,"/user/token").permitAll()
                .antMatchers(HttpMethod.PUT, "/user/email").permitAll()
                .antMatchers(HttpMethod.PUT, "/user/my-page").authenticated()
                .antMatchers(HttpMethod.PATCH, "/user/token").permitAll()
                .antMatchers(HttpMethod.PATCH,"/user/password").authenticated()
                .antMatchers(HttpMethod.DELETE, "/user/logout").authenticated()
                .antMatchers(HttpMethod.DELETE, "/user").authenticated()

                // feed
                .antMatchers(HttpMethod.GET, "/feed").authenticated()
                .antMatchers(HttpMethod.GET,"/feed/lists").authenticated()
                .antMatchers(HttpMethod.GET,"/feed/{feed-id}").authenticated()
                .antMatchers(HttpMethod.POST, "/feed").authenticated()
                .antMatchers(HttpMethod.PATCH, "/feed/{feed-id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/feed/{feed-id}").authenticated()

                //club
                .antMatchers(HttpMethod.POST, "/club").hasAnyAuthority("TEACHER", "CLUB_MANAGER", "ADMIN")
                .antMatchers(HttpMethod.PATCH, "/club/{club-id}").hasAnyAuthority("TEACHER", "CLUB_MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/club/{club-id}").hasAnyAuthority("TEACHER", "CLUB_MANAGER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/club/lists").authenticated()
                .antMatchers(HttpMethod.GET, "/club/{club-id}").authenticated()

                // comment
                .antMatchers(HttpMethod.POST, "/comment/{feed-id}").authenticated()
                .antMatchers(HttpMethod.PATCH, "/comment/{comment-id}").authenticated()
                .antMatchers(HttpMethod.DELETE,"/comment/{comment-id}").authenticated()

                // notice
                .antMatchers(HttpMethod.GET, "/notice").authenticated()
                .antMatchers(HttpMethod.GET, "/notice/{notice-id}").authenticated()
                .antMatchers(HttpMethod.POST, "/notice").hasAnyAuthority("TEACHER", "ADMIN")
                .antMatchers(HttpMethod.PATCH, "/notice/{notice-id}").hasAnyAuthority("TEACHER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/notice/{notice-id}").hasAnyAuthority("TEACHER", "ADMIN")

                // teacher
                .antMatchers(HttpMethod.PUT, "/teacher").hasAnyAuthority("TEACHER", "ADMIN")
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
