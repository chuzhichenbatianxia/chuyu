package com.yu.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017-6-8.
 */
public class UrlHelper
{
    /**
     * 获取完整的请求路径，包括：域名，端口，地址和参数
     * @param request
     * @return
     */
    public static String getFullUrl(HttpServletRequest request)
    {
        StringBuffer url = request.getRequestURL();
        String query = request.getQueryString();
        if(StringHelper.isNullOrEmpty(query))
        {
            return url.toString();
        }
        else
        {
            return url.append("?").append(query).toString();
        }
    }

    /**
     * 获取相对路径，包括：地址和参数
     * @param request
     * @return
     */
    public static String getFullUri(HttpServletRequest request)
    {
        String uri = request.getRequestURI();
        String query = request.getQueryString();
        if(StringHelper.isNullOrEmpty(query))
        {
            return uri;
        }
        else
        {
            return uri+"?"+query;
        }
    }

    /**
     * 只获取域名和端口
     * @param request
     * @return
     */
    public static String getDomain(HttpServletRequest request)
    {
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
    }

    public static String addParamByMap(String url, Map<String,String> objectMap)
    {
        if(objectMap==null)
        {
            return url;
        }
        Set<String> setKey = objectMap.keySet();
        for(String key:setKey)
        {
            String obj = objectMap.get(key);
            if(obj!=null)
            {
                url = addParamByName(url,key,obj);
            }
        }
        return url;
    }

    public static String addParamByName(String url, String name, String value)
    {
        return addParamByString(url,name+"="+value);
    }

    public static String addParamByString(String url, String queryString)
    {
        if(StringHelper.isNullOrEmpty(url))
        {
            return queryString;
        }
        if(url.contains("?"))
        {
            url = url+"&";
        }
        else
        {
            url = url+"?";
        }
        return url + queryString;
    }

}
