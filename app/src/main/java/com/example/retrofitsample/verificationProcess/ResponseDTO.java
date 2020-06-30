package com.example.retrofitsample.verificationProcess;

import java.util.List;
import java.io.Serializable;

public class ResponseDTO implements Serializable {
	private boolean success;
	private List<String> errorCodes;

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setErrorCodes(List<String> errorCodes){
		this.errorCodes = errorCodes;
	}

	public List<String> getErrorCodes(){
		return errorCodes;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"success = '" + success + '\'' + 
			",error-codes = '" + errorCodes + '\'' + 
			"}";
		}
}