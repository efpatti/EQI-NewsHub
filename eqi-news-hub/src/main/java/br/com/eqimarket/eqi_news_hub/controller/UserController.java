// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/controller/UserController.java
package br.com.eqimarket.eqi_news_hub.controller;

import br.com.eqimarket.eqi_news_hub.model.User;
import br.com.eqimarket.eqi_news_hub.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/me")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PutMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
}