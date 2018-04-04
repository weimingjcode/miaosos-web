package com.miaosos.utils;

import javax.servlet.http.Cookie;

public class MiaososUtils {

    public static Cookie createCookie(String token) {
        Cookie cookie = new Cookie("token",token);
        cookie.setMaxAge(60*30);//30分钟时效
        cookie.setPath("/");
        return cookie;
    }
}
