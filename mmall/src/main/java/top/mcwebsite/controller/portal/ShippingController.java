package top.mcwebsite.controller.portal;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.mcwebsite.common.Const;
import top.mcwebsite.common.ResponseCodeEnum;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.pojo.Shipping;
import top.mcwebsite.pojo.User;
import top.mcwebsite.service.ShippingService;

import javax.servlet.http.HttpSession;

/**
 * @author mengchen
 * @time 19-2-26 下午4:52
 */
@RestController
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @RequestMapping("add.do")
    public ServerResponse add(HttpSession session, Shipping shipping) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }

        return shippingService.add(user.getId(), shipping);
    }

    @RequestMapping("del.do")
    public ServerResponse del(HttpSession session, Integer shippingId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }

        return shippingService.del(user.getId(), shippingId);
    }

    @RequestMapping("update.do")
    public ServerResponse update(HttpSession session, Shipping shipping) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }
        return shippingService.update(user.getId(), shipping);
    }

    @RequestMapping("select.do")
    public ServerResponse select(HttpSession session, Integer shippingId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }
        return shippingService.select(user.getId(), shippingId);
    }

    @RequestMapping("list.do")
    public ServerResponse<PageInfo> list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                         HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    ResponseCodeEnum.NEED_LOGIN.getDesc());
        }
        return shippingService.list(user.getId(), pageNum, pageSize);
    }

}
