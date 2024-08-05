package com.adobe.securitydemo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class SampleController {

    @GetMapping
    public String landing() {
        return  "Landing Home Page!!";
    }
    @GetMapping("hello")
    public String sayHello() {
        return  "Hello Spring Security!!!";
    }

    @GetMapping("admin")
    public String sayHelloAdmin() {
        SecurityContext context = SecurityContextHolder.getContext();
//        Principal authentication = (Authentication)context.getAuthentication().getPrincipal();
        return  context +  " : Hello Spring Security for Admin!!!";
    }

}
