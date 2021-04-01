package com.example.schoolmanagement.response.teacheraddhomework;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("homework_name")
	private String homeworkName;

	@SerializedName("class")
	private String jsonMemberClass;

	@SerializedName("homework_id")
	private String homework_id;

	public String getHomework_id() {
		return homework_id;
	}

	public void setHomework_id(String homework_id) {
		this.homework_id = homework_id;
	}

	public String getHomework_pdf() {
		return homework_pdf;
	}

	public void setHomework_pdf(String homework_pdf) {
		this.homework_pdf = homework_pdf;
	}

	@SerializedName("homework_pdf")
	private String homework_pdf;

	public void setHomeworkName(String homeworkName){
		this.homeworkName = homeworkName;
	}

	public String getHomeworkName(){
		return homeworkName;
	}

	public void setJsonMemberClass(String jsonMemberClass){
		this.jsonMemberClass = jsonMemberClass;
	}

	public String getJsonMemberClass(){
		return jsonMemberClass;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"homework_name = '" + homeworkName + '\'' + 
			",class = '" + jsonMemberClass + '\'' +
			",homework_id = '" + homework_id + '\'' +
			",homework_pdf = '" + homework_pdf + '\'' +
			"}";
		}
}