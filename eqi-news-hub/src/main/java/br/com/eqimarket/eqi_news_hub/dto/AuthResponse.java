// eqi-news-hub/src/main/java/br/com/eqimarket/eqi_news_hub/dto/LoginRequest.java
package br.com.eqimarket.eqi_news_hub.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private String username;
    private String role;
}