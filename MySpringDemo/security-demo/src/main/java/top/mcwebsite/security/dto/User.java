package top.mcwebsite.security.dto;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * mengchen
 * 18-7-17 下午11:13
 */
public class User {

    public interface UserSimpleView {}
    public interface UserDetialView extends UserSimpleView {}

    private String id;

    private String username;

    @NotBlank
    @Valid
    private String password;

    @Past
    private Date birthday;


    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetialView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
