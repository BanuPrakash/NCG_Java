package com.example.demosecure;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class SampleController {


    @GetMapping("hello")
    public String sayHello() {
        return "Hello Secure Application!!!";
    }


//    @Secured("hasAuthority('ADMIN')")
@Secured("ROLE_ADMIN")
    @GetMapping("admin")
    public String sayHelloAdmin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return auth.getName() + " Hello Admin Secure Application!!!";
    }
}
