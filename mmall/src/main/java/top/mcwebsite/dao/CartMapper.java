package top.mcwebsite.dao;

import org.apache.ibatis.annotations.Param;
import top.mcwebsite.pojo.Cart;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    Cart selectCartByUserIdProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    List<Cart> selectCartByUserId(@Param("userId") Integer userId);

    int selectCartProductCheckedStatusByUserId(Integer userId);

    int deleteByUserIdAndProductIds(@Param("userId") Integer userId, @Param("productIdList") List<String> productIdList);

    int checkedOrUncheckedProduct(@Param("userId") Integer userId, @Param("checked") Integer checked, @Param("productId") Integer productId);

    int selectCartProductCount(@Param("userId") Integer userId);
}
