package com.miaosos.dao.security;

import com.miaosos.entity.SysRole;
import com.miaosos.entity.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Auther zln
 * @Date 2018-08-08
 * @Description :
 */
@Repository
public interface SecurityDao {


    @Select("select" +
                " u.user_id," +
                " u.username," +
                " u.password," +
                " u.number," +
                " u.onlinestatus," +
                " u.phone_type," +
                " u.phone_pass," +
                " ur.role_id " +
            "from " +
                "sys_user u " +
            "join " +
                 "sys_user_role ur" +
            " on " +
                "u.user_id=ur.sys_user_id " +
            "where " +
                "u.username=#{username}")
    @Results({
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "number", column = "number"),
            @Result(property = "onlinestatus", column = "onlinestatus"),
            @Result(property = "phone_type", column = "phone_type"),
            @Result(property = "phone_pass", column = "phone_pass"),
            @Result(property = "role", column = "role_id", one = @One(select = "com.miaosos.dao.security.SecurityDao.findByUserRole")),
            @Result(property = "pPermission", column = "role_id", many = @Many(select = "com.miaosos.dao.security.SecurityDao.findPpermission")),
            @Result(property = "cPermission", column = "role_id", many = @Many(select = "com.miaosos.dao.security.SecurityDao.findCpermission"))
    })
    SysUser findByUserName(@Param("username") String username);


    /**
     * 获取角色
     * @param role_id
     * @return
     */
    @Results({
            @Result(property = "role_id", column = "role_id"),
            @Result(property = "role_name", column = "role_name"),
    })
    @Select("select role_id,role_name from sys_role where role_id=#{role_id}")
    List<SysRole> findByUserRole(@Param("role_id") Integer role_id);


    @Select("select permission_id,permission_name,permission_url,permission_description,permission_pid,url_icon,permission_order from sys_permission where permission_order is not null  order by permission_order asc")
    List<Map<String, String>> findPPermission();

    @Select("select permission_id,permission_name,permission_url,permission_description,permission_pid,url_icon,permission_order from sys_permission where permission_pid is not null")
    List<Map<String, String>> findCPermission();


    /**
     * 查找父级菜单
     * @param role_id
     * @return
     */
    @Select("select " +
            "p.permission_id," +
            "p.permission_name," +
            "p.permission_url," +
            "p.permission_description," +
            "p.permission_pid," +
            "p.url_icon," +
            "p.permission_order," +
            "p.permission_tag_id " +
            "from Sys_permission p " +
            "JOIN Sys_permission_role spr on p.permission_id = spr.permission_id " +
            "where " +
            " spr.role_id= #{role_id} " +
            " and p.permission_order is not null and spr.status = 1  order by p.permission_order asc"
    )
    List<Map<String, String>> findPpermission(@Param("role_id") Integer role_id);

    /**
     * 查找子级菜单
     * @param role_id
     * @return
     */
    @Select("select " +
            "p.permission_id," +
            "p.permission_name," +
            "p.permission_url," +
            "p.permission_description," +
            "p.permission_pid," +
            "p.url_icon," +
            "p.permission_order," +
            "p.permission_tag_id " +
            "from Sys_permission p " +
            "JOIN Sys_permission_role spr on p.permission_id = spr.permission_id " +
            "where " +
            "spr.role_id= #{role_id}" +
            " and p.permission_pid is not null and spr.status = 1 order by p.permission_id asc"
    )
    List<Map<String, String>> findCpermission(@Param("role_id") Integer role_id);
}
