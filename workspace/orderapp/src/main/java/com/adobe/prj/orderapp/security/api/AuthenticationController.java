package com.adobe.prj.orderapp.security.api;

import com.adobe.prj.orderapp.security.dto.JwtAuthenticationResponse;
import com.adobe.prj.orderapp.security.dto.SignInDTO;
import com.adobe.prj.orderapp.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody SignInDTO dto) {
        // write token back...
        System.out.println("DTO "  + dto);
        return authenticationService.login(dto);
    }
}
