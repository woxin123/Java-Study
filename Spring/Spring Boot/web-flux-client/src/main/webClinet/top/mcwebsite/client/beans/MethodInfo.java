package top.mcwebsite.client.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 方法调用信息类
 * @author mengchen
 * @time 18-9-19 下午8:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MethodInfo {

    /**
     * 请求url
     */
    private String url;

    /**
     * 请求方法
     */
    private HttpMethod method;

    /**
     * 请求参数（url）
     */
    private Map<String, Object> params;

    /**
     * 请求body
     */
    private Mono body;

    /**
     * 返回对象的类型
     */
    private Class<?> returnElementType;

    /**
     * 返回的是flux还是mono
     */
    private boolean returnFlux;


    private  Class<?> bodyElementType;

}
