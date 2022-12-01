package com.hansol.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity //해당 파일로 시큐리티를 활성화
@Configuration //IoC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //super.configure(http);
        //super.configure(http)를 삭제하면, 기존 시큐리티가 가지고 있던 기능이 모두 비활성화 됨
        http.authorizeRequests()
                .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/auth/signin")
                .defaultSuccessUrl("/");
        // "/", "/user/**", "/image/**", "/subscribe/**", "/comment/**"와 같은 요청이 왔을 경우에는 인증이 필요함.
        // 그 이외의 요청에 대해서는 모두 권한 없이도 접근이 가능하도록 설정.
        // 접근이 필요한 페이지에 대해서 접근을 요청할 경우, 접근 권한이 없다면 로그인 페이지를 보여주어 권한을 갖도록 유도함.
    }
}
