package com.example.schoolmanagement.response;

import com.google.gson.annotations.SerializedName;

public class staff_profile_updateResponse {

	@SerializedName("success")
	private int success;

	@SerializedName("id")
	private String id;

	@SerializedName("message")
	private String message;

	@SerializedName("error")
	private String error;

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
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
			"Response1{" + 
			"success = '" + success + '\'' + 
			",id = '" + id + '\'' + 
			",message = '" + message + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}