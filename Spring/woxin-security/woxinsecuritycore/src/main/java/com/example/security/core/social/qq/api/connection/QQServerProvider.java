package com.example.security.core.social.qq.api.connection;

import com.example.security.core.social.qq.api.QQ;
import com.example.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;

public class QQServerProvider extends AbstractOAuth2ServiceProvider<QQ>{

    public QQServerProvider(OAuth2Operations oauth2Operations) {
        super(oauth2Operations);
    }

    @Override
    public QQ getApi(String s) {
        return new QQImpl();
    }
}
