package com.yu.common.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yu.common.Validator;

@Component
public class UserEncrypt {
	@Autowired
	private Validator vd;
	
	private String method;
	
	public UserEncrypt(String method){
		this.method = method;
	}
	
	public String md5(String str) throws NoSuchAlgorithmException{
		MessageDigest  md = MessageDigest.getInstance(method);
		byte[] bs = null;
		if(!vd.isBlank(str)){
			bs = md.digest(str.getBytes());
		}
		return new String(bs);
	}
	
	public static void main(String[] args) {
		
	}
}
