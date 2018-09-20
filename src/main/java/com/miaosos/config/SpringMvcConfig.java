package com.miaosos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ConfigurationProperties(prefix = "miaosos.base")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {


    public String sessionUser;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //电话系统
        registry.addViewController("phonebar.html").setViewName("phonebar.html");
        //首页
        registry.addViewController("index_v1.html").setViewName("index_v1.html");
        //登录
        registry.addViewController("login").setViewName("login");
        //
        registry.addViewController("/system/role").setViewName("/system/role");
        //registry.addViewController("/").setViewName("home");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

   /* @Override
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
    }*/

    public String getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(String sessionUser) {
        this.sessionUser = sessionUser;
    }
}
