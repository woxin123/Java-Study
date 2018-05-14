package com.example.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author: mengchen
 * Create by 18-4-12
 */
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
