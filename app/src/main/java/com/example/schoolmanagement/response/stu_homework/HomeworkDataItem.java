package com.example.schoolmanagement.response.stu_homework;

import com.google.gson.annotations.SerializedName;

public class HomeworkDataItem {

	@SerializedName("homework_pdf")
	private String homeworkPdf;

	@SerializedName("homework_name")
	private String homeworkName;

	@SerializedName("sub_name")
	private String subName;

	@SerializedName("class_id")
	private String classId;

	@SerializedName("div_id")
	private String divId;

	@SerializedName("id")
	private String id;

	@SerializedName("time_upload")
	private String timeUpload;

	public void setHomeworkPdf(String homeworkPdf){
		this.homeworkPdf = homeworkPdf;
	}

	public String getHomeworkPdf(){
		return homeworkPdf;
	}

	public void setHomeworkName(String homeworkName){
		this.homeworkName = homeworkName;
	}

	public String getHomeworkName(){
		return homeworkName;
	}

	public void setSubName(String subName){
		this.subName = subName;
	}

	public String getSubName(){
		return subName;
	}

	public void setClassId(String classId){
		this.classId = classId;
	}

	public String getClassId(){
		return classId;
	}

	public void setDivId(String divId){
		this.divId = divId;
	}

	public String getDivId(){
		return divId;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTimeUpload(String timeUpload){
		this.timeUpload = timeUpload;
	}

	public String getTimeUpload(){
		return timeUpload;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"homework_pdf = '" + homeworkPdf + '\'' + 
			",homework_name = '" + homeworkName + '\'' + 
			",sub_name = '" + subName + '\'' + 
			",class_id = '" + classId + '\'' + 
			",div_id = '" + divId + '\'' + 
			",id = '" + id + '\'' + 
			",time_upload = '" + timeUpload + '\'' + 
			"}";
		}
}