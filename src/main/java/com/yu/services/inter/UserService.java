package com.yu.services.inter;

import java.util.Map;

import com.yu.entity.User;

public interface UserService {
	
	User find(int userId) throws Exception;
	
	User find(String name)throws Exception;
	
	Map<String,Object> addUser(User user) throws Exception;
	
	Map<String,Object> updateUser(User user) throws Exception;

	Map<String,Object> checkUser(User user) throws Exception;
	
	
	
}
