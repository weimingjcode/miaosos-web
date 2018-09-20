package com.miaosos.controller.miaosos;

import com.miaosos.controller.base.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("miaosos")
public class MiaososController extends BaseController {


    @Secured({"ROLE_ADMIN","ROLE_LEADER","ROLE_HEADMAN","ROLE_CUSTOM_SERVICE","ROLE_TEST"})
    @ApiOperation(value = "报险列表方法.权限:ROLE_ADMIN,ROLE_LEADER,ROLE_HEADMAN,ROLE_CUSTOM_SERVICE,ROLE_TEST", notes = "根据状态不同,获取不同的报险信息!")
    @GetMapping(value = "/{status}")
    public String list(@PathVariable Integer status, ModelMap modelMap) throws IOException {
        wss.sendMessage("hello websocket");
        List<Map<String, String>> gpsInfoList = riskService.findGpsInfoByStatus(status);
        modelMap.addAttribute("gpsInfoList", gpsInfoList);
        modelMap.addAttribute("gps_status", status);
        return "/miaosos/miaosos";
    }

    @ApiOperation(value = "通过GPSInfoId获取相应的报险信息.", notes = "根据id不同,获取不同的位置信息!")
    @GetMapping(value = "gpsAddr/{gpsInfoId}")
    @ResponseBody
    public Object findGpsAddrByGpsInfoId(@PathVariable Integer gpsInfoId) {
        List<Map<String, String>> gpsAddrList = riskService.findGpsAddrByGpsInfoId(gpsInfoId);
        return gpsAddrList;
    }
}
