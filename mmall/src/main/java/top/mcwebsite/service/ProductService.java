package top.mcwebsite.service;

import com.github.pagehelper.PageInfo;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.pojo.Product;
import top.mcwebsite.vo.ProductDetailVo;

/**
 * @author mengchen
 * @time 19-2-6 下午8:54
 */
public interface ProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId, Integer status);


    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategoryId(String keyword, Integer categoryId,
                                                           int pageNum, int pageSize, String orderBy);
}
