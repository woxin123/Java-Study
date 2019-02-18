package top.mcwebsite.study_mybatis.mapper;

import top.mcwebsite.study_mybatis.model.SysUser;

import java.util.List;

/**
 * @author mengchen
 * @time 18-12-24 下午8:16
 */
public interface UserMapper {
    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查询所有用户
     * @return
     */
    List<SysUser> selectAll();
}
