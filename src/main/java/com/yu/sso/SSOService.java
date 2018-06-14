package com.yu.sso;

import com.yu.config.SerializeHelper;
import com.yu.entity.SysUser;
import com.yu.service.SysUserService;
import com.yu.utils.CookiesHelper;
import com.yu.utils.Encrypt;
import com.yu.utils.StringHelper;
import com.yu.utils.UrlHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sso")
public class SSOService {

    private Logger logger= LoggerFactory.getLogger(SSOService.class);

    @Resource
    private TicketManager ticketManager;

    @Resource
    private SerializeHelper serializeHelper;

    private String cookie_user="username";

    @Resource
    private SysUserService sysUserService;

    private Map<String,LoginUser> sessionIdMap=new HashMap<>();

    /*
     * 登录页面
     * service 调用登录地址的应用地址
     * */
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(String returnurl,HttpServletRequest request,HttpServletResponse response, ModelMap model){
        /**
         * 回调地址不为空，说明是其他应用的登录请求
         */
        if(!StringHelper.isNullOrEmpty(returnurl)) {
            /**
             * cookie没有过期，则从cookie获取票据
             */
            LoginUser user=null;
            String sessionId=request.getSession().getId();
            if (sessionIdMap.containsKey(sessionId)){
                user = ticketManager.getLoginUser(sessionId,request);
            }
            if(ticketManager.checkLogin(request,user)) {
                logger.info("检测到cookie未过期（票据："+user.getLoginTicket()+"），直接进行获取用户名操作");
                Map<String,String> map = new HashMap<>();
                map.put("ticket",user.getLoginTicket());
                return "redirect:" + UrlHelper.addParamByMap(returnurl,map);
            }
        }

        /*cookie过期，则显示登录界面*/
        model.addAttribute("returnurl",returnurl);
        String userName= CookiesHelper.getCookieString(request, cookie_user, false);
        model.addAttribute("username", userName);

        return "login";
    }

    /*
 * 登录验证操作
 */
    @RequestMapping(value="/doLogin",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String doLogin(String username, String password, HttpServletResponse response,HttpServletRequest request) {
        LoginResult result =new LoginResult();
        try {
            if(StringHelper.isNullOrEmpty(username)) {
                result.setCode(1);
                result.setMsg("用户名不能为空！");
                return serializeHelper.toJson(result);
            }
            if(StringHelper.isNullOrEmpty(password)) {
                result.setCode(2);
                result.setMsg("密码不能为空！");
                return serializeHelper.toJson(result);
            }
            SysUser dataUser = sysUserService.findUserByName(username);
            if(dataUser==null) {
                result.setCode(5);
                result.setMsg("用户名或密码不正确");
                return serializeHelper.toJson(result);
            }
            if(!username.equals(dataUser.getUserName()) || !password.equals(dataUser.getPassword())) {
                result.setCode(5);
                result.setMsg("用户名或密码不正确");
                return serializeHelper.toJson(result);
            }
            //登录成功，则cookie保留30天
            CookiesHelper.setCookie(response, cookie_user, username,30*24*60*60 ,false);
            String ticket = Encrypt.MD5(username + System.currentTimeMillis());

            LoginUser user = new LoginUser(username, ticket, 30);
            String sessionId=request.getSession().getId();
            sessionIdMap=new HashMap<>();
            ticketManager.setLogin(sessionId,response,user);
            sessionIdMap.put(sessionId,user);
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("ticket",ticket);
            result.setCode(0);
            result.setMsg("登录成功");
            result.setTicket(ticket);
            logger.info("账号密码验证成功，返回票据("+ticket+")供后续获取登录用户名！");
            return serializeHelper.toJson(result);
        } catch (Exception e) {
            result.setCode(999);
            result.setMsg("未知异常，请联系管理员！");
            return serializeHelper.toJson(result);
        }
    }

    /**
     * 根据票据获取登录用户账号(get方法)
     * @param ticket
     * @param token
     * @param returnurl
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/ticket",method=RequestMethod.GET) // 请求url地址映射，类似Struts的action-mapping
    public String getTicketService(String ticket, String token,String returnurl, HttpServletRequest request,HttpServletResponse response) {
        try {
            logger.info("接收到获取用户名的票据："+ticket+",token:"+token+"回调地址："+returnurl);
            if(!StringHelper.isNullOrEmpty(returnurl) && !StringHelper.isNullOrEmpty(ticket) && !StringHelper.isNullOrEmpty(token)) {
                //从cookie读登录信息
                String sessionId=request.getSession().getId();
                LoginUser user = ticketManager.getLoginUser(sessionId,request);
                String userName="";
                //存在登录信息
                if(ticketManager.checkLogin(request, user) && ticket.equals(user.getLoginTicket())) {
                    logger.info("检查到用户已经登录，则直接返回用户名："+user.getUserName());
                    userName = user.getUserName();

                    Map<String,String> map = new HashMap <>();
                    map.put("token",token);
                    map.put("ticket",user.getLoginTicket());
                    map.put("username",userName);
                    return "redirect:" + UrlHelper.addParamByMap(returnurl,map);
                }
            }
            returnurl = URLEncoder.encode(returnurl,"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:"+ request.getContextPath() +"/sso/login.do?returnurl="+returnurl;
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(String returnurl,HttpServletRequest request, HttpServletResponse response) {

        loginout(response,request);
        return "redirect:"+returnurl;
    }

    private void loginout(HttpServletResponse response,HttpServletRequest request) {
        String sessionId=request.getSession().getId();
        ticketManager.setLogout(sessionId,response);
        request.getSession().setAttribute("token",null);
        request.getSession().setAttribute("ticket",null);
        request.getSession().setAttribute("username",null);
    }

}
