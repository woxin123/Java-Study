package top.mcwebsite.client.resthandlers;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;
import top.mcwebsite.client.beans.MethodInfo;
import top.mcwebsite.client.beans.ServerInfo;
import top.mcwebsite.client.interfaces.RestHandler;

/**
 * @author mengchen
 * @time 18-9-19 下午9:21
 */
public class WebClientRestHandler implements RestHandler {

    private WebClient client;

    /**
     * 初始化webClient
     *
     * @param serverInfo
     */
    @Override
    public void init(ServerInfo serverInfo) {
        this.client = WebClient.create(serverInfo.getUrl());
    }

    /**
     * 处理rest请求
     *
     * @param methodInfo
     * @return
     */
    @Override
    public Object invokeRest(MethodInfo methodInfo) {
        Object result;
        RequestBodySpec request = client.method(methodInfo.getMethod())
                // 请求的url和参数
                .uri(methodInfo.getUrl(), methodInfo.getParams())
                .accept(MediaType.APPLICATION_JSON_UTF8);
        ResponseSpec retrieve = null;
        // 判断是否带了body
        if (methodInfo.getBody() != null) {
            retrieve = request.body(methodInfo.getBody(), methodInfo.getBodyElementType()).retrieve();
        } else {
            retrieve = request.retrieve();
        }

        // 异常处理
        retrieve.onStatus(status -> status.value() == 404,
                response -> Mono.just(new RuntimeException("Not Found")));

        if (methodInfo.isReturnFlux()) {
            result = retrieve.bodyToFlux(methodInfo.getReturnElementType());
        } else {
            result = retrieve.bodyToMono(methodInfo.getReturnElementType());
        }
        return result;
    }
}
