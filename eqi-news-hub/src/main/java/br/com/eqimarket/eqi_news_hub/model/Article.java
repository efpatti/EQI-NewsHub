// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/model/Article.java
package br.com.eqimarket.eqi_news_hub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "news_id", nullable = false)
    private News news;

    private String title;
    private String content;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    // Getters e Setters
}
