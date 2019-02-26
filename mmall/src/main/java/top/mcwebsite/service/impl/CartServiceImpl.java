package top.mcwebsite.service.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mcwebsite.common.Const;
import top.mcwebsite.common.ResponseCodeEnum;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.dao.CartMapper;
import top.mcwebsite.dao.ProductMapper;
import top.mcwebsite.pojo.Cart;
import top.mcwebsite.pojo.Product;
import top.mcwebsite.service.CartService;
import top.mcwebsite.util.BigDecimalUtil;
import top.mcwebsite.util.PropertiesUtil;
import top.mcwebsite.vo.CartProductVO;
import top.mcwebsite.vo.CartVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author mengchen
 * @time 19-2-24 下午3:28
 */
@Service
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;

    private final ProductMapper productMapper;

    @Autowired
    public CartServiceImpl(CartMapper cartMapper, ProductMapper productMapper) {
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
    }

    @Override
    public ServerResponse<CartVO> add(Integer userId, Integer productId, Integer count) {
        if (productId == null || count == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartMapper.selectCartByUserIdProductId(userId, productId);

        if (cart == null) {
            Cart cartItem = new Cart();
            cartItem.setQuantity(count);
            cartItem.setChecked(Const.Cart.checked);
            cartItem.setProductId(productId);
            cartItem.setUserId(userId);
            int rawCount = cartMapper.insert(cartItem);
            if (rawCount <= 0) {
                return ServerResponse.createByErrorMessage("添加失败");
            }
        } else {
            count = cart.getQuantity() + count;
            cart.setQuantity(count);
            int rawCount = cartMapper.updateByPrimaryKeySelective(cart);
            if (rawCount <= 0) {
                return ServerResponse.createByErrorMessage("添加失败");
            }
        }
        return list(userId);
    }

    @Override
    public ServerResponse<CartVO> update(Integer userId, Integer productId, Integer count) {
        if (productId == null || count == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartMapper.selectCartByUserIdProductId(userId, productId);
        if (cart != null) {
            cart.setQuantity(count);
        } else {
            return ServerResponse.createByErrorMessage("在购物车中未找到该商品");
        }
        cartMapper.updateByPrimaryKeySelective(cart);
        return list(userId);
    }

    @Override
    public ServerResponse<CartVO> delete(Integer userId, String productIds) {
        List<String> productList = Splitter.on(",").splitToList(productIds);
        if (CollectionUtils.isEmpty(productList)) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        cartMapper.deleteByUserIdAndProductIds(userId, productList);
        return list(userId);
    }


    @Override
    public ServerResponse<CartVO> list(Integer userId) {
        CartVO cartVO = getCartVOLimit(userId);
        return ServerResponse.createBySuccess(cartVO);
    }

    @Override
    public ServerResponse<CartVO> selectOrUnselect(Integer userId, Integer checked, Integer productId) {
        cartMapper.checkedOrUncheckedProduct(userId, checked, productId);
        return list(userId);
    }

    @Override
    public ServerResponse<Integer> getCartProductCount(Integer userId) {
        if (userId == null) {
            return ServerResponse.createBySuccess(0);
        }

        return ServerResponse.createBySuccess(cartMapper.selectCartProductCount(userId));
    }

    private CartVO getCartVOLimit(Integer userId) {
        CartVO cartVO = new CartVO();
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        List<CartProductVO> cartProductVOList = Lists.newArrayList();

        BigDecimal cartTotalPrice = new BigDecimal("0");

        if (CollectionUtils.isNotEmpty(cartList)) {
            for (Cart cart : cartList) {
                CartProductVO cartProductVO = new CartProductVO();
                cartProductVO.setId(cart.getId());
                cartProductVO.setUserId(cart.getUserId());
                cartProductVO.setProductId(cart.getProductId());
                Product product = productMapper.selectByPrimaryKey(cart.getProductId());
                if (product != null) {
                    cartProductVO.setProductMainImage(product.getMainImage());
                    cartProductVO.setProductName(product.getName());
                    cartProductVO.setProductSubtitle(product.getSubtitle());
                    cartProductVO.setProductStatus(product.getStatus());
                    cartProductVO.setProductPrice(product.getPrice());
                    cartProductVO.setProductStock(product.getStock());
                    // 判断库存
                    int buyLimitCount = 0;
                    if (product.getStock() >= cart.getQuantity()) {
                        buyLimitCount = cart.getQuantity();
                        cartProductVO.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
                    } else {
                        buyLimitCount = product.getStock();
                        cartProductVO.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);

                        // 购物车中更新有效库存
                        Cart cartForQuantity = new Cart();
                        cartForQuantity.setId(cart.getId());
                        cartForQuantity.setQuantity(buyLimitCount);
                        cartMapper.updateByPrimaryKeySelective(cartForQuantity);
                    }
                    cartProductVO.setQuantity(buyLimitCount);
                    cartProductVO.setProductTotalPrice(BigDecimalUtil.mul(product.getPrice().doubleValue(), buyLimitCount));
                    cartProductVO.setProductChecked(cart.getChecked());
                }
                if (cart.getChecked() == Const.Cart.checked) {
                    cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(), cartProductVO.getProductTotalPrice().doubleValue());
                }
                cartProductVOList.add(cartProductVO);
            }
        }
        cartVO.setCartProductVOList(cartProductVOList);
        cartVO.setCartTotalPrice(cartTotalPrice);
        cartVO.setAllChecked(this.getAllCheckStatus(userId));
        cartVO.setImageHost(PropertiesUtil.getProperty("img.server"));
        return cartVO;
    }

    private boolean getAllCheckStatus(Integer userId) {
        if (userId == null) {
            return false;
        }

        return cartMapper.selectCartProductCheckedStatusByUserId(userId) == 0;
    }


}
