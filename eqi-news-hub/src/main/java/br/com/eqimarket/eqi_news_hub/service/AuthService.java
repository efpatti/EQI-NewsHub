// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/security/AuthService.java
package br.com.eqimarket.eqi_news_hub.service;

import br.com.eqimarket.eqi_news_hub.dto.AuthResponse;
import br.com.eqimarket.eqi_news_hub.dto.LoginRequest;
import br.com.eqimarket.eqi_news_hub.dto.RegisterRequest;
import br.com.eqimarket.eqi_news_hub.exception.UserAlreadyExistsException;
import br.com.eqimarket.eqi_news_hub.exception.UserNotFoundException;
import br.com.eqimarket.eqi_news_hub.model.User;
import br.com.eqimarket.eqi_news_hub.model.Role;
import br.com.eqimarket.eqi_news_hub.repository.UserRepository;
import br.com.eqimarket.eqi_news_hub.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;

    public ResponseEntity<AuthResponse> register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username já está em uso");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        
        return ResponseEntity.ok(new AuthResponse(token, user.getUsername(), user.getRole().name()));
    }

    public ResponseEntity<AuthResponse> login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
                )
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credenciais inválidas");
        }

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        
        return ResponseEntity.ok(new AuthResponse(token, user.getUsername(), user.getRole().name()));
    }
}