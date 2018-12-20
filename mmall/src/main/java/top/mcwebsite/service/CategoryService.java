package top.mcwebsite.service;

import top.mcwebsite.common.ServerResponse;
import top.mcwebsite.pojo.Category;

import java.util.List;

/**
 * @author mengchen
 * @time 18-12-4 下午7:40
 */
public interface CategoryService {
    ServerResponse addCatetgory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
    ServerResponse<List<Category>> getChildParallelCategory(Integer categoryId);
    ServerResponse selectCategoryAndChildrenById(Integer categoryId);
}
