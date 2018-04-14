package com.example.security.core.properties;

/**
 * @author: mengchen
 * Create by 18-4-13
 */
public interface SecurityConstants {

    /**
     * 默认处理验证码的url前缀
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 当请求需要身份验证时，默认跳转的url
     *
     * @see SecurityController
     */
    String DEFAULT_UNAUTHENTICATTION_URL = "/authenticaion/require";

    /**
     * 默认用户名密码处理的url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authenticaion/form";

    /**
     * 默认手机验证码登录请求的url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authenticaion/mobile";

    /**
     * 默认登录页面
     *
     * @see SecurityController
     */
    String DEFAULT_LOGIN_PAGE_URL = "woxin-signIn.html";

    /**
     * 验证图形验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";

    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";

    /**
     * 发送短信验证码或短信验证码验证时，传递手机号的参数名称
     */
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";

    /**
     * session失效默认跳转的地址
     */
    String DEFAULT_SESSION_INVALID_URL = "/session/invalid";

    /**
     * openId参数名
     */
    String DEFAULT_PARAMETER_OPENID = "openId";

    /**
     * providerId参数名
     */
    String DEFAULT_PARAMETER_NAME_PROVIDERID = "providerId";

    /**
     * 默认的OPENID登录请求处理的url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_OPENID = "/authentication/openid";

    /**
     * 获取第三方用户信息的url
     */
    String DEFAULT_SOCIAL_USER_INFO_URL = "/social/user";


}
