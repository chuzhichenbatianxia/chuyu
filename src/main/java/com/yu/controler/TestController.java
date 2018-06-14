package com.yu.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/1/29.
 */
@Controller
@RequestMapping("/gateway")
public class TestController {
    @RequestMapping("/poSynfd.do")
    @ResponseBody
    public String test(HttpServletRequest request, String name){
        String aa=request.getParameter("name");
        String name2=request.getParameter("name");
        System.out.println(aa);
        System.out.println(name);
        return "ss";
    }
}
