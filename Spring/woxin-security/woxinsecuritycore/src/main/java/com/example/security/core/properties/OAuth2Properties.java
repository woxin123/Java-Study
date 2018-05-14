package com.example.security.core.properties;

/**
 * @author: mengchen
 * Create by 18-4-18
 */
public class OAuth2Properties {
    private String jwtSigingKey = "woxin";

    public String getJwtSigingKey() {
        return jwtSigingKey;
    }

    public void setJwtSigingKey(String jwtSigingKey) {
        this.jwtSigingKey = jwtSigingKey;
    }
}
