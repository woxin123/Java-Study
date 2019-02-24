package top.mcwebsite.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import top.mcwebsite.common.Const;
import top.mcwebsite.common.ResponseCodeEnum;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.dao.CategoryMapper;
import top.mcwebsite.dao.ProductMapper;
import top.mcwebsite.pojo.Category;
import top.mcwebsite.pojo.Product;
import top.mcwebsite.service.CategoryService;
import top.mcwebsite.service.ProductService;
import top.mcwebsite.util.DateTimeUtil;
import top.mcwebsite.util.PropertiesUtil;
import top.mcwebsite.vo.ProductDetailVo;
import top.mcwebsite.vo.ProductListVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchen
 * @time 19-2-6 下午8:54
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    private final CategoryMapper categoryMapper;

    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, CategoryMapper categoryMapper, CategoryService categoryService) {
        this.productMapper = productMapper;
        this.categoryMapper = categoryMapper;
        this.categoryService = categoryService;
    }

    @Override
    public ServerResponse saveOrUpdateProduct(Product product) {
        if (product != null) {
            if (StringUtils.isNotBlank(product.getSubImages())) {
                String[] subImageArray = product.getSubImages().split(",");
                if (subImageArray.length > 0) {
                    product.setMainImage(subImageArray[0]);
                }
            }

            if (product.getId() != null) {
                int rowCount = productMapper.updateByPrimaryKeySelective(product);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccessMessage("更新产品成功");
                } else {
                    return ServerResponse.createByErrorMessage("更新产品失败");
                }
            } else {
                int rowCount = productMapper.insert(product);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccessMessage("新增产品成功");
                } else {
                    return ServerResponse.createByErrorMessage("新增产品失败");
                }
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新产品参数不正确");

    }

    @Override
    public ServerResponse<String> setSaleStatus(Integer productId, Integer status) {
        if (productId == null || status == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }

        Product product = new Product();
        product.setId(productId);
        product.setStatus(status);
        int rowCount = productMapper.updateByPrimaryKeySelective(product);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("修改产品销售状态成功");
        }

        return ServerResponse.createByErrorMessage("修改产品销售状态失败");
    }

    @Override
    public ServerResponse<ProductDetailVo> manageProductDetail(Integer productId) {
        if (productId == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }

        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            return ServerResponse.createBySuccessMessage("产品以下架或删除");
        }
        ProductDetailVo productDetailVo = assembleProductDetialVo(product);
        return ServerResponse.createBySuccess(productDetailVo);
    }

    private ProductDetailVo assembleProductDetialVo(Product product) {
        ProductDetailVo productDetialVo = new ProductDetailVo();
        productDetialVo.setId(product.getId());
        productDetialVo.setSubtitle(product.getSubtitle());
        productDetialVo.setPrice(product.getPrice());
        productDetialVo.setMainImage(product.getMainImage());
        productDetialVo.setSubImages(product.getSubImages());
        productDetialVo.setCategoryId(product.getCategoryId());
        productDetialVo.setDetail(product.getDetail());
        productDetialVo.setName(product.getName());
        productDetialVo.setStock(product.getStock());
        productDetialVo.setStatus(product.getStatus());

        productDetialVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix", "http://img.mcwebsite.top:83"));

        Category category = categoryMapper.selectByPrimaryKey(product.getCategoryId());
        if (category == null) {
            productDetialVo.setParentCatagoryId(0);
        } else {
            productDetialVo.setParentCatagoryId(category.getParentId());
        }

        productDetialVo.setCreateTime(DateTimeUtil.dateToString(product.getCreateTime()));
        productDetialVo.setUpdateTime(DateTimeUtil.dateToString(product.getUpdateTime()));
        return productDetialVo;

    }

    @Override
    public ServerResponse<PageInfo> getProductList(int pageNum, int pageSize) {
        // startPage
        // 填充自己的查询逻辑
        // pagehelp收尾
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productMapper.selectList();

        List<ProductListVO> productListVOList = new ArrayList<>();
        for (Product product : products) {
            ProductListVO productListVO = assembleProductListVO(product);
            productListVOList.add(productListVO);
        }
        PageInfo pageInfo = new PageInfo<>(products);
        pageInfo.setList(productListVOList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    private ProductListVO assembleProductListVO(Product product) {
        ProductListVO productListVO = new ProductListVO();
        productListVO.setId(product.getId());
        productListVO.setName(product.getName());
        productListVO.setCategoryId(product.getCategoryId());
        productListVO.setMainImage(product.getMainImage());
        productListVO.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix", "http://img.mcwebsite.top:83"));
        productListVO.setPrice(product.getPrice());
        productListVO.setSubtitle(product.getSubtitle());
        productListVO.setStatus(product.getStatus());

        return productListVO;
    }

    @Override
    public ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isNotBlank(productName)) {
            productName = new StringBuilder().append("%").append(productName).append("%").toString();
        }
        List<Product> productList = productMapper.selectByNameAndProductId(productName, productId);
        List<ProductListVO> productListVOList = new ArrayList<>();
        for (Product product : productList) {
            ProductListVO productListVO = assembleProductListVO(product);
            productListVOList.add(productListVO);
        }
        PageInfo pageInfo = new PageInfo<>(productList);
        pageInfo.setList(productListVOList);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<ProductDetailVo> getProductDetail(Integer productId) {
        if (productId == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }

        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            return ServerResponse.createBySuccessMessage("产品以下架或删除");
        }
        if (product.getStatus() != Const.ProductStatusEnum.ON_SALE.getCode()) {
            return ServerResponse.createByErrorMessage("产品已经下架或删除");
        }
        ProductDetailVo productDetailVo = assembleProductDetialVo(product);
        return ServerResponse.createBySuccess(productDetailVo);
    }

    @Override
    public ServerResponse<PageInfo> getProductByKeywordCategoryId(String keyword, Integer categoryId,
                                                                  int pageNum, int pageSize, String orderBy) {
        if (StringUtils.isBlank(keyword) && categoryId == null) {
            return ServerResponse.createErrorByCodeMessage(ResponseCodeEnum.ILLEGAL_ARGUMENT.getCode(),
                    ResponseCodeEnum.ILLEGAL_ARGUMENT.getDesc());
        }
        List<Integer> categoryIdList = new ArrayList<>();

        if (categoryId != null) {
            Category category = categoryMapper.selectByPrimaryKey(categoryId);
            if (category == null && StringUtils.isBlank(keyword)) {
                // 没有分类，并且没有关键字，这个时候返回一个空的结果集，不报错
                PageHelper.startPage(pageNum, pageSize);
                List<ProductDetailVo> productDetailVos = new ArrayList<>();
                PageInfo pageInfo = new PageInfo(productDetailVos);
                return ServerResponse.createBySuccess(pageInfo);
            }
            categoryIdList = categoryService.selectCategoryAndChildrenById(categoryId).getData();
        }
        if (StringUtils.isNotBlank(keyword)) {
            keyword = "%" + keyword + "%";
        }

        PageHelper.startPage(pageNum, pageSize);
        // 排序处理

        if (StringUtils.isNotBlank(orderBy)) {
            if (Const.ProductListOrderBy.PRICE_ASC_DESC.contains(orderBy)) {
                String[] orderByArray = orderBy.split("_");
                PageHelper.orderBy(orderByArray[0] + " " + orderByArray[1]);
            }
        }

        List<Product> productList = productMapper.selectByNameAndCategoryIds(StringUtils.isBlank(keyword) ? null : keyword,
                categoryIdList.size() == 0 ? null : categoryIdList);

        List<ProductListVO> productListVOList = Lists.newArrayList();

        for (Product product : productList) {
            productListVOList.add(assembleProductListVO(product));
        }

        PageInfo pageInfo = new PageInfo<>(productListVOList);

        return ServerResponse.createBySuccess(pageInfo);
    }
}
