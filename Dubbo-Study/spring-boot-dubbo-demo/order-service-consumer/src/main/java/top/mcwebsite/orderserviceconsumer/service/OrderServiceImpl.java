package top.mcwebsite.orderserviceconsumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.gmall.bean.UserAddress;
import com.example.gmall.service.OrderService;
import com.example.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 1. 将服务提供者注册到注册中心
 *  1). 导入dubbo依赖
 * 2. 让服务消费者去注册中心订阅服务提供者的服务地址
 * @author mengchen
 * @time 18-12-16 下午8:51
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Reference(loadbalance = "roundrobin", timeout = 1000)
    private UserService userService;


    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        // 需要查询用户的收货地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        return userAddressList;
    }

    public List<UserAddress> hello(String userId) {
        // 需要查询用户的收货地址
        return Arrays.asList(new UserAddress(10, "测试地址", "测试", "测试","测试", "Y"));
    }
}
