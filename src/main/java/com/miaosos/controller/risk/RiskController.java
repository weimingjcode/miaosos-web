package com.miaosos.controller.risk;

import com.miaosos.controller.base.BaseController;
import com.miaosos.entity.PageResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("risk")
public class RiskController extends BaseController {

    @ApiOperation(value = "报险列表方法.", notes = "根据状态不同,获取不同的报险信息!")
    @GetMapping(value = "/{status}")
    public String list(@PathVariable Integer status, ModelMap modelMap) {
        List gpsInfoList = riskService.findGpsInfoByStatus(status);
        modelMap.addAttribute("gpsInfoList",gpsInfoList);
        modelMap.addAttribute("gps_status",status);
        return "/miaosos/risk_list";
    }
}
