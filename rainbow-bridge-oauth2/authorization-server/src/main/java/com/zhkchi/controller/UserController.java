package com.zhkchi.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

/**
 * @author wedbet
 * @date 2019/11/29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getCurUser")
    public Mono<Principal> getCurUser(Principal principal){

        return Mono.justOrEmpty(principal);
    }
}
