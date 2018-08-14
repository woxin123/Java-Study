package top.mcwebsite.security.validator;

import org.springframework.beans.factory.annotation.Autowired;
import top.mcwebsite.security.service.HelloService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 实现javax的ConstraintValidator接口，第一个泛型是校验的注解，第二个是需要校验的类型
 * Spring 会自动将实现了ConstraintValidator的类注册称为bean
 * @author mengchen
 */
public class MyContraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HelloService helloService;

    /**
     * 初始化的时候
     */
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }

    /**
     *
     * @param o 校验的值
     * @param constraintValidatorContext 校验的上下文 包含注解中的值
     * @return true 校验成功 false 校验失败
     */
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("tom");
        System.out.println(o);
        return false;
    }
}
