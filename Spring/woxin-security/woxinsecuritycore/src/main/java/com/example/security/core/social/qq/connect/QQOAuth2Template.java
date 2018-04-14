package com.example.security.core.social.qq.connect;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;


/**
 * qq的auth2模版
 *
 * @author: mengchen
 * Create by 18-4-12
 */
public class QQOAuth2Template extends OAuth2Template {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl,  String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl,  accessTokenUrl);
        // 设置携带cliend_id
        setUseParametersForClientAuthentication(true);
    }


    /**
     * 对qq特殊的accessToken的响应进行处理
     * @param accessTokenUrl
     * @param parameters
     * @return
     */
    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl,
                                             MultiValueMap<String, String> parameters) {
        // 得到accessToken的响应字符串
        String reponseStr = getRestTemplate().patchForObject(accessTokenUrl, parameters, String.class);
        logger.info("获取accessToken的响应： " + reponseStr);

        String[] items = StringUtils.splitByWholeSeparator(reponseStr, "&");

        String accessToken = StringUtils.substringAfterLast(items[0], "=");
        Long expiresIn = new Long(StringUtils.substringAfterLast(items[1], "="));
        String refreshToken = StringUtils.substringAfterLast(items[2], "=");
        return new AccessGrant(accessToken, null, refreshToken, expiresIn);
    }

    @Override
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = super.createRestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }
}
