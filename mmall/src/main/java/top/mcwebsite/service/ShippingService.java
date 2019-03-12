package top.mcwebsite.service;

import com.github.pagehelper.PageInfo;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.pojo.Shipping;

/**
 * @author mengchen
 * @time 19-2-26 下午4:53
 */
public interface ShippingService {
    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse<String> del(Integer userId, Integer shippingId);

    ServerResponse update(Integer userId, Shipping shipping);

    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
