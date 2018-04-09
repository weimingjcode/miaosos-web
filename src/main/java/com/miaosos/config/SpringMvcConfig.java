package com.miaosos.config;

import com.miaosos.entity.SysUser;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@ConfigurationProperties(prefix = "miaosos.base")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {


    public String sessionUser;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("phonebar.html").setViewName("phonebar.html");
        registry.addViewController("index_v1.html").setViewName("index_v1.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        class MiaososoInterceptor extends HandlerInterceptorAdapter {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String servletPath = request.getServletPath();
                SysUser user = (SysUser) request.getSession().getAttribute(sessionUser);
                if (user != null) {
                    return true;
                } else {
                    response.sendRedirect("/");
                    return false;
                }
            }
        }
        registry.addInterceptor(new MiaososoInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/toLogin");
    }

    public String getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(String sessionUser) {
        this.sessionUser = sessionUser;
    }
}
