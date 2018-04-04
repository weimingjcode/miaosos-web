package com.miaosos.service.system.impl;

import com.miaosos.controller.base.BaseService;
import com.miaosos.entity.SysUser;
import com.miaosos.service.system.IUserService;
import com.miaosos.utils.Encrypt;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BaseService implements IUserService {
    public boolean findIPInSysUser(String ip) {
        if (userDao.findIPInSysUser(ip) > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SysUser findSysUserByUsernameAndPassword(SysUser user) {
        return  userDao.findSysUserByUsernameAndPassword(user.getUsername(), Encrypt.md5AndSha(user.getUsername()+user.getPassword()));
    }
}
