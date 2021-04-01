package com.example.schoolmanagement.response.staff_profile_display;

import com.google.gson.annotations.SerializedName;

public class StaffProfileDisplayResponse{

	@SerializedName("staff password")
	private String staffPassword;

	@SerializedName("class teacher")
	private String classTeacher;

	@SerializedName("staff address")
	private String staffAddress;

	@SerializedName("success")
	private int success;

	@SerializedName("staff name")
	private String staffName;

	@SerializedName("message")
	private String message;

	@SerializedName("staff email")
	private String staffEmail;

	@SerializedName("staff education")
	private String staffEducation;

	@SerializedName("staff mobile no")
	private String staffMobileNo;

	public void setStaffPassword(String staffPassword){
		this.staffPassword = staffPassword;
	}

	public String getStaffPassword(){
		return staffPassword;
	}

	public void setClassTeacher(String classTeacher){
		this.classTeacher = classTeacher;
	}

	public String getClassTeacher(){
		return classTeacher;
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

	public void setStaffName(String staffName){
		this.staffName = staffName;
	}

	public String getStaffName(){
		return staffName;
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

	@Override
 	public String toString(){
		return 
			"StaffProfileDisplayResponse{" + 
			"staff password = '" + staffPassword + '\'' + 
			",class teacher = '" + classTeacher + '\'' + 
			",staff address = '" + staffAddress + '\'' + 
			",success = '" + success + '\'' + 
			",staff name = '" + staffName + '\'' + 
			",message = '" + message + '\'' + 
			",staff email = '" + staffEmail + '\'' + 
			",staff education = '" + staffEducation + '\'' + 
			",staff mobile no = '" + staffMobileNo + '\'' + 
			"}";
		}
}