package io.projetos.deoliveiralimaigor.registroatividadesapi.response;

import lombok.Builder;

@Builder
public class TokenResponse {

    private String type;
    private String token;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    
}
