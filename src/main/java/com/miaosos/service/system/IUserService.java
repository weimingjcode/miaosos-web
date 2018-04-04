package com.miaosos.service.system;

import com.miaosos.entity.SysUser;


public interface IUserService {

    boolean findIPInSysUser(String ip);

    SysUser findSysUserByUsernameAndPassword(SysUser user);
}
