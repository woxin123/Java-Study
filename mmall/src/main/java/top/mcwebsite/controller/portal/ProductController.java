package top.mcwebsite.controller.portal;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.pojo.Product;
import top.mcwebsite.service.ProductService;
import top.mcwebsite.vo.ProductDetailVo;

/**
 * @author mengchen
 * @time 19-2-23 下午9:34
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId) {
        return productService.getProductDetail(productId);
    }

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                         @RequestParam(required = false, defaultValue = "1") int pageNum,
                                         @RequestParam(required = false, defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy",required = false, defaultValue = "") String orderBy) {
        return productService.getProductByKeywordCategoryId(keyword, categoryId, pageNum, pageSize, orderBy);
    }


}
