package top.mcwebsite.springbootcache.domain;

import lombok.*;

import java.io.Serializable;

/**
 * @author mengchen
 * @time 18-10-7 下午2:07
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private String userId;
    private String userName;
    private int age;

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
