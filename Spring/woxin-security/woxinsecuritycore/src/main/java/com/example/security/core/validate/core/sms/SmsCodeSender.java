package com.example.security.core.validate.core.sms;

public interface SmsCodeSender {

    void send(String mobile, String code);
}
