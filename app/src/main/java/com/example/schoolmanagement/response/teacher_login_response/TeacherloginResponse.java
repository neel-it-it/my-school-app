package com.example.schoolmanagement.response.teacher_login_response;

import com.google.gson.annotations.SerializedName;

public class TeacherloginResponse{

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	@SerializedName("staffid")
	private String staffid;

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStaffid(String staffid){
		this.staffid = staffid;
	}

	public String getStaffid(){
		return staffid;
	}

	@Override
 	public String toString(){
		return 
			"TeacherloginResponse{" + 
			"success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			",staffid = '" + staffid + '\'' + 
			"}";
		}
}