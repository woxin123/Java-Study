package com.example.mybatisstudy.mapper;

import com.example.mybatisstudy.model.SysPrivilege;
import com.example.mybatisstudy.provider.PrivilegeProvider;
import org.apache.ibatis.annotations.SelectProvider;

public interface PrivilegeMapper {

    @SelectProvider(type= PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);


}
