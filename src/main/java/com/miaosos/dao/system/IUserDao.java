package com.miaosos.dao.system;

import com.miaosos.entity.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IUserDao {

    @Select("select count(*) from ipmanager where ipconfig=#{ip}")
    int findIPInSysUser(String ip);

    @ResultType(SysUser.class)
    @Select("select " +
            "user_id,username,password,name,Rights,role_id,last_login,ip,status,bz,skin,email,number,phone,onlinestatus,province_id,phone_type,phone_pass" +
            " from sys_user where username=#{username} and password=#{password}")
    SysUser findSysUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
