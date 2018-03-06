package com.example.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

// 实现Serializable接口，以便JVM可以序列化PO实例
public class BaseDomain implements Serializable {
    // 统一的toString接口
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
