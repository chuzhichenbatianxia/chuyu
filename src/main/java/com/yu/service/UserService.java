package com.yu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yu.dao.UserDao;
import com.yu.entity.Pager;
import com.yu.entity.School;
import com.yu.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	//增加
	public void addUser(User user){
		
		userDao.addUser(user);
	}
	
	//查询全部记录
	public List<User> queryUserList(){
		
		return userDao.queryUserList();
	}
	
	//删除
	public void deleteUser(int id){
		
		userDao.deleteUser(id);
	}
	//修改
	public void updateUser(int id,User user){
		
		userDao.updateUser(id, user);
	}
	
	//分页查询
	/**
	 * 
	 * @param pageNum 
	 * 查询第几页数据
	 * @param pageSize
	 * 每页显示多少条数据
	 * @return
	 */
	public Pager<User> findUser(int pageNum,int pageSize){
		
		return userDao.findUser(pageNum, pageSize);
	}
}