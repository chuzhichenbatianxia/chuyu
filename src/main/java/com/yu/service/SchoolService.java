package com.yu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yu.dao.SchoolDao;
import com.yu.entity.School;

@Service
public class SchoolService {

	@Autowired
	private SchoolDao schoolDao;
	
	//查询学校全部学生信息
	public List<School> queryStudentList(){
		
		return schoolDao.queryStudentList();
	}
	//插入学校信息
	public void insertStudentList(School school){
		
		schoolDao.insertStudentList(school);
	}
}
