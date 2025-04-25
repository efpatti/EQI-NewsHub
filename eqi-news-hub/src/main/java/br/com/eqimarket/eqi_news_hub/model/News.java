// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/model/News.java
package br.com.eqimarket.eqi_news_hub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
    private String urlToImage;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    private String sourceName;

    // Getters e Setters
}
