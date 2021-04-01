package com.example.schoolmanagement.response.stu_profile_display;

import com.google.gson.annotations.SerializedName;

public class StuProfileDisplayResponse{

	@SerializedName("Message")
	private String message;

	@SerializedName("class_id")
	private String classId;

	@SerializedName("mother_name")
	private String motherName;

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("div_id")
	private String divId;

	@SerializedName("stu_password")
	private String stuPassword;

	@SerializedName("stu_email_id")
	private String stuEmailId;

	@SerializedName("stu_mobile_no")
	private String stuMobileNo;

	@SerializedName("Success")
	private int success;

	@SerializedName("father_name")
	private String fatherName;

	@SerializedName("roll_no")
	private String rollNo;

	@SerializedName("stu_address")
	private String stuAddress;

	@SerializedName("stu_name")
	private String stuName;

	@SerializedName("id")
	private String id;

	@SerializedName("stu_addmision_id")
	private String stuAddmisionId;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setClassId(String classId){
		this.classId = classId;
	}

	public String getClassId(){
		return classId;
	}

	public void setMotherName(String motherName){
		this.motherName = motherName;
	}

	public String getMotherName(){
		return motherName;
	}

	public void setStudentId(String studentId){
		this.studentId = studentId;
	}

	public String getStudentId(){
		return studentId;
	}

	public void setDivId(String divId){
		this.divId = divId;
	}

	public String getDivId(){
		return divId;
	}

	public void setStuPassword(String stuPassword){
		this.stuPassword = stuPassword;
	}

	public String getStuPassword(){
		return stuPassword;
	}

	public void setStuEmailId(String stuEmailId){
		this.stuEmailId = stuEmailId;
	}

	public String getStuEmailId(){
		return stuEmailId;
	}

	public void setStuMobileNo(String stuMobileNo){
		this.stuMobileNo = stuMobileNo;
	}

	public String getStuMobileNo(){
		return stuMobileNo;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setFatherName(String fatherName){
		this.fatherName = fatherName;
	}

	public String getFatherName(){
		return fatherName;
	}

	public void setRollNo(String rollNo){
		this.rollNo = rollNo;
	}

	public String getRollNo(){
		return rollNo;
	}

	public void setStuAddress(String stuAddress){
		this.stuAddress = stuAddress;
	}

	public String getStuAddress(){
		return stuAddress;
	}

	public void setStuName(String stuName){
		this.stuName = stuName;
	}

	public String getStuName(){
		return stuName;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStuAddmisionId(String stuAddmisionId){
		this.stuAddmisionId = stuAddmisionId;
	}

	public String getStuAddmisionId(){
		return stuAddmisionId;
	}

	@Override
 	public String toString(){
		return 
			"StuProfileDisplayResponse{" + 
			"message = '" + message + '\'' + 
			",class_id = '" + classId + '\'' + 
			",mother_name = '" + motherName + '\'' + 
			",student_id = '" + studentId + '\'' + 
			",div_id = '" + divId + '\'' + 
			",stu_password = '" + stuPassword + '\'' + 
			",stu_email_id = '" + stuEmailId + '\'' + 
			",stu_mobile_no = '" + stuMobileNo + '\'' + 
			",success = '" + success + '\'' + 
			",father_name = '" + fatherName + '\'' + 
			",roll_no = '" + rollNo + '\'' + 
			",stu_address = '" + stuAddress + '\'' + 
			",stu_name = '" + stuName + '\'' + 
			",id = '" + id + '\'' + 
			",stu_addmision_id = '" + stuAddmisionId + '\'' + 
			"}";
		}
}