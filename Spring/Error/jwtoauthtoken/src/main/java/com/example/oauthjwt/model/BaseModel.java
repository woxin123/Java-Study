package com.example.oauthjwt.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BaseModel implements Serializable{

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
