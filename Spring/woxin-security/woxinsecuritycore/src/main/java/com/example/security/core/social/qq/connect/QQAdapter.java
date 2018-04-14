package com.example.security.core.social.qq.connect;

import com.example.security.core.social.qq.api.QQ;
import com.example.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author: mengchen
 * Create by 18-4-12
 */
public class QQAdapter implements ApiAdapter<QQ> {



    /**
     * 判断请求是否成功
     * @param qq
     * @return
     */
    @Override
    public boolean test(QQ qq) {
        return true;
    }

    /**
     * 将服务提供商提供的用户信息设置到标准的用户信息上
     * @param api
     * @param values
     */
    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {

        QQUserInfo qqUserInfo = api.getUserInfo();
        // 设置显示用户名
        values.setDisplayName(qqUserInfo.getNickname());
        // 设置头像
        values.setImageUrl(qqUserInfo.getFigureurl_1());
        // qq没有个人主页，所以设置为空
        values.setProfileUrl(null);
        // 设置服务提供商的id , openId
        values.setProviderUserId(qqUserInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String s) {

    }
}
