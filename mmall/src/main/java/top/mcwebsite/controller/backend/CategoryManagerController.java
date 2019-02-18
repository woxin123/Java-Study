package top.mcwebsite.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.mcwebsite.common.Const;
import top.mcwebsite.common.ResponseCodeEnum;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.pojo.User;
import top.mcwebsite.service.CategoryService;
import top.mcwebsite.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author mengchen
 * @time 18-12-4 下午7:29
 */
@Controller
@RequestMapping("manage/category")
public class CategoryManagerController {

    private final UserService userService;

    private final CategoryService categoryService;

    @Autowired
    public CategoryManagerController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @RequestMapping("add_category.do")
    @ResponseBody
    public ServerResponse addCategory(HttpSession session, String categoryName,
                                      @RequestParam(value = "parentId", defaultValue = "0") int parentId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), "用户未登录，请登录");
        }

        // 校验是否是管理员
        if (userService.checkAdminRole(user).isSuccess()) {
            // 添加分类的逻辑
            return categoryService.addCatetgory(categoryName, parentId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping("set_category_name.do")
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession session, Integer categoryId, String categoryName) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), "用户未登录，请登录");
        }

        if (userService.checkAdminRole(user).isSuccess()) {
            // 更新categoryName
            return categoryService.updateCategoryName(categoryId, categoryName);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping("get_category.do")
    @ResponseBody
    public ServerResponse getChildParallelCategory(HttpSession session,
                                                   @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), "用户未登录，请登录");
        }

        if (userService.checkAdminRole(user).isSuccess()) {
            // 查询子节点的category信息，并且无递归
            return categoryService.getChildParallelCategory(categoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping("get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session,@RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.NEED_LOGIN.getCode(), "用户未登录，请登录");
        }

        if (userService.checkAdminRole(user).isSuccess()) {
            // 查询当前节点的id和递归子节点的id
            return categoryService.selectCategoryAndChildrenById(categoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

}
