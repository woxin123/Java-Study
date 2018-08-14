package top.mcwebsite.moreThread.study;

import top.mcwebsite.moreThread.study.annotation.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * @author mengchen
 * @time 18-7-30 上午11:32
 */
@ThreadSafe
public class StatlessFactorizer extends GenericServlet implements Servlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        // 从请求中获取参数
        BigInteger i = extractFromRequest(req);
        // 计算
        BigInteger[] factors = factor(i);
        // 写入响应
        encodeIntoResponse(resp, factors);
    }


    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }

}
