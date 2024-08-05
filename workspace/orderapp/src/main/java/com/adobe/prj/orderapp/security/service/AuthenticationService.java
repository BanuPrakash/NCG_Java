package com.adobe.prj.orderapp.security.service;

import com.adobe.prj.orderapp.security.dao.UserDao;
import com.adobe.prj.orderapp.security.dto.JwtAuthenticationResponse;
import com.adobe.prj.orderapp.security.dto.SignInDTO;
import com.adobe.prj.orderapp.security.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private  final UserDao userDao;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    // login

    // login
    public JwtAuthenticationResponse login(SignInDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userDao.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        System.out.println(user);
        var jwt = jwtService.generateTokenUtil(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
