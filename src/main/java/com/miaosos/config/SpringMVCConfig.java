package com.miaosos.config;

import com.miaosos.controller.base.BaseController;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@ConfigurationProperties(prefix = "miaosos.base")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    public String excludePath;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("phonebar.html").setViewName("phonebar.html");
        registry.addViewController("index_v1.html").setViewName("index_v1.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        class MiaososoInterceptor extends HandlerInterceptorAdapter{
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (excludePath.contains(request.getServletPath())) {
                    return true;
                }else {
                    Cookie[] cookies = request.getCookies();
                    if (cookies == null) {
                        return false;
                    }
                }
                return true;
            }
        }
        registry.addInterceptor(new MiaososoInterceptor());
    }

    public String getExcludePath() {
        return excludePath;
    }

    public void setExcludePath(String excludePath) {
        this.excludePath = excludePath;
    }
}
