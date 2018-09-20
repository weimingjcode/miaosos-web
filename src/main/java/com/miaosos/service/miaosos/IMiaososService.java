package com.miaosos.service.miaosos;

import java.util.List;
import java.util.Map;

public interface IMiaososService {
    List findGpsInfoByStatus(Integer status);

    List<Map<String,String>> findGpsAddrByGpsInfoId(Integer gpsInfoId);
}
