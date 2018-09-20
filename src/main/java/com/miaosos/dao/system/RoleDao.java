package com.miaosos.dao.system;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Auther zln
 * @Date 2018-09-19
 * @Description :
 */
@Repository
public interface RoleDao {

    @Select("select role_id,role_name,role_description from sys_role")
    List<Map<String,String>> findAllRole();
}
