package com.miaosos.service.miaosos.impl;

import com.miaosos.controller.base.BaseService;
import com.miaosos.service.miaosos.IMiaososService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("riskService")
public class MiaososServiceImpl extends BaseService implements IMiaososService {
    @Override
    public List<Map<String, String>> findGpsInfoByStatus(Integer status) {
        return riskDao.findGpsInfoByStatus(status);
    }

    @Override
    public List<Map<String, String>> findGpsAddrByGpsInfoId(Integer gpsInfoId) {
        return riskDao.findGpsAddrByGpsInfoId(gpsInfoId);
    }
}
