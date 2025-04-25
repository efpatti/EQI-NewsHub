// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/service/NewsService.java
package br.com.eqimarket.eqi_news_hub.service;

import br.com.eqimarket.eqi_news_hub.model.News;
import br.com.eqimarket.eqi_news_hub.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    private final String API_KEY = "435807b5a14b4b8aab32ffa73629fc02";
    private final String NEWS_API_URL = "https://newsapi.org/v2/top-headlines?category=business&language=pt&apiKey=" + API_KEY;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void fetchNews() {
        // Consumindo a API externa
        News[] newsArray = restTemplate.getForObject(NEWS_API_URL, News[].class);

        if (newsArray != null) {
            for (News newsItem : newsArray) {
                // Processar e salvar as notícias no banco de dados
                newsRepository.save(newsItem);
            }
        }
    }
}
