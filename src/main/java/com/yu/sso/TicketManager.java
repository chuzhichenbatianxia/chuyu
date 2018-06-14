package com.yu.sso;

import com.yu.config.SerializeHelper;
import com.yu.utils.CookiesHelper;
import com.yu.utils.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class TicketManager {
	private Map<String, LoginUser> tickets;
	private final String cookie_sso;
	@Autowired
	private SerializeHelper serializeHelper;

	public TicketManager() {
		tickets = new HashMap<String, LoginUser>();
		cookie_sso ="hdkj_sso";
	}

	/**
	 * 根据ticket缓存登录信息
	 * @param ticket
	 * @param user
	 */
	public synchronized void cacheLoginUser(String ticket, LoginUser user) {
		tickets.put(ticket, user);
	}

	/**
	 * 获取已缓存的登录信息
	 * @param ticket
	 * @return
	 */
	public synchronized LoginUser getCacheLoginUser(String ticket) {
		if(StringHelper.isNullOrEmpty(ticket))
		{
			return null;
		}
		return tickets.remove(ticket);
	}

	/**
	 * 写登录信息到cookie
	 * @param response
	 * @param user
	 * @return
	 */
	public boolean setLogin(String sessionId,HttpServletResponse response, LoginUser user) {

		if(user==null) {
			return false;
		}
		CookiesHelper.setCookie(response, sessionId, serializeHelper.toJson(user),0,"/", true);
		return true;
	}

	/**
	 * 从cookie中获取登录信息
	 * @param request
	 * @return
	 */
	public LoginUser getLoginUser(String sessionId,HttpServletRequest request) {
		String cookieString =CookiesHelper.getCookieString(request, sessionId, true);
		if(StringHelper.isNullOrEmpty(cookieString)) {
			return null;
		}
		return serializeHelper.toObject(cookieString,LoginUser.class);
	}

	/**
	 * 注销登录，删除cookie登录信息
	 * @param response
	 */
	public void setLogout(String sessionId,HttpServletResponse response) {
		CookiesHelper.deleteCookie(response, sessionId,"/");
	}

	/**
	 * 检查登录状态
	 * @param request
	 * @param user
	 * @return
	 */
	public boolean checkLogin(HttpServletRequest request, LoginUser user) {
		if(user==null) {
			return false;
		}
		if(StringHelper.isNullOrEmpty(user.getUserName())) {
			return false;
		}
		long time = System.currentTimeMillis()-user.getLoginTime();
		return time<user.getLoginTimeOut();
	}
}
