package com.example.oauth2jwt.oath2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author: mengchen
 * Create by 18-4-23
 */
@Configuration
@EnableAuthorizationServer
public class WoxinAuthorization extends AuthorizationServerConfigurerAdapter {

    @Autowired


}
