// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/service/NewsRepository.java
package br.com.eqimarket.eqi_news_hub.repository;

import br.com.eqimarket.eqi_news_hub.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
