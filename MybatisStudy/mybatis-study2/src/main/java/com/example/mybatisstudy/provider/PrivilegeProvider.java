package com.example.mybatisstudy.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * 权限Mapper对应的Provider的实现
 */
public class PrivilegeProvider {

    public String selectById(final Long id) {
        return new SQL() {
            {
                SELECT("id, privilege_name, privilege_url");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();
    }

}
