package com.miaosos.controller.system;

import com.miaosos.controller.base.BaseController;
import com.miaosos.controller.base.Result;
import com.miaosos.entity.SysUser;
import com.miaosos.utils.MiaososUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;

@Controller
public class LoginController extends BaseController {


    @ApiOperation(value = "缺省,及index,跳转到登录页!", notes = "")
    @GetMapping(value = {"/"})
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("projectName", getProjectName());
        return "login";
    }

    @ApiOperation(value = "跳转登录页面", notes = "条状")
    @PostMapping("/toLogin")
    public String toLogin(ModelMap modelMap, SysUser user,HttpSession session) {
        Result result = new Result();
        String ip = getIp();
        System.out.println(ip + "======");
        if (userService.findIPInSysUser(ip)) {
            result.setMsg("您的ip:" + ip + "禁止登录!");
            modelMap.addAttribute(result);
            return "login";
        } else {
            user = userService.findSysUserByUsernameAndPassword(user);
            if (user != null) {
                session.setAttribute(getSessionUser(),user);
               // String token = UUID.randomUUID().toString().replace("-", "");
               // saveUser2Redis(token,user);
               // response.addCookie(MiaososUtils.createCookie(token));
            }else {
                result.setMsg("您的账号或密码错误!");
                modelMap.addAttribute(result);
                return "login";
            }
        }
        modelMap.addAttribute(result);
        return "home";
    }


    @ApiOperation(value = "登出功能!", notes = "")
    @GetMapping(value = {"/logout"})
    public String logout(HttpSession session) {
        session.removeAttribute(getSessionUser());
        return "login";
    }

}
