package com.miaosos.controller.record;

import com.miaosos.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PhoneRecordController extends BaseController {

    @GetMapping("phoneRecord/{gpsInfoId}")
    @ResponseBody
    public Object phoneRecord(@PathVariable("gpsInfoId") Integer gpsInfoId, int pageSize, int offset) {

       // List<Map<String, Object>> phoneRecordByGpsInfoId = riskService.findPhoneRecordByGpsInfoId(gpsInfoId);
        Map<String, Object> map = new HashMap<>();
        map.put("total", 100);
        map.put("rows", 10);
    //    map.put("result", phoneRecordByGpsInfoId);
        return map;
    }
}
