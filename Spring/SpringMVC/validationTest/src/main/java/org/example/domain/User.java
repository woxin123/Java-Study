package org.example.domain;



import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    @NotBlank
    private String loginname;
    @NotBlank
    @Length(min = 6, max = 8)
    private String password;
    @NotBlank
    private String username;
    @Range(min = 15, max = 60)
    private int age;
    @Email
    private String emial;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date birthday;
    @Pattern(regexp = "[1][3, 8][3, 6, 9][0-9]{8}")
    private String phone;

    public User() {
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
