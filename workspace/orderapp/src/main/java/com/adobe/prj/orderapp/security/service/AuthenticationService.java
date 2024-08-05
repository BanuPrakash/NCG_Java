package com.adobe.prj.orderapp.security.service;

import com.adobe.prj.orderapp.security.dao.UserDao;
import com.adobe.prj.orderapp.security.dto.SignInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    public String login(SignInDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

                var user = userDao.findByEmail(request.getEmail())
                        .orElseThrow(() -> new IllegalArgumentException("Invalid email/password"));
                var jwt = jwtService.generateTokenUtil(user);
                return jwt;
    }
}
