package com.example.security.core.properties;

/**
 * @author: mengchen
 * Create by 18-4-12
 */
public class SocialProperties {


    /**
     * 拦截社交登录过滤url
     */
    private String filterProcessesUrl = "/auth";


    /**
     * qq配置项
     */
    private QQProperties qq = new QQProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }
}
