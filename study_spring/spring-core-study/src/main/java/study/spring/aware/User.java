package study.spring.aware;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author mengchen
 * @time 19-3-19 上午8:13
 */
@Data
public class User implements BeanNameAware {

    private String id;
    private String name;
    private String address;

    @Override
    public void setBeanName(String name) {
        this.id = name;
    }
}
