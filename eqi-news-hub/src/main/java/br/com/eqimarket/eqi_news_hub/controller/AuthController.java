// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/controller/AuthController.java
package br.com.eqimarket.eqi_news_hub.controller;

import br.com.eqimarket.eqi_news_hub.dto.AuthResponse;
import br.com.eqimarket.eqi_news_hub.dto.LoginRequest;
import br.com.eqimarket.eqi_news_hub.dto.RegisterRequest;
import br.com.eqimarket.eqi_news_hub.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}

