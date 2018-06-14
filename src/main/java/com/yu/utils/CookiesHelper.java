package com.yu.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/26.
 */
public class CookiesHelper
{
    /**
     * 设置cookie
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param encrypt 是否加密
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, boolean encrypt) {
        setCookie(response,cookieName,cookieValue,0,encrypt);
    }

    /**
     * 设置cookie
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param expireTime 大于0表示cookie存活时间
     * @param encrypt 是否加密
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, int expireTime, boolean encrypt) {
        setCookie(response,cookieName,cookieValue,expireTime,null,encrypt);
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, int expireTime, String path, boolean encrypt) {
        setCookie(response,cookieName,cookieValue,expireTime,path,null,encrypt);
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, int expireTime, String path, String domain, boolean encrypt) {
        if(encrypt) {
            cookieValue = DES.Encrypt(cookieValue);
        }
        Cookie cookie = new Cookie(cookieName,cookieValue);
        if(expireTime>0) {
            cookie.setMaxAge(expireTime);
        }
        if(!StringHelper.isNullOrEmpty(path)) {
            cookie.setPath(path);
        }
        if(!StringHelper.isNullOrEmpty(domain)) {
            cookie.setDomain(domain);
        }
        response.addCookie(cookie);
    }

    /**
     * 读cookie
     * @param request
     * @param name
     * @param decrypt 是否需要解密
     * @return
     */
    public static String getCookieString(HttpServletRequest request, String name, boolean decrypt) {
        Cookie cookie =  getCookieByName(request,name);
        if(cookie==null) {
            return null;
        }
        if(decrypt) {
            return DES.Decrypt(cookie.getValue());
        }
        return cookie.getValue();
    }

    /**
     * 删除cookie
     * @param response
     * @param name
     */
    public static void deleteCookie(HttpServletResponse response, String name) {
    	deleteCookie(response,name,null);
	}
    public static void deleteCookie(HttpServletResponse response, String name, String path) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);
        if(!StringHelper.isNullOrEmpty(path)) {
            cookie.setPath(path);
        }
        response.addCookie(cookie);
    }


    /**
     * 根据名字获取cookie
     * @param request
     * @param name cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name){
        Map<String,Cookie> cookieMap = readCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }
    }

    /**
     * 获取所有的cookie值
     * @param request
     * @return
     */
    public static Map<String,Cookie> getCookies(HttpServletRequest request)
    {
        return readCookieMap(request);
    }


    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    private static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
