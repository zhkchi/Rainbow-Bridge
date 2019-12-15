package com.zhkchi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author wedbet
 * @date 2019/11/29
 */
@SpringBootApplication
@MapperScan("com.zhkchi.mapper")
public class AuthorizationSeverApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationSeverApplication.class,args);
    }
}
