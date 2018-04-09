package com.miaosos.service.risk;

import java.util.List;
import java.util.Map;

public interface IRiskService {
    List findGpsInfoByStatus(Integer status);

    List<Map<String,String>> findGpsAddrByGpsInfoId(Integer gpsInfoId);
}
