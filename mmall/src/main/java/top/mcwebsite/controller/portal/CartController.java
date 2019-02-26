package top.mcwebsite.controller.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.mcwebsite.common.Const;
import top.mcwebsite.common.ResponseCodeEnum;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.pojo.User;
import top.mcwebsite.service.CartService;
import top.mcwebsite.vo.CartVO;

import javax.servlet.http.HttpSession;

/**
 * @author mengchen
 * @time 19-2-24 下午3:25
 */
@RestController
@RequestMapping("/cart/")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("list.do")
    public ServerResponse<CartVO> list(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }

        return cartService.list(user.getId());
    }

    @RequestMapping("add.do")
    public ServerResponse<CartVO> add(HttpSession session, Integer count, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }

        return cartService.add(user.getId(), productId, count);
    }


    @RequestMapping("update.do")
    public ServerResponse<CartVO> update(HttpSession session, Integer count, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }

       return cartService.update(user.getId(), productId, count);
    }

    @RequestMapping("delete.do")
    public ServerResponse<CartVO> delete(HttpSession session, String productIds) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }

        return cartService.delete(user.getId(), productIds);
    }

    @RequestMapping("select_all.do")
    public ServerResponse<CartVO> selectAll(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }

        return cartService.selectOrUnselect(user.getId(), Const.Cart.checked, null);
    }

    @RequestMapping("un_select_all.do")
    public ServerResponse<CartVO> unSelectAll(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }
        return cartService.selectOrUnselect(user.getId(), Const.Cart.unChecked, null);
    }


    @RequestMapping("select.do")
    public ServerResponse<CartVO> select(HttpSession session, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }

        return cartService.selectOrUnselect(user.getId(), Const.Cart.checked, productId);
    }

    @RequestMapping("un_select.do")
    public ServerResponse<CartVO> unSelect(HttpSession session,Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }
        return cartService.selectOrUnselect(user.getId(), Const.Cart.unChecked, productId);
    }


    @RequestMapping("get_cart_product_count.do")
    public ServerResponse<Integer> getCartProductCount(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createBySuccess(0);
        }
        return cartService.getCartProductCount(user.getId());
    }

}
