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

    @Bean
    public WebSecurityCustomizer configure() {      // 스프링 시큐리티 기능 비활성화
        return web -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers("/static/**"); //나중엔 api항목은 지워야한다.
    }

    // 특정 HTTP 요청에 대한 웹 기반 보안 구성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {


        httpSecurity
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/login", "/loginProc", "/join", "/joinProc", "/css/**", "/img/**", "/scripts/**", "/plugin/**", "/fonts/**").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/api/**").permitAll()
                        .anyRequest().authenticated()
                );
        httpSecurity
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/loginProc")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/")
                        .permitAll()
                );
        httpSecurity
                .sessionManagement((auth) -> auth
                        .maximumSessions(1) // 하나의 아이디에 대한 다중 로그인 허용 개수
                        .maxSessionsPreventsLogin(true)); //다중 로그인 개수를 초과하였을 경우 초과시 새로운 로그인 차단
                                                            // false는 초과시 기존 세션 하나 삭제


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


    // 패스워드 인코더로 사용할 빈 등록
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}