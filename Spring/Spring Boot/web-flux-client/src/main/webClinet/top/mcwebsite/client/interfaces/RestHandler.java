package top.mcwebsite.client.interfaces;

import top.mcwebsite.client.beans.MethodInfo;
import top.mcwebsite.client.beans.ServerInfo;

/**
 * Rest 请求调用handler
 * @author mengchen
 * @time 18-9-19 下午8:51
 */
public interface RestHandler {
    /**
     * 初始化服务器信息
     * @param serverInfo
     */
    public void init(ServerInfo serverInfo);

    /**
     * 调用rest请求，返回接口
     * @param methodInfo
     * @return
     */
    public Object invokeRest(MethodInfo methodInfo);
}
