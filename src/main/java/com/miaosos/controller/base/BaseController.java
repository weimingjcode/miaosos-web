package com.miaosos.controller.base;

import com.miaosos.dao.security.SecurityDao;
import com.miaosos.service.miaosos.IMiaososService;
import com.miaosos.service.system.IRoleService;
import com.miaosos.service.system.IUserService;
import com.miaosos.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 基础的Controller类 所有controller 都需继承此类
 *
 * @auth zln
 * @create 2018-03-29 16:27
 */
@Configuration
@ConfigurationProperties(prefix = "miaosos.base")
@Controller
public class BaseController {

    @Autowired
    public IUserService userService;

    @Autowired
    public SecurityDao securityDao;

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public IMiaososService riskService;

    @Autowired
    public IRoleService roleService;

    @Autowired
    public WebSocketServer wss;

    private String projectName;  //项目名称

    private String sessionUser;  //sessionuser

    private String resourcePath;  //资源路径

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(String sessionUser) {
        this.sessionUser = sessionUser;
    }

    //获取ip
    public String getIp(){
        HttpServletRequest request = getRequest();
        String ip=request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || ip == "null" ||  "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || ip == "null" || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || ip == "null" || "unknown".equalsIgnoreCase(ip)){
            ip = getRequest().getRemoteAddr();
        }
        return ip;
    }

    //获取httpRequest
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        return request;
    }

    public void saveUser2Redis(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key,value,30, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }
}
