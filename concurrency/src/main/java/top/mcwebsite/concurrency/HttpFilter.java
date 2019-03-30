package top.mcwebsite.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import top.mcwebsite.concurrency.example.threadlocal.RequestHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author mengchen
 * @time 19-3-30 下午10:41
 */
@Slf4j
public class HttpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("do filter, {}, {}", Thread.currentThread().getId(), request.getServletPath());
        RequestHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
        RequestHolder.remove();
    }
}
