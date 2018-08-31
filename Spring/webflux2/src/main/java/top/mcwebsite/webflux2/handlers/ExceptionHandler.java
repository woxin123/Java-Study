package top.mcwebsite.webflux2.handlers;

import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;
import top.mcwebsite.webflux2.exception.CheckException;

/**
 * @author mengchen
 * @time 18-8-24 下午10:05
 */
@Component
@Order(-2)
public class ExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse response = exchange.getResponse();

        response.setStatusCode(HttpStatus.BAD_REQUEST);

        // 设置返回类型
        response.getHeaders().setContentType(MediaType.TEXT_PLAIN);

        // 异常信息
        String errorMsg = toStr(ex);

        DataBuffer db = response.bufferFactory().wrap(errorMsg.getBytes());

        return response.writeWith(Mono.just(db));
    }

    private String toStr(Throwable ex) {
        // 一致异常
        if (ex instanceof CheckException) {
            CheckException e = (CheckException) ex;
            return e.getFieldName() + ":invalid Value " + e.getFieldValue();
        }
        // 未知异常，需要打印堆栈，方便定位
        else {
            ex.printStackTrace();
            return ex.toString();
        }
    }
}
