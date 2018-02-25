package com.example.validation;

import com.example.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Repository("userValidator")
public class UserValidation implements Validator {
    // 该校验器能够对Class类型的对象进行校验
    @Override
    public boolean supports(Class<?> clazz) {
        // 判定此 Class 对象所表示的类或接口与指定的 Class 参数所表示的类或接口是否相同，
        // 或是否是其超类或超接口。如果是则返回 true；否则返回 false
        return User.class.isAssignableFrom(clazz);
    }

    // 对目标类型target进行校验,并将校验错误封装到errors中
    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 使用ValidationUtils中的一个静态的方法rejectEmpty对loginname，如果loginname为空的话，则验证不通过
         */
        ValidationUtils.rejectIfEmpty(errors, "loginname", null, "登录名不能为空");
        ValidationUtils.rejectIfEmpty(errors, "password", null,"密码不能为空");
        User user = (User) target;
        if (user.getLoginname().length() > 10) {
            // errors的rejectValue()方法进行验证
            errors.rejectValue("loginname", null, "用户名长度不能超过10");
        }
        if (user.getPassword() != null && !user.getPassword().equals("")
                && user.getPassword().length() < 6) {
            errors.rejectValue("password", null,"密码长度不能少于6为");
        }
    }
}
