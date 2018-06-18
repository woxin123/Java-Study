package top.mcwebsite.springbootmybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.mcwebsite.springbootmybatis.model.Country;


@Mapper
public interface CountryMapper {
	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	List<Country> selectAll();
}
