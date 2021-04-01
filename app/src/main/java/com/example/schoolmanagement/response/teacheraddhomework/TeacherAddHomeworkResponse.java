package com.example.schoolmanagement.response.teacheraddhomework;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TeacherAddHomeworkResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	@SerializedName("error")
	private String error;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

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

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"TeacherAddHomeworkResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}