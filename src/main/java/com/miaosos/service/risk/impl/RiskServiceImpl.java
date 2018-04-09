package com.miaosos.service.risk.impl;

import com.miaosos.controller.base.BaseService;
import com.miaosos.service.risk.IRiskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("riskService")
public class RiskServiceImpl extends BaseService implements IRiskService {
    @Override
    public List<Map<String, String>> findGpsInfoByStatus(Integer status) {
        return riskDao.findGpsInfoByStatus(status);
    }

    @Override
    public List<Map<String, String>> findGpsAddrByGpsInfoId(Integer gpsInfoId) {
        return riskDao.findGpsAddrByGpsInfoId(gpsInfoId);
    }
}
