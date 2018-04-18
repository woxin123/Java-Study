package com.example.security.core.validate.core;

import com.example.security.core.properties.SecurityConstants;
import com.example.security.core.properties.SecurityProperties;
import com.example.security.core.validate.core.image.ImageCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


// 实现这个接口的作用是在其他组件初始化完毕之后初始化urls
@Component("validateCodeFilter")
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    /**
     * 验证码校验失败的处理器
     */
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 系统配置信息
     */
    @Autowired
    private SecurityProperties securityProperties;


    /**
     * 系统中校验码的处理器
     */
    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    /**
     * 存放所有需要验证码的url
     */
    private Map<String, ValidateCodeType> urlMap = new HashMap();


    /**
     * 验证请求url与配置url是否匹配的工具类
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 初始化要拦截的url配置信息
     *
     * @throws ServletException
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM, ValidateCodeType.IMAGE);
        addUrlToMap(securityProperties.getCode().getImage().getUrl(), ValidateCodeType.IMAGE);

        urlMap.put(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE, ValidateCodeType.SMS);
        addUrlToMap(securityProperties.getCode().getSms().getUrl(), ValidateCodeType.SMS);


    }

    protected void addUrlToMap(String urlString, ValidateCodeType type) {
        if (StringUtils.isNotBlank(urlString)) {
            String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(urlString, ",");
            for (String url : urls) {
                urlMap.put(url, type);
            }
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        ValidateCodeType type = getVlidateCodeType(request);
        if (type != null) {
            try {
                validateCodeProcessorHolder.findValidateCodeProcessor(type)
                        .validate(new ServletWebRequest(request, response));
                logger.info("验证码通过");
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    private ValidateCodeType getVlidateCodeType(HttpServletRequest request) {
        ValidateCodeType result = null;
        /**
         * 方法必须是get
         * 通过url获得类型
         */
        if (!StringUtils.equals(request.getMethod(), "get")) {
            Set<String> urls = urlMap.keySet();
            for (String url : urls) {
                if (pathMatcher.match(url, request.getRequestURI())) {
                    result = urlMap.get(url);
                }
            }
        }
        return result;
    }
}
