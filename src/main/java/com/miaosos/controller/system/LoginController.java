package com.miaosos.controller.system;

import com.miaosos.controller.base.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController {

    //@Secured("ROLE_ADMIN")//此方法只允许 ROLE_ADMIN 角色访问
    @ApiOperation(value = "跳转登录页面", notes = "条状")
    @GetMapping("/")
    public String toLogin(Model model) {
        String ip = getIp();
        System.out.println(ip + "======");
        if (!userService.findIPInSysUser(ip)) {
            model.addAttribute("ip","");
            return "login";
        }
        return "home";
    }


    @ApiOperation(value = "登出功能!", notes = "")
    @GetMapping(value = {"/logout"})
    public String logout(HttpSession session) {
        session.removeAttribute(getSessionUser());
        return "login";
    }

}
