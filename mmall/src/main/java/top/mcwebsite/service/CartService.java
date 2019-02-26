package top.mcwebsite.service;

import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.vo.CartVO;

/**
 * @author mengchen
 * @time 19-2-24 下午3:28
 */
public interface CartService {
    ServerResponse<CartVO> add(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVO> update(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVO> delete(Integer userId, String productIds);

    ServerResponse<CartVO> list(Integer userId);

    ServerResponse<CartVO> selectOrUnselect(Integer userId, Integer checked, Integer productId);

    ServerResponse<Integer> getCartProductCount(Integer userId);
}
