package com.example.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author: mengchen
 * Create by 18-4-16
 */
public class WoxinSpringSocialConfigurer extends SpringSocialConfigurer {


    private String filterProcessesUrl;

    public WoxinSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);

        return (T) filter;
    }
}
