package top.mcwebsite.study_mybatis.mapper;

import top.mcwebsite.study_mybatis.model.SysRole;

/**
 * @author mengchen
 * @time 18-12-29 下午9:52
 */
public interface RoleMapper {
    SysRole selectById(long id);
}
