package com.example.retrofitsample.Project;

import java.io.Serializable;

public class Response implements Serializable {
	private boolean jsonMemberReturn;
	private String message;
	private Data data;

	public void setJsonMemberReturn(boolean jsonMemberReturn){
		this.jsonMemberReturn = jsonMemberReturn;
	}

	public boolean isJsonMemberReturn(){
		return jsonMemberReturn;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"return = '" + jsonMemberReturn + '\'' + 
			",message = '" + message + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}