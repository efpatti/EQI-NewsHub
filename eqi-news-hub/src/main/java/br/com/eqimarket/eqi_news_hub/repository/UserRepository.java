// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/service/UserRepository.java
package br.com.eqimarket.eqi_news_hub.repository;

import br.com.eqimarket.eqi_news_hub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
