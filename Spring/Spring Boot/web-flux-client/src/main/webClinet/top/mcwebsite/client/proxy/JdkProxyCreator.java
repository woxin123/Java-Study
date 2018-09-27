package top.mcwebsite.client.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.mcwebsite.client.ApiServer;
import top.mcwebsite.client.beans.MethodInfo;
import top.mcwebsite.client.beans.ServerInfo;
import top.mcwebsite.client.interfaces.ProxyCreator;
import top.mcwebsite.client.interfaces.RestHandler;
import top.mcwebsite.client.resthandlers.WebClientRestHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用JDk动态代理实现代理类
 *
 * @author mengchen
 * @time 18-9-19 下午8:36
 */
@Slf4j
public class JdkProxyCreator implements ProxyCreator {
    @Override
    public Object createProxy(Class<?> type) {
        log.info("creteProxy" + type);
        // 通过接口得到API服务器
        ServerInfo serverInfo = extractServerInfo(type);

        log.info("serverInfo:" + serverInfo);

        // 给每一个代理类创建一个实例
        RestHandler handler = new WebClientRestHandler();
        // 初始化服务器信息
        handler.init(serverInfo);
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{type}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 根据方法和参数得到调用信息
                        MethodInfo methodInfo = extractMethodInfo(method, args);
                        log.info("methodInfo:" + methodInfo);

                        // 调用rest
                        return handler.invokeRest(methodInfo);

                    }

                    /**
                     * 根据方法定义和调用参数得到相关信息
                     * @param method
                     * @param args
                     * @return
                     */
                    private MethodInfo extractMethodInfo(Method method, Object[] args) {
                        MethodInfo methodInfo = new MethodInfo();

                        extractUrlAndMethod(method, methodInfo);

                        extractRequestParamAndBody(method, args, methodInfo);
                        extractRequestParamAndBody(method, args, methodInfo);

                        // 提取返回对象信息
                        extractReutrnInfo(method, methodInfo);

                        return methodInfo;
                    }

                    private void extractReutrnInfo(Method method, MethodInfo methodInfo) {
                        // 返回Flux还是Mono
                        // isAssignableFrom判断类型是某个的子类
                        // instaceof 判断实例是否是某个的子类
                        boolean isFlux = method.getReturnType().isAssignableFrom(Flux.class);
                        methodInfo.setReturnFlux(isFlux);

                        // 得到返回对象的实际类型
                        Class<?> elementType = extractElementType(method.getGenericReturnType());
                        methodInfo.setReturnElementType(elementType);
                    }

                    /**
                     * 得到泛型类型的实际类型
                     * @param genericReturnType
                     * @return
                     */
                    private Class<?> extractElementType(Type genericReturnType) {
                        Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
                        return (Class<?>) actualTypeArguments[0];
                    }

                    /**
                     * 得到请求的param和body
                     * @param method
                     * @param args
                     * @param methodInfo
                     */
                    private void extractRequestParamAndBody(Method method, Object[] args, MethodInfo methodInfo) {
                        // 得到调用的参数和body
                        Parameter[] parameters = method.getParameters();
                        // 参数和值对应的Map
                        Map<String, Object> params = new LinkedHashMap<>();
                        methodInfo.setParams(params);
                        for (int i = 0; i < parameters.length; i++) {
                            // 是否带有@PathVariable
                            PathVariable annoPath = parameters[i].getAnnotation(PathVariable.class);
                            if (annoPath != null) {
                                params.put(annoPath.value(), args[i]);
                            }
                            // 是否带有RequestBody
                            RequestBody annoBody = parameters[i].getAnnotation(RequestBody.class);

                            if (annoBody != null) {
                                methodInfo.setBody((Mono<?>) args[i]);
                                methodInfo.setBodyElementType(extractElementType(parameters[i].getParameterizedType()));
                            }
                        }
                    }

                    /**
                     * 得到请求的方法和URL
                     * @param method
                     * @param methodInfo
                     */
                    private void extractUrlAndMethod(Method method, MethodInfo methodInfo) {

                        //得到请求的URL和请求方法
                        Annotation[] annotations = method.getAnnotations();
                        for (Annotation annotation : annotations) {
                            // GET
                            if (annotation instanceof GetMapping) {
                                GetMapping a = (GetMapping) annotation;
                                methodInfo.setUrl(a.value()[0]);
                                methodInfo.setMethod(HttpMethod.GET);
                            }
                            // POST
                            if (annotation instanceof PostMapping) {
                                PostMapping a = (PostMapping) annotation;
                                methodInfo.setUrl(a.value()[0]);
                                methodInfo.setMethod(HttpMethod.POST);
                            }
                            // Put
                            if (annotation instanceof PutMapping) {
                                PutMapping a = (PutMapping) annotation;
                                methodInfo.setUrl(a.value()[0]);
                                methodInfo.setMethod(HttpMethod.PUT);
                            }
                            // Delete
                            if (annotation instanceof DeleteMapping) {
                                DeleteMapping a = (DeleteMapping) annotation;
                                methodInfo.setUrl(a.value()[0]);
                                methodInfo.setMethod(HttpMethod.DELETE);
                            }
                        }
                    }
                });
    }

    private ServerInfo extractServerInfo(Class<?> type) {
        ServerInfo serverInfo = new ServerInfo();
        ApiServer annotation = type.getAnnotation(ApiServer.class);
        serverInfo.setUrl(annotation.value());

        return serverInfo;
    }
}
