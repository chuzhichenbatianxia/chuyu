package com.yu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yu.entity.Pager;
import com.yu.entity.School;
import com.yu.entity.User;


@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//增加
	public void addUser(User user){
		String sql="INSERT into jdbctest_tab(name,age,salary,birthday,score) VALUE(?,?,?,?,?)";
		Object[] object={user.getName(),user.getAge(),user.getSalary(),user.getBirthday(),user.getScore()};
		jdbcTemplate.update(sql, object);
	}

	//查询全部用户记录
	public List<User> queryUserList(){
		String sql = "select *from jdbctest_tab";
		List<User> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return list;
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
		Pager<User> result=null;
		//定义统计查询语句
		String sqlCount="select *from jdbctest_tab";
		List<User> listCount=jdbcTemplate.query(sqlCount, new BeanPropertyRowMapper<User>(User.class));
		//获取总记录数
		int totalRecord=listCount.size();
		/**
		 * 获取总页数
		 */
		int totalPage = totalRecord / pageSize;
		if(totalRecord % pageSize !=0){
			totalPage++;
		}
		//校验pageNum
		if (pageNum>=totalPage) {
			pageNum=totalPage;
		}
		if (pageNum<=1) {
			pageNum=1;
		}
		//起始索引
		int fromIndex	= pageSize * (pageNum -1);
		//使用limit组装分页查询语句
		String sql="select *from jdbctest_tab limit ?,?";
		Object[] args={fromIndex,pageSize};
		List<User> listUser=jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<User>(User.class));


		result=new Pager<>(pageSize, pageNum, totalRecord, totalPage, listUser);
		return result;
	}
	//删除
	public void deleteUser(int id){
		String sql="delete from jdbctest_tab where id=?";
		jdbcTemplate.update(sql,new Object[]{id});
	}
	
	//修改
	public void updateUser(int id,User user){
		String sql="update jdbctest_tab set name='"+user.getName()+"',age='"+user.getAge()+"',salary='"+user.getSalary()+"',birthday='"+user.getBirthday()+"',score='"+user.getScore()+"' where id=?";
		jdbcTemplate.update(sql, id);
	}
	
}
