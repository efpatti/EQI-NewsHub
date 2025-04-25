// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/exception/UserNotFoundException.java
package br.com.eqimarket.eqi_news_hub.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}