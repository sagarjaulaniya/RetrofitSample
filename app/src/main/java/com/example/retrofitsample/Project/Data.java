package com.example.retrofitsample.Project;

import java.io.Serializable;

public class Data implements Serializable {
	private int id;
	private String apiToken;
	private String name;
	private String email;
	private String mobile;
	private int outlets;
	private Object emailVerifiedAt;
	private String userType;
	private String createdAt;
	private String updatedAt;
	private Object deletedAt;
	private String time;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setApiToken(String apiToken){
		this.apiToken = apiToken;
	}

	public String getApiToken(){
		return apiToken;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	public void setOutlets(int outlets){
		this.outlets = outlets;
	}

	public int getOutlets(){
		return outlets;
	}

	public void setEmailVerifiedAt(Object emailVerifiedAt){
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public Object getEmailVerifiedAt(){
		return emailVerifiedAt;
	}

	public void setUserType(String userType){
		this.userType = userType;
	}

	public String getUserType(){
		return userType;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"id = '" + id + '\'' + 
			",api_token = '" + apiToken + '\'' + 
			",name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			",mobile = '" + mobile + '\'' + 
			",outlets = '" + outlets + '\'' + 
			",email_verified_at = '" + emailVerifiedAt + '\'' + 
			",user_type = '" + userType + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",time = '" + time + '\'' + 
			"}";
		}
}