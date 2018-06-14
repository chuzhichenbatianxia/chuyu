package com.yu.sso;

public class LoginUser {

	//登录用户
	private String userName;
	//登录时间
	private long loginTime;
	//登录票据
	private String loginTicket;
	//过期时间
	private long loginTimeOut;
	/**
	 * userName 登录用户账号
	 * loginTicket 登录票据
	 * loginTimeOut 票据过期时间,单位：分钟
	 * */
	public LoginUser(String userName, String loginTicket, long loginTimeOut) {
		this.userName=userName;
		this.loginTicket=loginTicket;
		this.loginTimeOut=loginTimeOut*1000*60;
		this.loginTime = System.currentTimeMillis();
	}
	
	public LoginUser() {
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginTicket() {
		return loginTicket;
	}
	public void setLoginTicket(String loginTicket) {
		this.loginTicket = loginTicket;
	}
	public long getLoginTimeOut() {
		return loginTimeOut;
	}
	public long setLoginTimeOut(long loginTimeOut) {
		return this.loginTimeOut=loginTimeOut*1000*60;
	}

}
