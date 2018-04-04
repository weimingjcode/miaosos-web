package com.miaosos.controller.base;

import com.miaosos.dao.risk.IRiskDao;
import com.miaosos.dao.system.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    public IUserDao userDao;

    @Autowired
    public IRiskDao riskDao;
}
