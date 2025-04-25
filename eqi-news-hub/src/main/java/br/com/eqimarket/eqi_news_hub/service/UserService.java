// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/service/UserService.java
package br.com.eqimarket.eqi_news_hub.service;

import br.com.eqimarket.eqi_news_hub.model.User;
import br.com.eqimarket.eqi_news_hub.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username)
               .orElseThrow(() -> new RuntimeException("Usuário não autenticado"));
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        existingUser.setUsername(updatedUser.getUsername());
        // Adicione outros campos atualizáveis conforme necessário
        return userRepository.save(existingUser);
    }
}
