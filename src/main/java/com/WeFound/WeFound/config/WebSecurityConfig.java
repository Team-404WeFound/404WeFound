package com.WeFound.WeFound.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

//    // 특정 HTTP 요청에 대한 웹 기반 보안 구성
//    @Bean
//    public WebSecurityCustomizer configure() {      // 스프링 시큐리티 기능 비활성화
//        return web -> web.ignoring().requestMatchers(toH2Console())
//                .requestMatchers("/static/**","/api/**"); //나중엔 api항목은 지워야한다.
//    }

    // 패스워드 암호화
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // 특정 HTTP 요청에 대한 웹 기반 보안 구성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/","/login","/loginProc", "/signup","/join", "/joinProc", "/css/**", "/img/**","/scripts/**","/plugin/**","/fonts/**").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN") // admin 경로는 ADMIN 권한을 가진 사용자에게만 허용
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER") // my/** 경로는 ADMIN, USER 권한을 가진 사용자에게만 허용
                        .anyRequest().authenticated() // 나머지 요청은 인증된 사용자에게만 허용
                );





//        httpSecurity
//                .formLogin(auth -> auth.loginPage("/login")     // 폼 기반 로그인 설정
//                        .defaultSuccessUrl("/articles")
//                );

        httpSecurity
                .formLogin((auth) -> auth.loginPage("/login")
                        .loginProcessingUrl("/loginProc")
                        .permitAll()
                );


//        httpSecurity
//                .logout(auth -> auth.logoutSuccessUrl("/login") // 로그아웃 설정
//                        .invalidateHttpSession(true)
//                );


        // csrf 일단 비활성화
        httpSecurity
                .csrf(auth -> auth
                        .disable()
                );


        return httpSecurity.build();
    }



}