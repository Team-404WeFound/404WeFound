package com.WeFound.WeFound.config;

import com.WeFound.WeFound.service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);

        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/loginProc", "/join", "/joinProc", "/css/**", "/img/**", "/scripts/**", "/plugin/**", "/fonts/**").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER", "GRADE1", "GRADE2", "GRADE3")
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/premium-question-detail").hasAnyRole("GRADE2", "GRADE3")
                        .requestMatchers("/premium-question-form").hasAnyRole("GRADE2", "GRADE3")
                        .requestMatchers("/premium-questions").hasAnyRole("GRADE2", "GRADE3")
                        .requestMatchers("/premium-questions/answer/**").hasRole("GRADE3")
                        .anyRequest().authenticated()
                )
                .exceptionHandling(e -> e
                        .accessDeniedPage("/access-denied")
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/loginProc")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .sessionManagement(auth -> auth
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true)
                )
                .csrf(auth -> auth
                        .disable() // CSRF 일단 비활성화 (후순위)
                );

        return httpSecurity.build();
    }
}