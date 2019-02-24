package top.mcwebsite.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.dao.CategoryMapper;
import top.mcwebsite.pojo.Category;
import top.mcwebsite.service.CategoryService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author mengchen
 * @time 18-12-4 下午7:40
 */
@Service
public class CategoryServiceImpl implements CategoryService {


    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ServerResponse addCatetgory(String categoryName, Integer parentId) {
        if (parentId == null || !StringUtils.isNotBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("添加商品的参数错误");
        }

        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        // 这个分类是可用
        category.setStatus(true);
        int rowCount = categoryMapper.insert(category);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("添加品类成功");
        }
        return ServerResponse.createByErrorMessage("添加品类失败");
    }

    @Override
    public ServerResponse updateCategoryName(Integer categoryId, String categoryName) {
        if (categoryId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createBySuccessMessage("更新品类参数错误");
        }
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);

        int rowCount = categoryMapper.updateByPrimaryKeySelective(category);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("更新品类名字成功");
        }
        return ServerResponse.createByErrorMessage("更新品类名字失败");
    }

    @Override
    public ServerResponse<List<Category>> getChildParallelCategory(Integer categoryId) {
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        if (CollectionUtils.isEmpty(categoryList)) {
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(categoryList);
    }

    /**
     * 递归查询id
     * @param categoryId
     * @return
     */
    @Override
    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId) {
        Set<Category> categorieSet = new HashSet<>();
        findChildCategory(categorieSet, categoryId);

        List<Integer> categoryIdList = new ArrayList<>();
        for (Category categoryItem : categorieSet) {
            categoryIdList.add(categoryItem.getId());
        }

        return ServerResponse.createBySuccess(categoryIdList);
    }

    private Set<Category> findChildCategory(Set<Category> categorySet, Integer categoryId) {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if (category != null) {
            categorySet.add(category);
        }
        // 查找子节点
        List<Category> categories = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        for (Category categoryItem : categories) {
            findChildCategory(categorySet, categoryItem.getId());
        }
        return categorySet;
    }
}
