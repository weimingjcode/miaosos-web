package com.miaosos.controller.system;

import com.miaosos.controller.base.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("system")
public class GroupManageController extends BaseController {

    @Secured({"ROLE_ADMIN"})
    @ApiOperation(value = "报险列表方法.权限:ROLE_ADMIN", notes = "跳转组织管理接口")
    @GetMapping(value = "/")
    public String list(@PathVariable Integer status, ModelMap modelMap) throws IOException {
        List<Map<String, String>> gpsInfoList = riskService.findGpsInfoByStatus(status);
        modelMap.addAttribute("gpsInfoList", gpsInfoList);
        modelMap.addAttribute("gps_status", status);
        return "/miaosos/miaosos/risk_list";
    }

}
