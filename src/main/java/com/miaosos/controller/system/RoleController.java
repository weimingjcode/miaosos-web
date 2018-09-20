package com.miaosos.controller.system;

import com.miaosos.controller.base.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Auther zln
 * @Date 2018-09-14
 * @Description :
 */
@Controller
@RequestMapping("/system")
public class RoleController extends BaseController {

    @Secured({"ROLE_ADMIN"})
    @ApiOperation(value = "报险列表方法.权限:ROLE_ADMIN", notes = "获取所有角色")
    @GetMapping(value = "/getRole")
    @ResponseBody
    public Object getRole() {
        List<Map<String, String>> roles = roleService.findAllRole();
        return roles;
    }
}
