package com.zhkchi.config;

import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Security配置
 * @author wedbet
 * @date 2019/11/29
 */
@EnableWebFluxSecurity
public class AuthorizationSeverConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public ReactiveUserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails uesr1 = User.builder().passwordEncoder(encoder::encode).username("Tony").password("123456").roles("USER","ADMIN","CLIENT").authorities("Scope_reource.read").build();
        return new MapReactiveUserDetailsService(uesr1);
    }
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity httpSecurity){
        return httpSecurity.authorizeExchange().matchers(EndpointRequest.toAnyEndpoint()).permitAll()
                .anyExchange().authenticated().and()
                .httpBasic().and()
                .formLogin().and()
//                .oauth2Client().and()
                .build();
    }
}
