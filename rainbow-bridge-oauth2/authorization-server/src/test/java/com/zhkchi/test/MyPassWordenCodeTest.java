package com.zhkchi.test;

import com.zhkchi.AuthorizationSeverApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wedbet
 * @date 2019/12/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthorizationSeverApplication.class)
public class MyPassWordenCodeTest {
    @Test
    public void passWordEncodeTest(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("secret"));
        System.out.println(passwordEncoder.encode("123456"));
    }
}
