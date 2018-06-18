package top.mcwebsite.mybatis.web.service.impl;

import com.sun.istack.internal.NotNull;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mcwebsite.mybatis.web.mapper.DictMapper;
import top.mcwebsite.mybatis.web.model.SysDict;
import top.mcwebsite.mybatis.web.service.DictService;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    public SysDict findById(@NotNull Long id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    public List<SysDict> findBySysDict(SysDict sysDict, Integer offset, Integer limit) {
        RowBounds rowBounds = RowBounds.DEFAULT;
        if (offset != null && limit != null) {
            rowBounds = new RowBounds(offset, limit);
        }
        return dictMapper.selectBySysDict(sysDict, rowBounds);
    }

    public boolean saveOrUpdate(SysDict sysDict) {
        if (sysDict.getId() == null) {
            return dictMapper.insert(sysDict) == 1;
        } else {
            return dictMapper.updateById(sysDict) == 1;
        }
    }

    public boolean deleteById(Long id) {
        return dictMapper.deleteById(id) == 1;
    }
}
