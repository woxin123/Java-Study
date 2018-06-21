package top.mcwebsite.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG = "world";

    private String msg = MSG;

    public String getMSG() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
