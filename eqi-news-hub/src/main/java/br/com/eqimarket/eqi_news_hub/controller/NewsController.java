// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/controller/NewsController.java
package br.com.eqimarket.eqi_news_hub.controller;

import br.com.eqimarket.eqi_news_hub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public void fetchAndSaveNews() {
        newsService.fetchNews();
    }
}
