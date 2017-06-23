package com.yu.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yu.entity.Pager;
import com.yu.entity.User;
import com.yu.model.Constant;
import com.yu.service.UserService;

@Controller
@RequestMapping("/user")
public class UserContrler {

	private User user;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/useradd.do")
	public String success(String name,Integer age,Double salary,String birthday,Float score) {
		
		System.out.println(age+name+salary+birthday+score);
		user = new User();
		user.setName(name);
		user.setAge(age);
		user.setBirthday(birthday);
		user.setSalary(salary);
		user.setScore((float)score);
		userService.addUser(user);
		System.out.println("数据添加成功");
		
		return "success";
	}
	@RequestMapping("/userlist.do")
	public ModelAndView userList(String pageNumStr,String pageSizeStr){
		int pageNum = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
		if (pageNumStr!=null&&!pageNumStr.trim().equals("")) {
			pageNum=Integer.parseInt(pageNumStr);
		}
		
		int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
		Pager<User> listuser=userService.findUser(pageNum, pageSize);
		return new ModelAndView("list", "listuser", listuser);
		
	}
	
	@RequestMapping("/deleteuser.do")
	public ModelAndView deleteUser(int id){
		userService.deleteUser(id);
		int pageNum = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
		int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
		Pager<User> listuser=userService.findUser(pageNum, pageSize);
		return new ModelAndView("list", "listuser", listuser);
	}
	
	@RequestMapping("/updateuser.do")
	public String updateUser(int userid,String name,Integer age,Double salary,String birthday,Float score) {
		user = new User();
		user.setName(name);
		user.setAge(age);
		user.setBirthday(birthday);
		user.setSalary(salary);
		user.setScore((float)score);
		userService.updateUser(userid, user);
		return "successup";
	}
		
	
}
