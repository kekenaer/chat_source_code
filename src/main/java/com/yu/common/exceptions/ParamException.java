package com.yu.common.exceptions;

public class ParamException extends Exception{

	private static final long serialVersionUID = 1314384781703810269L;
	
	private String msg;
	
	public ParamException(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		return this.msg;
	}
}
