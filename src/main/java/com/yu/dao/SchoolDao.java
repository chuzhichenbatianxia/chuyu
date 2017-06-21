package com.yu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yu.entity.School;

@Repository
public class SchoolDao {
	
	private String town;
	private String factor;
	private String schoolName;
	private String schoolId;
	private String studentName;
	private String clas;
	private String studentId;
	private String parentsId;
	private Integer localIs;
	private Integer townIs;
	private String businessName;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//查询学校全部学生信息
	public List<School> queryStudentList(){
		
		String sql = "select *from school";
		List<School> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper<School>(School.class));
		return list;
	}
	//插入学校信息
	public void insertStudentList(School school){
		town=school.getTown();
		factor=school.getFactor();
		schoolName=school.getSchool();
		schoolId=school.getSchoolId();
		studentName=school.getStudentName();
		clas=school.getClas();
		studentId=school.getStudentId();
		parentsId=school.getParentsId();
		localIs=school.getLocalIs();
		townIs=school.getTownIs();
		businessName=school.getBusinessName();
		
		String sql="INSERT into school(town,factor,school,school_id,clas,student_name,student_id,parents_id,local_is,town_is,business_name) VALUE(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] object={town,factor,schoolName,schoolId,clas,studentName,studentId,parentsId,localIs,townIs,businessName};
		jdbcTemplate.update(sql, object);
	}
}
