package com.yu.entity;

import java.io.Serializable;

public class School implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String town;
	private String factor;
	private String school;
	private String schoolId;
	private String studentName;
	private String clas;
	private String studentId;
	private String parentsId;
	private Integer localIs;
	private Integer townIs;
	private String businessName;
	
	
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getFactor() {
		return factor;
	}
	public void setFactor(String factor) {
		this.factor = factor;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
	public String getParentsId() {
		return parentsId;
	}
	public void setParentsId(String parentsId) {
		this.parentsId = parentsId;
	}
	public Integer getLocalIs() {
		return localIs;
	}
	public void setLocalIs(Integer localIs) {
		this.localIs = localIs;
	}
	public Integer getTownIs() {
		return townIs;
	}
	public void setTownIs(Integer townIs) {
		this.townIs = townIs;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	@Override
	public String toString() {
		return "School [town=" + town + ", factor=" + factor + ", school=" + school + ", schoolId=" + schoolId
				+ ", studentName=" + studentName + ", clas=" + clas + ", studentId=" + studentId + ", parentsId="
				+ parentsId + ", localIs=" + localIs + ", townIs=" + townIs + ", businessName=" + businessName + "]";
	}
	

}
