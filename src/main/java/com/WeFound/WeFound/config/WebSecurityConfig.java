package com.WeFound.WeFound.config;

import com.WeFound.WeFound.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

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
                        .requestMatchers("/","/main","/login","/loginProc", "/join", "/joinProc", "/css/**", "/img/**","/scripts/**","/plugin/**","/fonts/**").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN") // admin 경로는 ADMIN 권한을 가진 사용자에게만 허용
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER") // my/** 경로는 ADMIN, USER 권한을 가진 사용자에게만 허용
                        .requestMatchers("/api/**").permitAll()
                        .anyRequest().authenticated() // 나머지 요청은 인증된 사용자에게만 허용
                );


        httpSecurity
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/loginProc")
                        .usernameParameter("email") // username 대신 email 파라미터 사용
                        .defaultSuccessUrl("/") // 로그인 성공 후 이동할 메인페이지
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



}