package top.mcwebsite.springbootmybatis.service;

import java.util.List;


public interface UserService {
	
	/**
	 * 通过 id 查询用户
	 * 
	 * @param id
	 * @return
	 */
	SysUser findById(Long id);
	
	/**
	 * 查询全部用户
	 * 
	 * @return
	 */
	List<SysUser> findAll();
}
