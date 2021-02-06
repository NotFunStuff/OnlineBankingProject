package com.se2_project.group8C18.demoEBanking.Helper;

import org.springframework.stereotype.Component;

@Component
public class ErrorType {
	
	
	
	public String getSuccesful() {
		return  "Successful";
	};
	
	public String getFail() {
		return "Fail";
	}
	
	public String isExisted(String nameObject) {
		return nameObject +  " is Existed";
	}
	
	public String isNotExisted(String nameObject) {
		return nameObject +  " is not Existed";
	}
	
	public String isValidated(String nameObject)
	{
		return nameObject + " is validated";
	}
	
	
	public String isExisted(int objectId) {
		return objectId +  " is Existed";
	}
	
	public String isNotExisted(int objectId) {
		return objectId +  " is not Existed";
	}
	
	public String isValidated(int objectId)
	{
		return objectId + " is validated";
	}
}
