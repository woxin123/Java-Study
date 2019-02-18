package top.mcwebsite.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.mcwebsite.common.Const;
import top.mcwebsite.common.ResponseCodeEnum;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.pojo.Product;
import top.mcwebsite.pojo.User;
import top.mcwebsite.service.ProductService;
import top.mcwebsite.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author mengchen
 * @time 19-2-6 下午8:49
 */
@Controller
@RequestMapping("/manager/product")
public class ProductManageController {

    private final UserService userService;

    private final ProductService productService;

    @Autowired
    public ProductManageController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @RequestMapping("save.do")
    @ResponseBody
    public ServerResponse productSave(HttpSession session, Product product) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    "用户未登录，请登录管理员");
        }

        if (userService.checkAdminRole(user).isSuccess()) {
            return productService.saveOrUpdateProduct(product);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping("set_sale_status.do")
    @ResponseBody
    public ServerResponse setSaleStatus(HttpSession session, Integer productId, Integer status) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    "用户未登录，请登录管理员");
        }

        if (userService.checkAdminRole(user).isSuccess()) {
            return productService.setSaleStatus(productId, status);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse getDetail(HttpSession session, Integer productId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    "用户未登录，请登录管理员");
        }

        if (userService.checkAdminRole(user).isSuccess()) {
            return productService.manageProductDetial(productId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse getList(HttpSession session,
                                  @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    "用户未登录，请登录管理员");
        }

        if (userService.checkAdminRole(user).isSuccess()) {
            return productService.getProductList(pageNum, pageSize);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse productSearch(HttpSession session,
                                  String productName, String productId,
                                  @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(),
                    "用户未登录，请登录管理员");
        }

        if (userService.checkAdminRole(user).isSuccess()) {
//            return productService.getProductList(pageNum, pageSize);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

}
