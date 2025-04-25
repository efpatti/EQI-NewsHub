// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/exception/UserAlreadyExistsException.java
package br.com.eqimarket.eqi_news_hub.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}