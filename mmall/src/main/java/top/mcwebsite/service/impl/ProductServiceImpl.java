package top.mcwebsite.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mcwebsite.common.ResponseCodeEnum;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.dao.CategoryMapper;
import top.mcwebsite.dao.ProductMapper;
import top.mcwebsite.pojo.Category;
import top.mcwebsite.pojo.Product;
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

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

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
                int rowCount = productMapper.updateByPrimaryKey(product);
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
    public ServerResponse<ProductDetailVo> manageProductDetial(Integer productId) {
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
            productName = new StringBuilder().append("%s").append(productName).append("%").toString();
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
}
