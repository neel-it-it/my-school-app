package com.example.schoolmanagement.response.teacher_profile_display;

import com.google.gson.annotations.SerializedName;

public class TeacherProfileDisplayResponse{

	@SerializedName("staff_name")
	private String staffName;

	@SerializedName("staff_education")
	private String staffEducation;

	@SerializedName("staff_mobile no")
	private String staffMobileNo;

	@SerializedName("staff_address")
	private String staffAddress;

	@SerializedName("success")
	private int success;

	@SerializedName("staff_id")
	private String staffId;

	@SerializedName("class_teacher")
	private String classTeacher;

	@SerializedName("id")
	private String id;

	@SerializedName("staff_password")
	private String staffPassword;

	@SerializedName("message")
	private String message;

	@SerializedName("staff_email")
	private String staffEmail;

	@SerializedName("staff_joining_date")
	private String staffJoiningDate;

	public void setStaffName(String staffName){
		this.staffName = staffName;
	}

	public String getStaffName(){
		return staffName;
	}

	public void setStaffEducation(String staffEducation){
		this.staffEducation = staffEducation;
	}

	public String getStaffEducation(){
		return staffEducation;
	}

	public void setStaffMobileNo(String staffMobileNo){
		this.staffMobileNo = staffMobileNo;
	}

	public String getStaffMobileNo(){
		return staffMobileNo;
	}

	public void setStaffAddress(String staffAddress){
		this.staffAddress = staffAddress;
	}

	public String getStaffAddress(){
		return staffAddress;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setStaffId(String staffId){
		this.staffId = staffId;
	}

	public String getStaffId(){
		return staffId;
	}

	public void setClassTeacher(String classTeacher){
		this.classTeacher = classTeacher;
	}

	public String getClassTeacher(){
		return classTeacher;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStaffPassword(String staffPassword){
		this.staffPassword = staffPassword;
	}

	public String getStaffPassword(){
		return staffPassword;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStaffEmail(String staffEmail){
		this.staffEmail = staffEmail;
	}

	public String getStaffEmail(){
		return staffEmail;
	}

	public void setStaffJoiningDate(String staffMobileNo)
	{
		this.staffJoiningDate=staffJoiningDate;
	}

	public String getStaffJoiningDate()
	{
		return staffJoiningDate;
	}

	@Override
 	public String toString(){
		return 
			"TeacherProfileDisplayResponse{" + 
			"staff_name = '" + staffName + '\'' + 
			",staff_education = '" + staffEducation + '\'' + 
			",staff_mobile no = '" + staffMobileNo + '\'' + 
			",staff_address = '" + staffAddress + '\'' + 
			",success = '" + success + '\'' + 
			",staff_id = '" + staffId + '\'' + 
			",class_teacher = '" + classTeacher + '\'' + 
			",id = '" + id + '\'' + 
			",staff_password = '" + staffPassword + '\'' + 
			",message = '" + message + '\'' + 
			",staff_email = '" + staffEmail + '\'' +
			",staff_joining_date = '" + staffJoiningDate + '\'' +
			"}";
		}
}