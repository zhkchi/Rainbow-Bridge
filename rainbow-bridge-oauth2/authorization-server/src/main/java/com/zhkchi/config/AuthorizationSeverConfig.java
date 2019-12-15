package com.zhkchi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;


import javax.sql.DataSource;

/**
 * 认证服务器配置
 * @author wedbet
 * @date 2019/11/29
 */
 @Configuration
@EnableAuthorizationServer
public class AuthorizationSeverConfig extends AuthorizationServerConfigurerAdapter {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        //需要指定数据源，否则与默认数据源冲突
        return DataSourceBuilder.create().build();
    }

     private PasswordEncoder passwordEncoder;
    @Autowired
     public void setPasswordEncoder(PasswordEncoder passwordEncoder){
         this.passwordEncoder = passwordEncoder;
     }

    @Bean
    public HttpFirewall httpFirewall() {
        return new DefaultHttpFirewall();
    }

    @Bean
    public TokenStore tokenStore(){
         //基于Jdbc实现，令牌保存到数据库
        return new JdbcTokenStore(dataSource());
    }

    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
         //基于Jdbc实现，需要在数据库中初始化客户端信息
        return new JdbcClientDetailsService(dataSource());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /*clients.inMemory().withClient("client").secret(passwordEncoder.encode("secret"))
                    .authorizedGrantTypes("authorization_code")
                .scopes("app")
                    .redirectUris("http://www.ifeng.com/");*/
        clients.withClientDetails(jdbcClientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore());
    }
}
