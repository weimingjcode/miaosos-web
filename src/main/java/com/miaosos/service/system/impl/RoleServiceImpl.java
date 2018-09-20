package com.miaosos.service.system.impl;

import com.miaosos.dao.system.RoleDao;
import com.miaosos.service.system.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther zln
 * @Date 2018-09-19
 * @Description :
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Map<String, String>> findAllRole() {
        return roleDao.findAllRole();
    }
}
