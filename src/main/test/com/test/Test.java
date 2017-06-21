package com.test;

import com.yu.dao.UserDao;

public class Test {

	static UserDao userDao = new UserDao();
	public static void main(String[] args) {
//		String shoolName=userDao.querySchoolList().get(0).getSchool();
		String userName=userDao.queryUserList().get(0).getName();
		System.out.println(userName);
//		System.out.println(shoolName+"大天朝");
	}
}
