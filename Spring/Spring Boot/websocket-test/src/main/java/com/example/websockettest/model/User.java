package com.example.websockettest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.Principal;

/**
 * @author mengchen
 * @time 18-9-23 下午1:46
 */
@Data
@AllArgsConstructor
public class User implements Principal {

    private String name;

    @Override
    public String getName() {
        return name;
    }
}
