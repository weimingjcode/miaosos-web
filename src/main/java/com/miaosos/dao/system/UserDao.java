package com.miaosos.dao.system;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Select("select count(*) from ip_manager where ipconfig=#{ip}")
    int findIPInSysUser(String ip);

 /*   @ResultType(SysUser.class)
    @Select("select " +
            "user_id,username,password,name,Rights,role_id,last_login,ip,status,bz,skin,email,number,phone,onlinestatus,province_id,phone_type,phone_pass" +
            " from sys_user where username=#{username} and password=#{password}")
    SysUser findSysUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);*/
}
