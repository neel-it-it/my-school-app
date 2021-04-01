package com.example.schoolmanagement.response.stu_homework;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class StuHomeworkResponse{

	@SerializedName("data")
	private List<HomeworkDataItem> data;

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	@SerializedName("error")
	private String error;

	public void setData(List<HomeworkDataItem> data){
		this.data = data;
	}

	public List<HomeworkDataItem> getData(){
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
			"StuHomeworkResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}