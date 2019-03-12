package top.mcwebsite.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.dao.ShippingMapper;
import top.mcwebsite.pojo.Shipping;
import top.mcwebsite.service.ShippingService;

import java.util.List;
import java.util.Map;

/**
 * @author mengchen
 * @time 19-2-26 下午4:53
 */
@Service
public class ShippingServiceImpl implements ShippingService {

    private final ShippingMapper shippingMapper;

    @Autowired
    public ShippingServiceImpl(ShippingMapper shippingMapper) {
        this.shippingMapper = shippingMapper;
    }

    @Override
    public ServerResponse add(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        int rawCount = shippingMapper.insert(shipping);
        if (rawCount > 0) {
            Map<String, Integer> map = Maps.newHashMap();
            map.put("shippingId", shipping.getId());
            return ServerResponse.createBySuccess("新建地址成功", map);
        }
        return ServerResponse.createByErrorMessage("新建地址失败");
    }

    @Override
    public ServerResponse<String> del(Integer userId, Integer shippingId) {
        int rawCount = shippingMapper.deleteByShippingIdAndUserId(userId, shippingId);
        if (rawCount > 0) {
            return ServerResponse.createBySuccess("删除地址成功");
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }

    @Override
    public ServerResponse update(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        int rawCount = shippingMapper.updateByShipping(shipping);
        if (rawCount > 0) {
            return ServerResponse.createBySuccess("更新地址成功");
        }
        return ServerResponse.createByErrorMessage("更新地址失败");
    }

    @Override
    public ServerResponse<Shipping> select(Integer userId, Integer shippingId) {
        Shipping shipping = shippingMapper.selectByShippingIdAndUserId(userId, shippingId);
        if (shipping == null) {
            return ServerResponse.createByErrorMessage("查询不到该收货地址");
        }
        return ServerResponse.createBySuccess(shipping);
    }

    @Override
    public ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
